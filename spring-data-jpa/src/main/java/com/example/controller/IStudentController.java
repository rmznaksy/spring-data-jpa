package com.example.controller;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.example.entities.Student;

@Controller
public interface IStudentController {
	
	public Student saveStudent(Student student);
	
	public List<Student> getAll();
	
	public Student getStudentById(Integer id);
	
	public void deleteStudentById(Integer id);
	
	public Student updateStudent(Integer id, Student updateStudent);
}
