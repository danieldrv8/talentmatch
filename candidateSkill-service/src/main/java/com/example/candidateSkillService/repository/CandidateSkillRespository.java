package com.example.candidateSkillService.repository;

import com.example.candidateSkillService.entity.CandidateSkill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateSkillRespository extends JpaRepository<CandidateSkill, Long> {
}
