package com.example.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.IUStudentDTO;
import com.example.dto.StudentDTO;
import com.example.entities.Student;
import com.example.repository.StudentRepository;
import com.example.services.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public StudentDTO saveStudent(IUStudentDTO IUstudentDTO) {
		StudentDTO response = new StudentDTO(); // çıktı için response oluşturuldu.
		Student student = new Student(); // db ye kayıt için Student entity den student oluşturuldu.
		BeanUtils.copyProperties(IUstudentDTO, student); // IUstudentDTO özellikler student objesine kopyalandı.
		Student dbStudent = studentRepository.save(student); // db ye kayıt edildi ve db deki kayıt dbStudent e verildi
		BeanUtils.copyProperties(dbStudent, response); // dbStudent deki bilgiler response a kopyalandı.
		return response; // çıktı olarak response döndü.(isim ve soyisim çıktı olarak verildi.)
	}

	@Override
	public List<Student> getAll() {
		List<Student> studentList = studentRepository.findAll();
		return studentList;
	}

	@Override
	public Student getStudentById(Integer id) {
		Optional<Student> optional = studentRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		else {
			return null;
		}
	}

	@Override
	public void deleteStudentById(Integer id) {
		Student dbStudent = getStudentById(id);
		if(dbStudent != null) {
			studentRepository.delete(dbStudent);
		}
	}

	@Override
	public Student updateStudent(Integer id, Student updateStudent) {
		Student dbStudent = getStudentById(id);
		if(dbStudent != null) {
			dbStudent.setFirstName(updateStudent.getFirstName());
			dbStudent.setLastName(updateStudent.getLastName());
			dbStudent.setBirthDate(updateStudent.getBirthDate());
			
			return studentRepository.save(dbStudent);
		}
		else {
			return null;
		}
	}
	
}
