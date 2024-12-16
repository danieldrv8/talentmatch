package com.example.candidateSkillService.service;

import com.example.candidateSkillService.dto.CandidateDTO;
import com.example.candidateSkillService.dto.CandidateSkillDTO;
import com.example.candidateSkillService.entity.Candidate;
import com.example.candidateSkillService.entity.CandidateSkill;
import com.example.candidateSkillService.entity.Skill;

import java.util.List;

public interface CandidateSkillService {
    CandidateSkillDTO save(CandidateSkillDTO candidateSkill, Candidate candidate, Skill skill);
    CandidateSkillDTO update(CandidateSkillDTO candidateSkill);
    void delete(CandidateDTO candidateSkillDTO);
    CandidateSkillDTO findById(Long id);
    List<CandidateSkillDTO> findAll();
}
