package com.br.sgpt.projectmanager.services;

import com.br.sgpt.projectmanager.domain.task.Task;
import com.br.sgpt.projectmanager.domain.task.dto.TaskRequest;
import com.br.sgpt.projectmanager.domain.task.dto.TaskResponse;

import java.util.List;

public interface TaskService {
    public void createTask(TaskRequest task);
    public TaskResponse getTaskById(Long id);
    public List<TaskResponse> getTAllTasks();
    public void updateTask(Long id, TaskRequest task);
    public void deleteTaskById(Long id);

}
