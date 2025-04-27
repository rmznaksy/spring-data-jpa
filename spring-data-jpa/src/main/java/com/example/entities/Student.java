package com.example.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="fist_name", nullable = false)
	private String firstName;

	@Column(name="last_name", nullable = false)
	private String lastName;
	
	@DateTimeFormat(iso = ISO.DATE)
	//@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name="birth_of_date", nullable = false)
	private Date birthDate;
	
	public Student() {}

	public Student(Integer id, String firstName, String lastName, Date birthDate) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	

}
