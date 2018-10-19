package com.tasks.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.tasks.TaskRepository;
import com.tasks.entity.Task;
import com.tasks.entity.TaskProgress;
import com.tasks.utils.TaskBusinessException;
import com.tasks.utils.TaskUtils;
import com.tasks.vo.TaskProgressVo;
import com.tasks.vo.TaskVo;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	TaskRepository taskRepository;

	@Override
	public Task addTask(TaskVo taskVo) {
		Task task = Task.builder().build();
		String taskRef = TaskUtils.getUniqueRef();
		task.setTaskId(taskRef);
		task.setInitiator(null); // TODO need fix to pass current user as initiator
		BeanUtils.copyProperties(taskVo, task);
		return taskRepository.save(task);
	}

	@Override
	public Task addProgress(String taskId, TaskProgressVo taskProgressVo) {
		Task task = taskRepository.findById(taskId).orElse(null);
		if (task != null) {
			TaskProgress taskProgress = TaskProgress.builder().build();
			BeanUtils.copyProperties(taskProgressVo, taskProgress);
			taskProgress.setMadeBy(null); // TODO need fix to pass current user as madeBy
			taskProgress.setProgressId(TaskUtils.getUniqueRef());
			taskProgress.setMadeAt(null);// TODO need to pass current date time
			List<TaskProgress> taskProgresses = task.getTaskProgresses().orElse(new ArrayList<TaskProgress>());
			taskProgresses.add(taskProgress);
			task.setTaskProgresses(Optional.of(taskProgresses));
			return taskRepository.save(task);
		}
		else {
			throw new TaskBusinessException("Task not found with specified ID" +taskId, HttpStatus.NOT_FOUND );
		}
	}

}
