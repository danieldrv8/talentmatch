package com.talentmatch.skill_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "skills")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String skillName;
    @Column(nullable = false)
    private int yearsOfExperience;
    @Column(nullable = false)
    private String proficiency;
    @Column(nullable = false)
    private int lastYearUsed;


    public Skill() {
    }

    public Skill(String skillName, int yearsOfExperience, String proficiency, int lastYearUsed) {
        this.skillName = skillName;
        this.yearsOfExperience = yearsOfExperience;
        this.proficiency = proficiency;
        this.lastYearUsed = lastYearUsed;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public int getLastYearUsed() {
        return lastYearUsed;
    }

    public void setLastYearUsed(int lastYearUsed) {
        this.lastYearUsed = lastYearUsed;
    }

    public String getProficiency() {
        return proficiency;
    }

    public void setProficiency(String proficiency) {
        this.proficiency = proficiency;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
