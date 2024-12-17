package com.example.candidateSkillService.controller;

import com.example.candidateSkillService.dto.CandidateDTO;
import com.example.candidateSkillService.dto.CandidateResponseDTO;
import com.example.candidateSkillService.dto.CandidateSkillDTO;
import com.example.candidateSkillService.entity.Candidate;
import com.example.candidateSkillService.service.CandidateService;
import com.example.candidateSkillService.utils.ConvertDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/candidates")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllCandidates() {
        List<CandidateResponseDTO> candidates = candidateService.getAllCandidates();
        Map<String, Object> response = new HashMap<>();
        response.put("message", "List of all candidates");
        response.put("candidates", candidates);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getCandidateById(@PathVariable(value = "id") Long id) {
        CandidateResponseDTO candidateResponseDTO = candidateService.getCandidateById(id);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Candidate found");
        response.put("candidate", candidateResponseDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}/skills")
    public ResponseEntity<Map<String, Object>> getCandidateSkillsById(@PathVariable(value = "id") Long id) {
        CandidateResponseDTO candidateResponseDTO = candidateService.getCandidateById(id);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Skills of the candidate found");
        response.put("skills", candidateResponseDTO.getSkills());
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createCandidate(@RequestBody CandidateDTO candidateDTO) {
        candidateService.createCandidate(candidateDTO);
        HashMap<String, Object> response = new HashMap<>();
        response.put("message", "Candidate created successfully");
        response.put("candidate", candidateDTO);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateCandidate(@PathVariable(value = "id") Long id, @RequestBody CandidateDTO candidateDTO) {
        CandidateDTO candidateToUpdate = candidateService.updateCandidate(id, candidateDTO);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Candidate updated successfully");
        response.put("candidate", candidateToUpdate);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteCandidate(@PathVariable(value = "id") Long id) {
        candidateService.deleteCandidate(id);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Candidate deleted successfully");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}/cs")
    public ResponseEntity<Map<String, Object>> getCandidateCS(@PathVariable(value = "id") Long id) {
        CandidateDTO candidateDTO = candidateService.getCandidateCS(id);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Candidate found");
        response.put("candidate", candidateDTO);
        return ResponseEntity.ok(response);
    }
}
