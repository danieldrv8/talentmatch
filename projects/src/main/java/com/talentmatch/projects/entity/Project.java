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
    private List<Integer> skillIds;
    @Column
    private List<String> dasIds;

    public Project() {
    }

    public Project(String projectName, List<Integer> skillIds, List<String> dasIds) {
        this.projectName = projectName;
        this.skillIds = skillIds;
        this.dasIds = dasIds;
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

    public List<Integer> getSkillIds() {
        return skillIds;
    }

    public void setSkillIds(List<Integer> skillIds) {
        this.skillIds = skillIds;
    }

    public List<String> getDasIds() {
        return dasIds;
    }

    public void setDasIds(List<String> dasIds) {
        this.dasIds = dasIds;
    }
}
