package com.example.candidateSkillService.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CandidateDTO {
    private Long id;
    private String candidateName;
    private String email;
    private String dasId;
    private List<CandidateSkillDTO> candidateSkills = new ArrayList<>();

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CandidateSkillDTO> getSkills() {
        return candidateSkills;
    }

    public void setSkills(List<CandidateSkillDTO> skills) {
        this.candidateSkills = skills;
    }
}
