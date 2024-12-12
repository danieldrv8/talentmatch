package com.example.database_service.utils;

import com.example.database_service.dto.CandidateDTO;
import com.example.database_service.dto.CandidateResponseDTO;
import com.example.database_service.dto.SkillDTO;
import com.example.database_service.entity.Candidate;
import com.example.database_service.entity.Skill;

import java.util.stream.Collectors;
public class ConvertDTO {

    public static CandidateDTO convertToCandidateDTO(Candidate candidate) {
        CandidateDTO candidateDTO = new CandidateDTO();
        candidateDTO.setCandidateName(candidate.getCandidateName());
        candidateDTO.setEmail(candidate.getEmail());
        candidateDTO.setDasId(candidate.getDasId());
        candidateDTO.setSkillIds(candidate.getSkills().stream()
                .map(Skill::getId)
                .collect(Collectors.toSet()));
        return candidateDTO;
    }

    public static Candidate convertToCandidate(CandidateDTO candidateDTO) {
        Candidate candidate = new Candidate();
        candidate.setCandidateName(candidateDTO.getCandidateName());
        candidate.setEmail(candidateDTO.getEmail());
        candidate.setDasId(candidateDTO.getDasId());
        return candidate;
    }

    public static Skill convertToEntity(SkillDTO skillDTO) {
        Skill skill = new Skill();
        skill.setSkillName(skillDTO.getSkillName());
        skill.setYearsOfExperience(skillDTO.getYearsOfExperience());
        skill.setProficiency(skillDTO.getProficiency());
        skill.setLastYearUsed(skillDTO.getLastYearUsed());
        return skill;
    }

    public static SkillDTO convertToDTO(Skill skill) {
        SkillDTO skillDTO = new SkillDTO();
        skillDTO.setSkillName(skill.getSkillName());
        skillDTO.setYearsOfExperience(skill.getYearsOfExperience());
        skillDTO.setProficiency(skill.getProficiency());
        skillDTO.setLastYearUsed(skill.getLastYearUsed());
        return skillDTO;
    }

    public static CandidateResponseDTO convertToCandidateResponseDTO(Candidate candidate) {
        CandidateResponseDTO candidateDTO = new CandidateResponseDTO();
        candidateDTO.setId(candidate.getId());
        candidateDTO.setCandidateName(candidate.getCandidateName());
        candidateDTO.setEmail(candidate.getEmail());
        candidateDTO.setDasId(candidate.getDasId());
        candidateDTO.setSkills(candidate.getSkills().stream()
                .map(ConvertDTO::convertToSkillDTO)
                .collect(Collectors.toSet()));
        return candidateDTO;
    }

    public static SkillDTO convertToSkillDTO(Skill skill) {
        SkillDTO skillDTO = new SkillDTO();
        skillDTO.setId(skill.getId());
        skillDTO.setSkillName(skill.getSkillName());
        skillDTO.setYearsOfExperience(skill.getYearsOfExperience());
        skillDTO.setProficiency(skill.getProficiency());
        skillDTO.setLastYearUsed(skill.getLastYearUsed());
        return skillDTO;
    }

}