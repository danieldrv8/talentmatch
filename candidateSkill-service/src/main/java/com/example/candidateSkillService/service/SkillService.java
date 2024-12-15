package com.example.candidateSkillService.service;

import com.example.candidateSkillService.dto.SkillDTO;

import java.util.List;

public interface SkillService {
    SkillDTO getSkillById(Long id);
    SkillDTO createSkill(SkillDTO skillDTO);
    List<SkillDTO> getAllSkills();
    void deleteSkill(Long id);
    SkillDTO updateSkill(Long id, SkillDTO skillDTO);
}
