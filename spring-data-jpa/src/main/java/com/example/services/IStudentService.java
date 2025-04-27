package com.example.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entities.Student;

@Service
public interface IStudentService {
	
	public Student saveStudent(Student student);

	public List<Student> getAll();
	
	public Student getStudentById(Integer id);
	
	public void deleteStudentById(Integer id);
	
	public Student updateStudent(Integer id, Student updateStudent);

}
