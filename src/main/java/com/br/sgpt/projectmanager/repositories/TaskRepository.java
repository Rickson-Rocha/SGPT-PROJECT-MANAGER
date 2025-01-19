package com.br.sgpt.projectmanager.repositories;

import com.br.sgpt.projectmanager.domain.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository  extends JpaRepository<Task, Long> {
}
