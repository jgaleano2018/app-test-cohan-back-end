package com.cohan.test.domain.model;

import java.util.UUID;

public class PersonAddress {
	private UUID idPersonAddress; // matches id_colaborador INT
	private UUID idPerson;
	private UUID idAddress;
	
	// constructors, getters, setters
	
	
	public PersonAddress() {}
	
	
	public PersonAddress(UUID idPersonAddress, UUID idPerson, UUID idAddress) {
		this.setIdPersonAddress(idPersonAddress);
		this.setIdPerson(idPerson);
		this.setIdAddress(idAddress);
	}


	public UUID getIdPersonAddress() {
		return idPersonAddress;
	}


	public void setIdPersonAddress(UUID idPersonAddress) {
		this.idPersonAddress = idPersonAddress;
	}


	public UUID getIdPerson() {
		return idPerson;
	}


	public void setIdPerson(UUID idPerson) {
		this.idPerson = idPerson;
	}


	public UUID getIdAddress() {
		return idAddress;
	}


	public void setIdAddress(UUID idAddress) {
		this.idAddress = idAddress;
	}


	
	
}