package com.br.sgpt.projectmanager;

import com.br.sgpt.projectmanager.domain.project.Project;
import com.br.sgpt.projectmanager.domain.project.dto.RequestProject;
import com.br.sgpt.projectmanager.domain.project.dto.ResponseProject;
import com.br.sgpt.projectmanager.domain.project.enums.Status;

public class ProjectMapper {
    public static Project toEntity(RequestProject request) {
        return new Project(
                null,
                request.name(),
                request.description(),
                Status.NEW
        );
    }

    public static ResponseProject toResponse(Project project) {
        return new ResponseProject(
                project.getId(),
                project.getName(),
                project.getDescription(),
                project.getStatus()
        );
    }
}