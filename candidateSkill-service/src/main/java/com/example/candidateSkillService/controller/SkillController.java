package com.example.candidateSkillService.controller;

import com.example.candidateSkillService.dto.SkillDTO;
import com.example.candidateSkillService.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/skills")
public class SkillController {

    @Autowired
    private SkillService skillService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllSkills() {
        List<SkillDTO> skills = skillService.getAllSkills();
        Map<String, Object> response = new HashMap<>();
        response.put("message", "All skills found");
        response.put("skills", skills);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getSkillById(@PathVariable("id") Long id) {
        SkillDTO skillDTO = skillService.getSkillById(id);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Skill found");
        response.put("skill", skillDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Map<String, Object>> getSkillByName(@PathVariable("name") String name) {
        SkillDTO skillDTO = skillService.getSkillByName(name);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Skill found");
        response.put("skill", skillDTO);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createSkill(@RequestBody SkillDTO skillDTO) {
        skillService.createSkill(skillDTO);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Skill created");
        response.put("skill", skillDTO);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateSkill(@PathVariable Long id, @RequestBody SkillDTO skillDTO) {
        skillService.updateSkill(id, skillDTO);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Skill updated");
        response.put("skill", skillDTO);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteSkill(@PathVariable Long id) {
        skillService.deleteSkill(id);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Skill deleted");
        return ResponseEntity.ok(response);
    }
}
