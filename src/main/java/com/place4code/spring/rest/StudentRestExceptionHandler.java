package com.place4code.spring.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handle(StudentNotFoundException e) {
		
		//create a StudentErrorResponse
		StudentErrorResponse errorResponse = new StudentErrorResponse(
				e.getMessage(), 
				System.currentTimeMillis(),
				HttpStatus.NOT_FOUND.value());
		
		//return error response
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler
	ResponseEntity<StudentErrorResponse> handleAnother(Exception e) {

		//create a StudentErrorResponse
		StudentErrorResponse errorResponse = new StudentErrorResponse(
				e.getMessage(), 
				System.currentTimeMillis(),
				HttpStatus.BAD_REQUEST.value());
				
		//return error response
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
				
		
	}

}
