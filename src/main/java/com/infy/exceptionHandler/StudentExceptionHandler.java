package com.infy.exceptionHandler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.infy.exception.StudentException;

@RestControllerAdvice
public class StudentExceptionHandler {


	@Autowired
	private Environment environment;

	@ExceptionHandler(StudentException.class)
	public ResponseEntity<ErrorInformation> studentExceptionHandler(StudentException exception) {
		ErrorInformation errorInfo = new ErrorInformation();
		errorInfo.setErrorMessage(environment.getProperty(exception.getMessage()));
		errorInfo.setErrorCode(HttpStatus.NOT_FOUND.value());
		
		

		return new ResponseEntity<>(errorInfo, HttpStatus.NOT_FOUND);
	}}