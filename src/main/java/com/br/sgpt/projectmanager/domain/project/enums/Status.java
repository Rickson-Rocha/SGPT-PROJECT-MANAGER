package com.br.sgpt.projectmanager.domain.project.enums;

public enum Status {
    NEW("New"),
    IN_PROGRESS("In Progress"),
    DONE("Done"),
    DELAYED("Delayed"),
    CANCELLED("Cancelled");

    private String statusProject;

    Status(String statusProject) {
        this.statusProject = statusProject;
    }
    public String getStatusProject() {
        return statusProject;
    }
}
