package com.place4code.spring.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.place4code.spring.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	@GetMapping("/students")
	public List<Student> allStudents() {
		
		List<Student> students = new ArrayList<>();
		
		students.add(new Student("Luc", "Roma"));
		students.add(new Student("Klaudia", "Wis"));
		students.add(new Student("Iam", "Astudent"));
		
		return students;
		
	}
}
