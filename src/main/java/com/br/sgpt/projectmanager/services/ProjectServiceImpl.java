package com.br.sgpt.projectmanager.services;

import com.br.sgpt.projectmanager.ProjectMapper;
import com.br.sgpt.projectmanager.domain.project.Project;
import com.br.sgpt.projectmanager.domain.project.dto.RequestProject;
import com.br.sgpt.projectmanager.domain.project.dto.ResponseProject;
import com.br.sgpt.projectmanager.domain.project.enums.Status;
import com.br.sgpt.projectmanager.exceptions.ProjectNotFoundException;
import com.br.sgpt.projectmanager.repositories.ProjectRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl  implements ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override

    @Transactional
    public ResponseProject createProject(RequestProject data) {
        Project project = ProjectMapper.toEntity(data);
        Project savedProject = projectRepository.save(project);
        return ProjectMapper.toResponse(savedProject);
    }

    @Override
    public ResponseProject getProjectById(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException("Project not found with id: " + id));
        return ProjectMapper.toResponse(project);
    }

    @Override
    public List<ResponseProject> getAllProjects() {
        List<Project> projects = projectRepository.findAll();
        return projects.stream()
                .map(ProjectMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public ResponseProject updateProject(Long id, RequestProject data) {
        return null;
    }

    @Override
    public void deleteProject(Long id) {

    }


}
