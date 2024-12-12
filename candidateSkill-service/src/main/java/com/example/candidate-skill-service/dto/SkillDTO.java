package com.example.database_service.dto;

public class SkillDTO {

    private Long id;
    private String skillName;
    private int yearsOfExperience;
    private String proficiency;
    private int lastYearUsed;

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
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

    public void setId(Long id) {
        this.id = id;
    }
}
