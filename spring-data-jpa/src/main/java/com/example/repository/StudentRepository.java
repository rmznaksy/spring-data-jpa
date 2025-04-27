package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	/**
	 *  HQL(HibernateQueryLanguage)  : sınıf ismi ve değişken isimleri kullanılarak sorgu yazılır.
	 *  	@Query(value = "from Student", nativeQuery = false)
	 *  SQL(StructuredQueryLanguage) : tablo ismi ve tablodaki kolon isimleri kullanılarak sorgu yazılır ve 'nativeQuery = true' olur 
	 *  	@Query(value = "select * from student.student", nativeQuery = true)
	 */

	@Query(value = "from Student", nativeQuery = false)
	List<Student> findAllStudents();
	
	@Query(value = "from Student s WHERE s.id = :studentId")
	Student findStudentById(String studentId);
	
	

}
