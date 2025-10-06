
package com.cohan.test.domain.model;

import java.util.UUID;

public class Person {
	private UUID id_person; // matches id_colaborador INT
	private String name;
	private String phone;
	private String email;
	
	// constructors, getters, setters
	
	
	public Person() {}
	
	
	public Person(UUID id_person, String name, String phone, String email) {
		this.id_person = id_person;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}


	public UUID getId_Person() {
		return id_person;
	}


	public void setId_Person(UUID id_person) {
		this.id_person = id_person;
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
	
	
}