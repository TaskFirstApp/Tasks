package com.tasks.entity;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Task {
	String taskId;
	String priority;
	String toDo;
	String toDoDetails;	
}
