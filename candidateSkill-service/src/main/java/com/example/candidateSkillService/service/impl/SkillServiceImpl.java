package com.example.candidateSkillService.service.impl;

import com.example.candidateSkillService.dto.SkillDTO;
import com.example.candidateSkillService.entity.Skill;
import com.example.candidateSkillService.repository.SkillRepository;
import com.example.candidateSkillService.service.SkillService;
import com.example.candidateSkillService.utils.ConvertDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillRepository skillRepository;

    @Override
    public SkillDTO getSkillById(Long id) {
        Skill skill = skillRepository.findById(id).orElse(null);
        return ConvertDTO.convertToSkillDTO(skill);
    }

    @Override
    public SkillDTO createSkill(SkillDTO skillDTO) {
        Skill skill = ConvertDTO.convertToSkill(skillDTO);
        Skill savedSkill = skillRepository.save(skill);
        return ConvertDTO.convertToSkillDTO(savedSkill);
    }

    @Override
    public List<SkillDTO> getAllSkills() {
        return skillRepository.findAll().stream().map(skill -> ConvertDTO.convertToSkillDTO(skill)).toList();
    }

    @Override
    public void deleteSkill(Long id) {
        skillRepository.deleteById(id);
    }

    @Override
    public SkillDTO updateSkill(Long id, SkillDTO skillDTO) {
        Skill skill = skillRepository.findById(id).orElse(null);
        SkillDTO skillToUpdate = ConvertDTO.convertToSkillDTO(skill);
        skillToUpdate.setId(id);
        skillToUpdate.setSkillName(skillDTO.getSkillName());
        return ConvertDTO.convertToSkillDTO(skillRepository.save(skill));
    }
}
