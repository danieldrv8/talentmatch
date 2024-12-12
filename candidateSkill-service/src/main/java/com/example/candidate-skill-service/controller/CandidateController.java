package com.example.database_service.controller;

import com.example.database_service.dto.CandidateDTO;
import com.example.database_service.dto.CandidateResponseDTO;
import com.example.database_service.entity.Candidate;
import com.example.database_service.service.CandidateService;
import com.example.database_service.utils.ConvertDTO;
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
        List<Candidate> candidates = candidateService.findAll();
        Map<String, Object> response = new HashMap<>();
        response.put("message", "List of all candidates");
        response.put("candidates", candidates);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getCandidateById(@PathVariable(value = "id") Long id) {
        Candidate candidate = candidateService.findById(id);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Candidate found");
        response.put("candidate", candidate);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}/skills")
    public ResponseEntity<Map<String, Object>> getCandidateSkillsById(@PathVariable(value = "id") Long id) {
        Candidate candidate = candidateService.findById(id);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Skills of the candidate found");
        response.put("skills", candidate.getSkills());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}/skills/{skillId}")
    public ResponseEntity<Map<String, Object>> getCandidateSkillsById(@PathVariable(value = "id") Long id, @PathVariable(value = "skillId") Long skillId) {
        Candidate candidate = candidateService.findById(id);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Skills of the candidate found");
        response.put("skills", candidate.getSkills());
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CandidateResponseDTO> createCandidate(@RequestBody CandidateDTO candidateDTO) {
        Candidate candidate = candidateService.save(candidateDTO);
        CandidateResponseDTO responseDTO = ConvertDTO.convertToCandidateResponseDTO(candidate);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateCandidate(@PathVariable(value = "id") Long id, @RequestBody CandidateDTO candidateDTO) {
        Candidate candidateToUpdate = candidateService.update(id, candidateDTO);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Candidate updated successfully");
        response.put("candidate", candidateToUpdate);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteCandidate(@PathVariable(value = "id") Long id) {
        candidateService.deleteById(id);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Candidate deleted successfully");
        return ResponseEntity.ok(response);
    }


}
