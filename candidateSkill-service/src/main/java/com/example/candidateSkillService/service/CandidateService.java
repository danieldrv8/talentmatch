package com.example.candidateSkillService.service;

import com.example.candidateSkillService.dto.CandidateDTO;

import java.util.List;

public interface CandidateService {
    CandidateDTO getCandidateById(Long id);
    CandidateDTO createCandidate(CandidateDTO candidateDTO);
    List<CandidateDTO> getAllCandidates();
    void deleteCandidate(Long id);
    CandidateDTO updateCandidate(Long id, CandidateDTO candidateDTO);
}
