package com.cohan.test.domain.model;

import java.util.UUID;

public class Professor {
	private UUID idProfessor; // matches id_colaborador INT
	private Double salary;
	private UUID idPerson;
	
	// constructors, getters, setters
	
	
	public Professor() {}
	
	
	public Professor(UUID idProfessor, Double salary, UUID idPerson) {
		this.idProfessor = idProfessor;
		this.salary = salary;
		this.idPerson = idPerson;		
	}


	public UUID getIdProfessor() {
		return idProfessor;
	}


	public void setIdProfessor(UUID idProfessor) {
		this.idProfessor = idProfessor;
	}


	public Double getSalary() {
		return salary;
	}


	public void setSalary(Double salary) {
		this.salary = salary;
	}


	public UUID getIdPerson() {
		return idPerson;
	}


	public void setIdPerson(UUID idPerson) {
		this.idPerson = idPerson;
	}


	
}