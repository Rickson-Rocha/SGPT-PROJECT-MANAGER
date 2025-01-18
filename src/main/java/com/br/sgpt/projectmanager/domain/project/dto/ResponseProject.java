package com.br.sgpt.projectmanager.domain.project.dto;

import com.br.sgpt.projectmanager.domain.project.enums.Status;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

public record ResponseProject(Long id, String name, String description, Status status,LocalDate startDate, LocalDate endDate) {
}
