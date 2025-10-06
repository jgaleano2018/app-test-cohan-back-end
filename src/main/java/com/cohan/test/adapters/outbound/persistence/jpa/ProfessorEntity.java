package com.cohan.test.adapters.outbound.persistence.jpa;

import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "professor")
public class ProfessorEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_professor", updatable = false, nullable = false)
	private UUID idProfessor; // matches id_colaborador INT
	private Double salary;
	private UUID idPerson;
	
    
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


    // constructors, getters, setters
}
