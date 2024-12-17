package com.example.candidateSkillService.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CandidateResponseDTO {
    private Long id;
    private String candidateName;
    private String email;
    private String dasId;
    private Set<SkillDTO> skills; // Or just skillIds depending on needs

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDasId() {
        return dasId;
    }

    public void setDasId(String dasId) {
        this.dasId = dasId;
    }

    public Set<SkillDTO> getSkills() {
        return skills;
    }

    public void setSkills(Set<SkillDTO> skills) {
        this.skills = skills;
    }
}

