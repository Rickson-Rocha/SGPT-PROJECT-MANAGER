package com.br.sgpt.projectmanager.services;

import com.br.sgpt.projectmanager.domain.task.Task;
import com.br.sgpt.projectmanager.domain.task.dto.TaskRequest;

public interface TaskService {
    public void createTask(TaskRequest task);
}
