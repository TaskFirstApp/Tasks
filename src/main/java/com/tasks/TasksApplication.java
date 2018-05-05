package com.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tasks.entity.Task;

@SpringBootApplication
@EnableEurekaClient
@RestController
@RequestMapping("/tasks")
public class TasksApplication {

	private List<Task> tasksList = new ArrayList<Task>();

	@PostConstruct
	void loadTasks() {
		tasksList.add(new Task("3201", "High", "Get Car", "Get your car delivered from Rajdhani VW"));
		tasksList.add(new Task("1342", "High", "RC and RTO done", "Get RC and RTO done from local rewari secretariet."));
		tasksList.add(new Task("311", "Low", "Music system",
				"Geta good sound quality music system installed in your car, It must be bluetooth enabled."));
	}

	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Task>> findAllTasks() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccessControlAllowOrigin("*");
		ResponseEntity<List<Task>> responseEntity = new ResponseEntity<List<Task>>(tasksList, headers, HttpStatus.OK);
		return responseEntity;
	}

	@PostMapping(path = "", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> addTask(@RequestParam String toDo, @RequestParam(required = false) String toDoDetail,
			@RequestParam(required = false, defaultValue="Medium") String priority) {
		String taskRef = UUID.randomUUID().toString();
		tasksList.add(new Task(taskRef, priority, toDo, toDoDetail));
		HttpHeaders headers = new HttpHeaders();
		headers.setAccessControlAllowOrigin("*");
		ResponseEntity<String> responseEntity = new ResponseEntity<>(taskRef, headers, HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping(path = "/{taskId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Task findTask(@PathVariable String taskId) {
		return tasksList.stream().filter(t -> t.getTaskId().equals(taskId)).findFirst().orElse(null);
	}

	public static void main(String[] args) {
		SpringApplication.run(TasksApplication.class, args);
	}
}
