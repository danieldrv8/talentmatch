package com.example.database_service.service;

import com.example.database_service.entity.Skill;
import com.example.database_service.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public Skill save(Skill skill) {
        return skillRepository.save(skill);
    }

    public Skill findById(Long id) {
        return skillRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        skillRepository.deleteById(id);
    }

    public Skill update(Long id, Skill skill) {
        Skill skillToUpdate = skillRepository.findById(skill.getId()).orElse(null);
        if (skillToUpdate != null) {
            skillToUpdate.setId(id);
            skillToUpdate.setSkillName(skill.getSkillName());
            skillToUpdate.setYearsOfExperience(skill.getYearsOfExperience());
            skillToUpdate.setProficiency(skill.getProficiency());
            skillToUpdate.setLastYearUsed(skill.getLastYearUsed());
        }
        return skillRepository.save(skill);
    }

    public List<Skill> findAll() {
        return skillRepository.findAll();
    }
}
