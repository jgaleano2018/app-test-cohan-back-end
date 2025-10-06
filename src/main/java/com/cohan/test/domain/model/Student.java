package com.cohan.test.domain.model;

import java.util.UUID;

public class Student {
	private UUID idStudent; // matches id_colaborador INT
	private UUID idPerson;
	private Integer student;
	private Double averageMark;
	
	// constructors, getters, setters
	
	
	public Student() {}
	
	
	public Student(UUID idStudent, UUID idPerson, Integer student, Double averageMark) {
		this.idStudent = idStudent;
		this.idPerson = idPerson;
		this.student = student;
		this.averageMark = averageMark;
	}


	public Integer getStudent() {
		return student;
	}


	public void setStudent(Integer student) {
		this.student = student;
	}


	public Double getAverageMark() {
		return averageMark;
	}


	public void setAverageMark(Double averageMark) {
		this.averageMark = averageMark;
	}


	public UUID getIdStudent() {
		return idStudent;
	}


	public void setIdStudent(UUID idStudent) {
		this.idStudent = idStudent;
	}


	public UUID getIdPerson() {
		return idPerson;
	}


	public void setIdPerson(UUID idPerson) {
		this.idPerson = idPerson;
	}

	
}