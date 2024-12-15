package com.example.candidateSkillService.repository;

import com.example.candidateSkillService.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {

}
