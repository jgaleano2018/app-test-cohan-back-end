package com.cohan.test.adapters.outbound.persistence.jpa;

import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "personAddress")
public class PersonAddressEntity {	
	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_person_address")	
    private UUID idPersonAddress;
	
	@Column(name = "id_person")	
    private UUID idPerson;
	
	@Column(name = "id_address")
    private UUID idAddress;

    public UUID getId_person_address() {
		return idPersonAddress;
	}
	public void setId_person_address(UUID id_person_address) {
		this.idPersonAddress = id_person_address;
	}
	public UUID getId_person() {
		return idPerson;
	}
	public void setId_person(UUID id_person) {
		this.idPerson = id_person;
	}
	public UUID getId_address() {
		return idAddress;
	}
	public void setId_address(UUID id_address) {
		this.idAddress = id_address;
	}
    


    // constructors, getters, setters
}
