package com.place4code.spring.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

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
		return students.get(studentId);
	}
}
