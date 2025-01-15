package com.br.sgpt.projectmanager.repositories;

import com.br.sgpt.projectmanager.domain.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    Optional<Project> findById(Long id);
}
