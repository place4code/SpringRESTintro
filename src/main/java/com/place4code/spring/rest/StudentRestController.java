package com.place4code.spring.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.place4code.spring.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> students;
	
	@PostConstruct
	public void loadData() {
		students = new ArrayList<>();
		students.add(new Student("Luc", "Roma"));
		students.add(new Student("Klaudia", "Wis"));
		students.add(new Student("Iam", "Astudent"));
	}
	

	@GetMapping("/students")
	public List<Student> allStudents() {
		return students;
	}
	

	@GetMapping("students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		//if student doesn't exist
		if (studentId >= students.size() || studentId < 0) 
			throw new StudentNotFoundException("Student not found: " + studentId);
		
		return students.get(studentId);
	}
	

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
