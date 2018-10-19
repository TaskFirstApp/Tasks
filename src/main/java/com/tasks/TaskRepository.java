package com.tasks;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tasks.entity.Task;

public interface TaskRepository extends MongoRepository<Task, String>{
	
}
