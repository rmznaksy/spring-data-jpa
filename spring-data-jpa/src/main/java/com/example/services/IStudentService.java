package com.example.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dto.IUStudentDTO;
import com.example.dto.StudentDTO;
import com.example.entities.Student;

@Service
public interface IStudentService {
	
	public StudentDTO saveStudent(IUStudentDTO student);

	public List<Student> getAll();
	
	public Student getStudentById(Integer id);
	
	public void deleteStudentById(Integer id);
	
	public Student updateStudent(Integer id, Student updateStudent);

}
