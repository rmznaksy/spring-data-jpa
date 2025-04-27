package com.example.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import com.example.dto.IUStudentDTO;
import com.example.dto.StudentDTO;
import com.example.entities.Student;

@Controller
public interface IStudentController {
	
	public StudentDTO saveStudent(IUStudentDTO student);
	
	public List<Student> getAll();
	
	public Student getStudentById(Integer id);
	
	public void deleteStudentById(Integer id);
	
	public Student updateStudent(Integer id, Student updateStudent);
}
