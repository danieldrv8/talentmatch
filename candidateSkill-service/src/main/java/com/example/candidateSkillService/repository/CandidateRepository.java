package com.example.candidateSkillService.repository;
import com.example.candidateSkillService.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

}
