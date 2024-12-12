package com.example.database_service.dto;

import java.util.Set;

public class CandidateDTO {
    private String candidateName;
    private String email;
    private String dasId;
    private Set<Long> skillIds;

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

    public Set<Long> getSkillIds() {
        return skillIds;
    }

    public void setSkillIds(Set<Long> skillIds) {
        this.skillIds = skillIds;
    }
}
