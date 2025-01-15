package com.br.sgpt.projectmanager.domain.project.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RequestProject(
        @NotBlank(message = "Project name is required")
        @Size(min = 4, max = 30, message = "The number of characters for the project name must be between 4 and 30")String name,
        @NotBlank(message = "Project description is required")
        @Size(min = 4, max = 30, message = "The number of characters for the project description must be between 4 and 30")String description) {
}
