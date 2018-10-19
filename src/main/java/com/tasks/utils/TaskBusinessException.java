package com.tasks.utils;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class TaskBusinessException extends RuntimeException {

	private static final long serialVersionUID = 5025478239349637920L;
	private HttpStatus httpResponseCode;

	public TaskBusinessException(HttpStatus httpResponseCode) {
		super();
		this.httpResponseCode = httpResponseCode;
	}

	public TaskBusinessException(String exceptionMessage, HttpStatus httpResponseCode) {
		super(exceptionMessage);
		this.httpResponseCode = httpResponseCode;
	}

	public TaskBusinessException(String exceptionMessage, Throwable cause, HttpStatus httpResponseCode) {
		super(exceptionMessage, cause);
		this.httpResponseCode = httpResponseCode;
	}
}
