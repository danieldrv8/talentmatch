package com.example.candidateSkillService.service;

import com.example.candidateSkillService.dto.CandidateDTO;
import com.example.candidateSkillService.dto.CandidateSkillDTO;

import java.util.List;

public interface CandidateSkillService {
    CandidateSkillDTO save(CandidateSkillDTO candidateSkill);
    CandidateSkillDTO update(CandidateSkillDTO candidateSkill);
    void delete(CandidateDTO candidateSkillDTO);
    CandidateSkillDTO findById(Long id);
    List<CandidateSkillDTO> findAll();
}
