package com.example.candidateSkillService.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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
    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CandidateSkill> candidateSkills;


    public Candidate() {
    }

    public Candidate(String candidateName, String email, String dasId, List<CandidateSkill> candidateSkills) {
        this.candidateName = candidateName;
        this.email = email;
        this.dasId = dasId;
        this.candidateSkills = candidateSkills;
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

    public List<CandidateSkill> getCandidateSkills() {
        return candidateSkills;
    }

    public void setCandidateSkills(List<CandidateSkill> candidateSkills) {
        this.candidateSkills = candidateSkills;
    }

    public List<CandidateSkill> getSkillIds() {
        return this.candidateSkills;
    }
}
