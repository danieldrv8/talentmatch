package com.talentmatch.skill_service.controller;

import com.talentmatch.skill_service.entity.Skill;
import com.talentmatch.skill_service.service.SkillService;
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
        List<Skill> skills = skillService.findAll();
        Map<String, Object> response = new HashMap<>();
        response.put("message", "All skills found");
        response.put("skills", skills);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getSkillById(@PathVariable Long id) {
        Skill skill = skillService.findById(id);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Skill found");
        response.put("skill", skill);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createSkill(@RequestBody Skill skill) {
        Skill newSkill = skillService.save(skill);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Skill created");
        response.put("skill", newSkill);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateSkill(@PathVariable Long id, @RequestBody Skill skill) {
        Skill updatedSkill = skillService.update(id, skill);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Skill updated");
        response.put("skill", updatedSkill);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteSkill(@PathVariable Long id) {
        skillService.deleteById(id);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Skill deleted");
        return ResponseEntity.ok(response);
    }
}
