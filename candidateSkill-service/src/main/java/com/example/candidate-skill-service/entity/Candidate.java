package com.example.database_service.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "candidates")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String candidateName;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false, unique = true)
    private String dasId;
    @ManyToMany
    private Set<Skill> skills = new HashSet<>();


    public Candidate() {
    }

    public Candidate(String candidateName, String email, String dasId, Set<Skill> skills) {
        this.candidateName = candidateName;
        this.email = email;
        this.dasId = dasId;
        this.skills = skills;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDasId() {
        return dasId;
    }

    public void setDasId(String dasId) {
        this.dasId = dasId;
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

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public Set<Long> getSkillIds() {
        Set<Long> skillIds = new HashSet<>();
        for (Skill skill : skills) {
            skillIds.add(skill.getId());
        }
        return skillIds;
    }
}
