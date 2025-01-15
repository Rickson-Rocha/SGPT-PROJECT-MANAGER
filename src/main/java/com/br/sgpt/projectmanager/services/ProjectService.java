package com.br.sgpt.projectmanager.services;

import com.br.sgpt.projectmanager.domain.project.dto.RequestProject;
import com.br.sgpt.projectmanager.domain.project.dto.ResponseProject;

import java.util.List;
import java.util.UUID;

public interface ProjectService {
    public ResponseProject createProject(RequestProject data);
    public ResponseProject getProjectById(Long id);
    public List<ResponseProject> getAllProjects();
    public ResponseProject updateProject(Long id, RequestProject data);
    public void deleteProject(Long id);

}
