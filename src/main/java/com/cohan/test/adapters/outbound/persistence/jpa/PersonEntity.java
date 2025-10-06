package com.cohan.test.adapters.outbound.persistence.jpa;

import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "person")
public class PersonEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_persona", updatable = false, nullable = false)
	private UUID idPersona; // matches id_colaborador INT
	private String name;
	private String phone;
	private String email_address;
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
	public String getEmail_address() {
		return email_address;
	}
	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}

    // constructors, getters, setters
}
