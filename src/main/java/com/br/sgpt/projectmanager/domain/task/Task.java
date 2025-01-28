package com.br.sgpt.projectmanager.domain.task;


import com.br.sgpt.projectmanager.domain.project.Project;
import com.br.sgpt.projectmanager.domain.project.enums.Status;
import com.br.sgpt.projectmanager.domain.task.enums.Priority;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_task")
@EqualsAndHashCode(of = "id")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;
    @NotBlank
    private String description;

    @Column(name = "task_priority")
    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Enumerated(EnumType.STRING)
    @Column(name = "task_status")
    private Status status;
    @Column(name = "start_date")
    private LocalDateTime startDate;
    @Column(name = "end_date")
    private LocalDateTime endDate;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public Task(Long id, String name, String description, Priority priority, Status status, LocalDateTime startDate, LocalDateTime endDate, Project project) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.project = project;
    }
    public Task() {}

    public boolean isStartDateBeforeProjectStart() {
        if (this.project != null && this.startDate != null && this.project.getStartDate() != null) {
            return this.startDate.toLocalDate().isBefore(this.project.getStartDate());
        }
        return false;
    }


    public boolean isEndDateAfterProjectEnd() {
        if (this.project != null && this.endDate != null && this.project.getEndDate() != null) {
            return this.endDate.toLocalDate().isAfter(this.project.getEndDate());
        }
        return false;
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

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
