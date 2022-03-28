package com.tasks;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.security.SecurityValidator;
import com.tasks.entity.Task;
import com.tasks.service.TaskService;
import com.tasks.vo.TaskProgressVo;
import com.tasks.vo.TaskVo;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.OPTIONS},
			maxAge = 3600)
public class TaskController {
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	SecurityValidator securityValidator;
		

	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Task>> findAllTasks() {
		if(!securityValidator.validate())
			throw new RuntimeException("Validation error");
		HttpHeaders headers = new HttpHeaders();
		ResponseEntity<List<Task>> responseEntity = new ResponseEntity<List<Task>>(taskRepository.findAll(), headers,
				HttpStatus.OK);
		return responseEntity;
	}

	
	
	@PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Task> addTask(@RequestBody @Validated TaskVo taskVo) {
		Task task = taskService.addTask(taskVo);
		HttpHeaders headers = new HttpHeaders();		
		ResponseEntity<Task> responseEntity = new ResponseEntity<>(task, headers, HttpStatus.CREATED);
		return responseEntity;
	}
	
	@PostMapping(path = "/{taskId}/progress", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Task> addProgressToTask(@PathVariable String taskId, @RequestBody @Validated TaskProgressVo taskProgressVo) {
		Task task = taskService.addProgress(taskId, taskProgressVo);
		HttpHeaders headers = new HttpHeaders();
		ResponseEntity<Task> responseEntity = new ResponseEntity<>(task, headers, HttpStatus.CREATED);
		return responseEntity;
	}
	
	@PatchMapping(path = "/{taskId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Task> updateAssignedTo(@PathVariable String taskId, @RequestBody(required = true) Map<String, String> params) {
		Task task = taskService.updateAssignedTo(taskId, params.get("assignedTo"));
		HttpHeaders headers = new HttpHeaders();
		ResponseEntity<Task> responseEntity = new ResponseEntity<>(task, headers, HttpStatus.OK);
		return responseEntity;
	}



	@GetMapping(path = "/{taskId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Task findTask(@PathVariable String taskId) {
		return taskRepository.findByTaskId(taskId).orElse(null);

	}
	
	
}
