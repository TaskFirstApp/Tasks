package com.tasks;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tasks.entity.Task;


public interface TaskRepository extends JpaRepository<Task, String>{

	Optional<Task> findByTaskId(String taskId);
	
}
