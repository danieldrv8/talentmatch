package com.example.candidateSkillService.dto;

public class SkillDTO {

    private Long id;
    private String skillName;


    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
