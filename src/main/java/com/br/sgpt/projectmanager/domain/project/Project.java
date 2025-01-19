package com.br.sgpt.projectmanager.domain.project;


import com.br.sgpt.projectmanager.domain.project.enums.Status;
import com.br.sgpt.projectmanager.domain.task.Task;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "tb_project")
@EqualsAndHashCode(of = "id")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Project name is required")
    @Size(min = 4, max = 255, message = "The number of characters for the project name must be between 4 and 30")
    private String name;

    @NotBlank(message = "Description project is required")
    @Size(min = 4, max = 255, message = "The number of characters for the project description must be between 4 and 30")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "project_status", nullable = false)
    private Status status = Status.NEW;


    @FutureOrPresent(message = "Start date must be today or in the future")
    @NotNull(message = "End date is required")
    @Column(name = "start_date")
    private LocalDate startDate;


    @Future(message = "End date must be today or in the future")
    @NotNull(message = "End date is required")
    @Column(name = "end_date")
    private LocalDate endDate;

    @OneToMany(mappedBy = "project")
    private List<Task> tasks = new ArrayList<>();

    public Project(Long id, String name, String description, Status status, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Project() {}

    public List<Task> getTasks() {
        return tasks;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}