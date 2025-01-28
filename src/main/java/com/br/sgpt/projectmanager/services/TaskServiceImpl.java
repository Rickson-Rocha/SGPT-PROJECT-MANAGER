package com.br.sgpt.projectmanager.services;

import com.br.sgpt.projectmanager.domain.task.Task;
import com.br.sgpt.projectmanager.domain.task.dto.TaskRequest;
import com.br.sgpt.projectmanager.domain.task.dto.TaskResponse;
import com.br.sgpt.projectmanager.domain.task.mapper.TaskMapper;
import com.br.sgpt.projectmanager.exceptions.DateTaskException;
import com.br.sgpt.projectmanager.exceptions.TaskNotFoundException;
import com.br.sgpt.projectmanager.repositories.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;


    public TaskServiceImpl(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    @Transactional
    public void createTask(TaskRequest data) {
        Task task = taskMapper.toEntity(data);
        taskRepository.save(task);
    }

    @Override
    public TaskResponse getTaskById(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task not found" + id));
        return taskMapper.toResponse(task);
    }

    @Override
    public List<TaskResponse> getTAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream().map(taskMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public void updateTask(Long id, TaskRequest task) {
        Task  savedTask = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task not found" + id));
        if(task.startDate()!=null) {
            if(savedTask.isStartDateBeforeProjectStart() || savedTask.isEndDateAfterProjectEnd()){
                throw new DateTaskException("Task start date cannot be before project end date");
            }
            savedTask.setStartDate(task.startDate());
            savedTask.setEndDate(task.endDate());

        }

        if(task.name()!=null){
            savedTask.setName(task.name());
        }
        if(task.description()!=null){
            savedTask.setDescription(task.description());
        }

        if(task.priority()!=null){
            savedTask.setPriority(task.priority());
        }
        if(task.status()!=null){
            savedTask.setStatus(task.status());
        }

    }

    @Override
    public void deleteTaskById(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task not found" + id));
        taskRepository.delete(task);

    }

    private boolean isStartDateBeforeProjectStart(Task task) {
        if (task.getProject() != null && task.getStartDate() != null && task.getProject().getStartDate() != null) {
            return task.getStartDate().toLocalDate().isBefore(task.getProject().getStartDate());
        }
        return false;
    }


    private boolean isEndDateAfterProjectEnd(Task task) {
        if (task.getProject() != null && task.getEndDate() != null && task.getProject().getEndDate() != null) {
            return task.getEndDate().toLocalDate().isAfter(task.getProject().getEndDate());
        }
        return false;
    }


}
