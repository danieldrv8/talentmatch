package com.example.candidateSkillService.service.impl;

import com.example.candidateSkillService.dto.CandidateDTO;
import com.example.candidateSkillService.dto.CandidateSkillDTO;
import com.example.candidateSkillService.repository.CandidateSkillRespository;
import com.example.candidateSkillService.service.CandidateSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateSkillServiceImpl implements CandidateSkillService {

    @Autowired
    private CandidateSkillRespository candidateSkillRespository;

    @Override
    public CandidateSkillDTO save(CandidateSkillDTO candidateSkill) {
        return null;
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
