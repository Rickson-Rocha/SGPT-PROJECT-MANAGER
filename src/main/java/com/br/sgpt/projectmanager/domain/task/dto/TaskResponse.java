package com.br.sgpt.projectmanager.domain.task.dto;

import com.br.sgpt.projectmanager.domain.project.Project;
import com.br.sgpt.projectmanager.domain.project.enums.Status;
import com.br.sgpt.projectmanager.domain.task.enums.Priority;

import java.time.LocalDateTime;

public record TaskResponse (
        Long id, String name, String description, Priority priority, Status status, LocalDateTime startDate, LocalDateTime endDate, Project project
){
}
