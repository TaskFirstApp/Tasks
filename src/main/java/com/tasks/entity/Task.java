package com.tasks.entity;

public class Task {
	String taskId;
	String priority;
	String toDo;
	String toDoDetails;
	
	
	public Task(String taskId, String priority, String toDo, String toDoDetails) {
		super();
		this.taskId = taskId;
		this.priority = priority;
		this.toDo = toDo;
		this.toDoDetails = toDoDetails;
	}


	public String getTaskId() {
		return taskId;
	}


	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}


	public String getPriority() {
		return priority;
	}


	public void setPriority(String priority) {
		this.priority = priority;
	}


	public String getToDo() {
		return toDo;
	}


	public void setToDo(String toDo) {
		this.toDo = toDo;
	}


	public String getToDoDetails() {
		return toDoDetails;
	}


	public void setToDoDetails(String toDoDetails) {
		this.toDoDetails = toDoDetails;
	}

	
}
