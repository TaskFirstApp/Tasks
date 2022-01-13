package com.tasks.entity;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity

public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String taskId;
	String priority;
	String toDo;
	String toDoDetails;	
	String assignedTo;
	String initiator;
	ZonedDateTime createdOn;
	ZonedDateTime expectedEndTime;	
	transient Optional<List<TaskProgress>> taskProgresses; 
}
