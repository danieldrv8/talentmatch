package com.example.candidateSkillService.dto;

public class CandidateSkillDTO {
    private Long id;
    private Long candidateId;
    private Long skillId;
    private int yearsOfExperience;
    private String proficiency;
    private int lastYearUsed;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Long candidateId) {
        this.candidateId = candidateId;
    }

    public Long getSkillId() {
        return skillId;
    }

    public void setSkillId(Long skillId) {
        this.skillId = skillId;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getProficiency() {
        return proficiency;
    }

    public void setProficiency(String proficiency) {
        this.proficiency = proficiency;
    }

    public int getLastYearUsed() {
        return lastYearUsed;
    }

    public void setLastYearUsed(int lastYearUsed) {
        this.lastYearUsed = lastYearUsed;
    }
}
