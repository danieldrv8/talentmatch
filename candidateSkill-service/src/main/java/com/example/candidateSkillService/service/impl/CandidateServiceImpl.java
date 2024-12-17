package com.example.candidateSkillService.service.impl;
import com.example.candidateSkillService.dto.CandidateDTO;
import com.example.candidateSkillService.dto.CandidateResponseDTO;
import com.example.candidateSkillService.dto.CandidateSkillDTO;
import com.example.candidateSkillService.dto.SkillDTO;
import com.example.candidateSkillService.entity.Candidate;
import com.example.candidateSkillService.entity.CandidateSkill;
import com.example.candidateSkillService.entity.Skill;
import com.example.candidateSkillService.repository.CandidateRepository;
import com.example.candidateSkillService.repository.SkillRepository;
import com.example.candidateSkillService.service.CandidateService;
import com.example.candidateSkillService.service.CandidateSkillService;
import com.example.candidateSkillService.utils.ConvertDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private CandidateSkillService candidateSkillService;

    @Autowired
    private SkillRepository skillRepository;

    @Override
    public CandidateResponseDTO getCandidateById(Long id) {
        Candidate candidate = candidateRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Candidate not found"));
        CandidateResponseDTO candidateResponseDTO = ConvertDTO.candidateResponseDTO(candidate);
        candidateResponseDTO.setSkills(skillRepository.findById(candidate.getId()).stream().map(ConvertDTO::convertToSkillDTO).collect(Collectors.toSet()));
        return candidateResponseDTO;
    }

    @Override
    public CandidateDTO createCandidate(CandidateDTO candidateDTO) {
        Candidate candidate = ConvertDTO.convertToCandidate(candidateDTO);

        List<CandidateSkill> candidateSkills = new ArrayList<>();
        for (CandidateSkillDTO candidateSkillDTO : candidateDTO.getCandidateSkills()) {
            Skill skill = skillRepository.findById(candidateSkillDTO.getSkillId())
                    .orElseThrow(() -> new EntityNotFoundException("Skill not found with id: " + candidateSkillDTO.getSkillId()));

            CandidateSkill candidateSkill = ConvertDTO.convertToCandidateSkill(candidateSkillDTO, candidate, skill);
            candidateSkills.add(candidateSkill);
        }

        candidate.setCandidateSkills(candidateSkills);
        Candidate savedCandidate = candidateRepository.save(candidate);

        return ConvertDTO.convertToCandidateDTO(savedCandidate);
    }


    @Override
    public List<CandidateResponseDTO> getAllCandidates() {
        List<CandidateResponseDTO> candidates = new ArrayList<>();
        for (Candidate candidate : candidateRepository.findAll()) {
            CandidateResponseDTO candidateResponseDTO = ConvertDTO.candidateResponseDTO(candidate);
            candidateResponseDTO.setSkills(skillRepository.findById(candidate.getId()).stream().map(ConvertDTO::convertToSkillDTO).collect(Collectors.toSet()));
            candidates.add(candidateResponseDTO);
        }
        return candidates;
    }

    @Override
    public void deleteCandidate(Long id) {
        candidateRepository.deleteById(id);
    }

    @Override
    public CandidateDTO updateCandidate(Long id, CandidateDTO candidateDTO) {
        Candidate candidate = candidateRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Candidate not found"));
        CandidateDTO candidateToUpdate = ConvertDTO.convertToCandidateDTO(candidate);
        candidateToUpdate.setId(id);
        candidateToUpdate.setCandidateName(candidateDTO.getCandidateName());
        candidateToUpdate.setEmail(candidateDTO.getEmail());
        candidateToUpdate.setDasId(candidateDTO.getDasId());
        candidateToUpdate.setCandidateSkills(candidateDTO.getCandidateSkills());
        return ConvertDTO.convertToCandidateDTO(candidateRepository.save(candidate));
    }

}