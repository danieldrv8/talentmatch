package com.talentmatch.projects.service;

import com.talentmatch.projects.entity.Project;

import java.util.List;

public interface ProjectService {
    Project getProjectById(Long id);
    Project createProject(Project project);
    void deleteProject(Long id);
    Project updateProject(Long id, Project project);
    List<Project> getAllProjects();
}
