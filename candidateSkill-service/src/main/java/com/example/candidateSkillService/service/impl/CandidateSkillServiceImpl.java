package com.example.candidateSkillService.service.impl;

import com.example.candidateSkillService.dto.CandidateDTO;
import com.example.candidateSkillService.dto.CandidateSkillDTO;
import com.example.candidateSkillService.entity.Candidate;
import com.example.candidateSkillService.entity.CandidateSkill;
import com.example.candidateSkillService.entity.Skill;
import com.example.candidateSkillService.repository.CandidateSkillRespository;
import com.example.candidateSkillService.service.CandidateSkillService;
import com.example.candidateSkillService.utils.ConvertDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateSkillServiceImpl implements CandidateSkillService {

    @Autowired
    private CandidateSkillRespository candidateSkillRespository;

    @Override
    public CandidateSkillDTO save(CandidateSkillDTO candidateSkillDTO, Candidate candidate, Skill skill) {
        CandidateSkill candidateSkill = ConvertDTO.convertToCandidateSkill(candidateSkillDTO, candidate, skill);
        return ConvertDTO.convertToCandidateSkillDTO(candidateSkillRespository.save(candidateSkill));
    }

    @Override
    public CandidateSkillDTO update(CandidateSkillDTO candidateSkill) {
        return null;
    }

    @Override
    public void delete(CandidateDTO candidateSkillDTO) {

    }

    @Override
    public CandidateSkillDTO findById(Long id) {
        return null;
    }

    @Override
    public List<CandidateSkillDTO> findAll() {
        return null;
    }
}
