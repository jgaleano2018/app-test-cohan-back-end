package com.cohan.test.adapters.outbound.persistence.jpa;

import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "person")
public class PersonEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_person")
	
	private UUID idPersona; // matches id_colaborador INT
	private String name;
	private String phone;
	
	@Column(name = "email_address")	
	private String email;
	
	public UUID getId_Person() {
		return idPersona;
	}
	public void setId_Person(UUID id_person) {
		this.idPersona = id_person;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

    // constructors, getters, setters
}
