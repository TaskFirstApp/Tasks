package com.tasks.vo;

import java.time.ZonedDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TaskVo {
	String priority;
	String toDo;
	String toDoDetails;	
	String assignedTo;
	ZonedDateTime createdOn;
	ZonedDateTime expectedEndTime;	
}
