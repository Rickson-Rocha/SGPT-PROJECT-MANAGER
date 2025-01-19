package com.br.sgpt.projectmanager.domain.task.mapper;

import com.br.sgpt.projectmanager.domain.project.Project;
import com.br.sgpt.projectmanager.domain.task.Task;
import com.br.sgpt.projectmanager.domain.task.dto.TaskRequest;
import com.br.sgpt.projectmanager.exceptions.ProjectNotFoundException;
import com.br.sgpt.projectmanager.repositories.ProjectRepository;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    private final ProjectRepository projectRepository;

    public TaskMapper(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Task toEntity(TaskRequest taskRequest) {
        Project project = projectRepository.findById(taskRequest.projectId())
                .orElseThrow(() -> new ProjectNotFoundException("Project not found with ID: " + taskRequest.projectId()));

        return new Task(
                null,
                taskRequest.name(),
                taskRequest.description(),
                taskRequest.priority(),
                taskRequest.status(),
                taskRequest.startDate(),
                taskRequest.endDate(),
                project
        );
    }
}
