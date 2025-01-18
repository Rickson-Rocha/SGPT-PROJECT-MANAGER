package com.br.sgpt.projectmanager.domain.project.dto;


import com.br.sgpt.projectmanager.domain.project.enums.Status;
import com.br.sgpt.projectmanager.domain.project.validation.ValidationGroups;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record RequestProject(
        @NotBlank(message = "Project name is required", groups = ValidationGroups.OnCreate.class)
        @Size(min = 4, max = 255, message = "The number of characters for the project name must be between 4 and 255")
        String name,

        @NotBlank(message = "Project description is required", groups = ValidationGroups.OnCreate.class)
        @Size(min = 4, max = 255, message = "The number of characters for the project description must be between 4 and 255")
        String description,


        Status status,

        @NotNull(message = "End date is required")
        @FutureOrPresent(message = "Start date must be today or in the future")
        LocalDate startDate,

        @NotNull(message = "End date is required")
        @Future(message = "End date must be in the future")
        LocalDate endDate
) {}
