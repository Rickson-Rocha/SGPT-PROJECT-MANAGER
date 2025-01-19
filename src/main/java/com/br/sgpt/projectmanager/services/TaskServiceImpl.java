package com.br.sgpt.projectmanager.services;

import com.br.sgpt.projectmanager.domain.task.Task;
import com.br.sgpt.projectmanager.domain.task.dto.TaskRequest;
import com.br.sgpt.projectmanager.domain.task.mapper.TaskMapper;
import com.br.sgpt.projectmanager.exceptions.DateTaskException;
import com.br.sgpt.projectmanager.repositories.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;


    public TaskServiceImpl(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    public void createTask(TaskRequest data) {
        Task task = taskMapper.toEntity(data);
        if (task.isStartDateBeforeProjectStart() || task.isEndDateAfterProjectEnd()) {
            throw new DateTaskException("Task start date cannot be before project start date or end date after project end date");
        }
        taskRepository.save(task);
    }



}
