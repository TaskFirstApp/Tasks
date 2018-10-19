package com.tasks.service;

import com.tasks.entity.Task;
import com.tasks.vo.TaskProgressVo;
import com.tasks.vo.TaskVo;

public interface TaskService {

	public Task addTask(TaskVo taskVo);

	public Task addProgress(String taskId, TaskProgressVo taskProgressVo);
}
