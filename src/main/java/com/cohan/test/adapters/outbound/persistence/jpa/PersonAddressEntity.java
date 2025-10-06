package com.cohan.test.adapters.outbound.persistence.jpa;

import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "personAddress")
public class PersonAddressEntity {	
	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_person_address")	
    private UUID id_person_address;
    private UUID id_person;
    private UUID id_address;
    public UUID getId_person_address() {
		return id_person_address;
	}
	public void setId_person_address(UUID id_person_address) {
		this.id_person_address = id_person_address;
	}
	public UUID getId_person() {
		return id_person;
	}
	public void setId_person(UUID id_person) {
		this.id_person = id_person;
	}
	public UUID getId_address() {
		return id_address;
	}
	public void setId_address(UUID id_address) {
		this.id_address = id_address;
	}
    


    // constructors, getters, setters
}
