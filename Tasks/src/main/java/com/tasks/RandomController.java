package com.tasks;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/tasks")
public class RandomController {
	@Value("${DealOfTheDay}")
	String dealOfTheDay;

	@GetMapping(path = "/deal-of-the-day", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> dealOfTheDay() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccessControlAllowOrigin("*");
		return new ResponseEntity<String>(dealOfTheDay, headers, HttpStatus.OK);

	}
	
	@PostMapping(path = "", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> addTask(@RequestParam String toDo, @RequestParam(required = false) String toDoDetail,
			@RequestParam(required = false, defaultValue = "Medium") String priority, String userId) {
		String taskRef = UUID.randomUUID().toString();

	//	taskRepository.save(new Task(taskRef, priority, toDo, toDoDetail, userId));
		HttpHeaders headers = new HttpHeaders();
		headers.setAccessControlAllowOrigin("*");
		ResponseEntity<String> responseEntity = new ResponseEntity<>(taskRef, headers, HttpStatus.CREATED);
		return responseEntity;
	}
}
