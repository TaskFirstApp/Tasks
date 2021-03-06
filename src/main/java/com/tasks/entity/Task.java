package com.tasks.entity;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Task {
	String taskId;
	String priority;
	String toDo;
	String toDoDetails;	
	String assignedTo;
	String initiator;
	ZonedDateTime createdOn;
	ZonedDateTime expectedEndTime;	
	Optional<List<TaskProgress>> taskProgresses; 
}
