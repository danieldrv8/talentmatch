package com.talentmatch.projects.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String projectName;
    @Column
    private List<Long> skillIds;
    @Column
    private List<Long> candidateIds;

    public Project() {
    }

    public Project(String projectName, List<Long> skillIds, List<Long> candidateIds) {
        this.projectName = projectName;
        this.skillIds = skillIds;
        this.candidateIds = candidateIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Long> getSkillIds() {
        return skillIds;
    }

    public void setSkillIds(List<Long> skillIds) {
        this.skillIds = skillIds;
    }

    public List<Long> getCandidateIds() {
        return candidateIds;
    }

    public void setCandidateIds(List<Long> candidateIds) {
        this.candidateIds = candidateIds;
    }
}
