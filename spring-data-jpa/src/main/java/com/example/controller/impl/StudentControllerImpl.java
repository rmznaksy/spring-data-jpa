package com.example.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controller.IStudentController;
import com.example.dto.IUStudentDTO;
import com.example.dto.StudentDTO;
import com.example.entities.Student;
import com.example.services.IStudentService;

@RestController
@RequestMapping("/rest/api/student")
public class StudentControllerImpl implements IStudentController{
	
	@Autowired
	private IStudentService studentService;
	
	@Override
	@PostMapping(path="/save")
	public StudentDTO saveStudent(@RequestBody IUStudentDTO IUstudentDTO) {
		return studentService.saveStudent(IUstudentDTO);
	}


	@Override
	@GetMapping(path="/listAll")
	public List<Student> getAll() {
		return studentService.getAll();
	}

	@Override
	@GetMapping(path="/list/{id}")
	public Student getStudentById(@PathVariable(name="id") Integer id) {
		return studentService.getStudentById(id);
	}

	@Override
	@DeleteMapping(path="delete/{id}")
	public void deleteStudentById(@PathVariable(name="id") Integer id) {
		studentService.deleteStudentById(id);
	}

	@Override
	@PutMapping(path="/update/{id}")
	public Student updateStudent(@PathVariable(name="id") Integer id, @RequestBody Student updateStudent) {
		return studentService.updateStudent(id, updateStudent);
	}


	
	
}
