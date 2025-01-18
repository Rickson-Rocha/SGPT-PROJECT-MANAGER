package com.br.sgpt.projectmanager.controllers;


import com.br.sgpt.projectmanager.domain.project.dto.RequestProject;
import com.br.sgpt.projectmanager.domain.project.dto.ResponseProject;
import com.br.sgpt.projectmanager.domain.project.validation.ValidationGroups;
import com.br.sgpt.projectmanager.services.ProjectService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping("projects")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

     @PostMapping
     public ResponseEntity<Void> createProject( @Validated(ValidationGroups.OnCreate.class)@RequestBody @Valid RequestProject requestProject) {
         projectService.createProject(requestProject);
         return ResponseEntity.status(HttpStatus.CREATED).build();
     }

     @GetMapping("/{id}")
    public ResponseEntity<ResponseProject> getProject(@PathVariable("id") Long id) {
         ResponseProject project = projectService.getProjectById(id);
         return ResponseEntity.ok().body(project);
     }

     @GetMapping
    public ResponseEntity<List<ResponseProject>> getAllProjects() {
        List<ResponseProject> projects = projectService.getAllProjects();
        return ResponseEntity.ok().body(projects);
     }

     @PutMapping("/{id}")
    public ResponseEntity<Void> updateProject( @PathVariable("id") Long id, @Validated(ValidationGroups.OnUpdate.class)@RequestBody @Valid RequestProject requestProject) {
        ResponseProject project = projectService.updateProject(id, requestProject);
        return ResponseEntity.ok().build();
     }

     @DeleteMapping("/{id}")
     public ResponseEntity<Void> deleteProject(@PathVariable("id") Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
     }

    }
