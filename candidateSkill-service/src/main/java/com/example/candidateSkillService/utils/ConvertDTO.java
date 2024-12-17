package com.example.candidateSkillService.utils;

import com.example.candidateSkillService.dto.CandidateDTO;
import com.example.candidateSkillService.dto.CandidateResponseDTO;
import com.example.candidateSkillService.dto.CandidateSkillDTO;
import com.example.candidateSkillService.dto.SkillDTO;
import com.example.candidateSkillService.entity.Candidate;
import com.example.candidateSkillService.entity.CandidateSkill;
import com.example.candidateSkillService.entity.Skill;
import jakarta.persistence.EntityNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class ConvertDTO {

    public static CandidateDTO convertToCandidateDTO(Candidate candidate) {
        CandidateDTO candidateDTO = new CandidateDTO();
        candidateDTO.setId(candidate.getId());
        candidateDTO.setCandidateName(candidate.getCandidateName());
        candidateDTO.setEmail(candidate.getEmail());
        candidateDTO.setDasId(candidate.getDasId());
        //candidateDTO.setCandidateSkills(candidate.getCandidateSkills().stream().map(ConvertDTO::convertToCandidateSkillDTO).collect(Collectors.toList()));
        //candidateDTO.setSkills(candidate.getCandidateSkills().stream().map(candidateSkill -> ConvertDTO.convertToCandidateSkillDTO(candidateSkill)).collect(Collectors.toList()));
        return candidateDTO;
    }

    public static  SkillDTO convertToSkillDTO(Skill skill) {
        SkillDTO skillDTO = new SkillDTO();
        skillDTO.setId(skill.getId());
        skillDTO.setSkillName(skill.getSkillName());
        return skillDTO;
    }

    public static Candidate convertToCandidate(CandidateDTO candidateDTO) {
        Candidate candidate = new Candidate();
        candidate.setId(candidateDTO.getId());
        candidate.setCandidateName(candidateDTO.getCandidateName());
        candidate.setEmail(candidateDTO.getEmail());
        candidate.setDasId(candidateDTO.getDasId());
        /*List<CandidateSkill> candidateSkills = new ArrayList<>();
        for (CandidateSkillDTO candidateSkillDTO : candidateDTO.getCandidateSkills()) {
            CandidateSkill candidateSkill = new CandidateSkill();
            candidateSkill.setYearsOfExperience(candidateSkillDTO.getYearsOfExperience());
            candidateSkill.setProficiency(candidateSkillDTO.getProficiency());
            candidateSkill.setLastYearUsed(candidateSkillDTO.getLastYearUsed());
            candidateSkill.setCandidate(candidate);  // Relación inversa
            candidateSkills.add(candidateSkill);
        }

        candidate.setCandidateSkills(candidateSkills);

         */
        return candidate;
    }

    public static Skill convertToSkill(SkillDTO skillDTO) {
        Skill skill = new Skill();
        skill.setId(skillDTO.getId());
        skill.setSkillName(skillDTO.getSkillName());
        return skill;
    }

    public static CandidateSkill convertToCandidateSkill(CandidateSkillDTO candidateSkillDTO, Candidate candidate, Skill skill) {
        CandidateSkill candidateSkill = new CandidateSkill();
        candidateSkill.setId(candidateSkillDTO.getId());
        candidateSkill.setCandidate(candidate);  // Assuming candidate is passed as a parameter
        candidateSkill.setSkill(skill);          // Assuming skill is passed as a parameter
        candidateSkill.setYearsOfExperience(candidateSkillDTO.getYearsOfExperience());
        candidateSkill.setProficiency(candidateSkillDTO.getProficiency());
        candidateSkill.setLastYearUsed(candidateSkillDTO.getLastYearUsed());
        return candidateSkill;
    }

    public static CandidateSkillDTO convertToCandidateSkillDTO(CandidateSkill candidateSkill) {
        CandidateSkillDTO candidateSkillDTO = new CandidateSkillDTO();
        candidateSkillDTO.setId(candidateSkill.getId());
        candidateSkillDTO.setCandidateId(candidateSkill.getCandidate().getId());
        candidateSkillDTO.setSkillId(candidateSkill.getSkill().getId());
        candidateSkillDTO.setYearsOfExperience(candidateSkill.getYearsOfExperience());
        candidateSkillDTO.setProficiency(candidateSkill.getProficiency());
        candidateSkillDTO.setLastYearUsed(candidateSkill.getLastYearUsed());
        return candidateSkillDTO;
    }

    public static CandidateResponseDTO candidateResponseDTO(Candidate candidate) {
        CandidateResponseDTO candidateResponseDTO = new CandidateResponseDTO();
        candidateResponseDTO.setId(candidate.getId());
        candidateResponseDTO.setCandidateName(candidate.getCandidateName());
        candidateResponseDTO.setEmail(candidate.getEmail());
        candidateResponseDTO.setDasId(candidate.getDasId());
        return candidateResponseDTO;
    }


}