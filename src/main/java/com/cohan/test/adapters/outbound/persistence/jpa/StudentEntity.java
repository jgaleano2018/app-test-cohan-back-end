package com.cohan.test.adapters.outbound.persistence.jpa;

import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class StudentEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_student")
 
    private UUID idStudent; // matches id_colaborador INT
	private UUID idPerson;
	private Integer student;
	private Double averageMark;
    
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

    // constructors, getters, setters
}
