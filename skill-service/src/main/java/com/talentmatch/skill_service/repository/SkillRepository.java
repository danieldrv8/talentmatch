package com.talentmatch.skill_service.repository;

import com.talentmatch.skill_service.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {

}
