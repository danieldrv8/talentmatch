package com.example.candidateSkillService.service;

import com.example.candidateSkillService.dto.CandidateDTO;
import com.example.candidateSkillService.dto.CandidateResponseDTO;

import java.util.List;

public interface CandidateService {
    CandidateResponseDTO getCandidateById(Long id);
    CandidateDTO createCandidate(CandidateDTO candidateDTO);
    List<CandidateResponseDTO> getAllCandidates();
    void deleteCandidate(Long id);
    CandidateDTO updateCandidate(Long id, CandidateDTO candidateDTO);
}
