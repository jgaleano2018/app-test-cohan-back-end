package com.cohan.test.domain.model;

import java.util.UUID;

public class Rol {
	private UUID idRol; // matches id_colaborador INT
	private String name;
	
	// constructors, getters, setters
	
	
	public Rol() {}
	
	
	public Rol(UUID idRol, String name) {
		this.idRol = idRol;
		this.name = name;
	}


	public UUID getIdRol() {
		return idRol;
	}


	public void setIdRol(UUID idRol) {
		this.idRol = idRol;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	
}