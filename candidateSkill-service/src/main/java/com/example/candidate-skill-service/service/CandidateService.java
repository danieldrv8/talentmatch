package com.example.database_service.service;

import com.example.database_service.dto.CandidateDTO;
import com.example.database_service.entity.Candidate;
import com.example.database_service.entity.Skill;
import com.example.database_service.repository.CandidateRepository;
import com.example.database_service.repository.SkillRepository;
import com.example.database_service.utils.ConvertDTO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CandidateService {

    private final CandidateRepository candidateRepository;
    private final SkillRepository skillRepository;

    @Autowired
    public CandidateService(CandidateRepository candidateRepository, SkillRepository skillRepository) {
        this.candidateRepository = candidateRepository;
        this.skillRepository = skillRepository;
    }

    @Transactional
    public Candidate save(CandidateDTO candidateDTO) {
        Set<Skill> skills = candidateDTO.getSkillIds().stream()
                .map(skillRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());

        Candidate candidate = ConvertDTO.convertToCandidate(candidateDTO);
        candidate.setSkills(skills);
        return candidateRepository.save(candidate);
    }

    public Candidate findById(Long id) {
        return candidateRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Candidate not found"));
    }

    public List<Candidate> findAll() {
        return candidateRepository.findAll();
    }

    public void deleteById(Long id) {
        if (!candidateRepository.existsById(id)) {
            throw new EntityNotFoundException("Candidate not found");
        }
        candidateRepository.deleteById(id);
    }

    @Transactional
    public Candidate update(Long id, CandidateDTO candidateDTO) {
        Candidate candidate = candidateRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Candidate not found"));

        candidate.setCandidateName(candidateDTO.getCandidateName());
        candidate.setEmail(candidateDTO.getEmail());
        candidate.setDasId(candidateDTO.getDasId());

        Set<Skill> skills = candidateDTO.getSkillIds().stream()
                .map(skillRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());

        candidate.setSkills(skills);
        return candidateRepository.save(candidate);
    }
}