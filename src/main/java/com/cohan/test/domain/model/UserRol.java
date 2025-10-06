package com.cohan.test.domain.model;

import java.util.UUID;

public class UserRol {
	private UUID idUserRol; // matches id_colaborador INT
	private UUID idUser;
	private UUID idRol;
	
	// constructors, getters, setters
	
	
	public UserRol() {}
	
	
	public UserRol(UUID idUserRol, UUID idUser, UUID idRol) {
		this.idUserRol = idUserRol;
		this.idUser = idUser;
		this.idRol = idRol;
	}


	public UUID getIdUserRol() {
		return idUserRol;
	}


	public void setIdUserRol(UUID idUserRol) {
		this.idUserRol = idUserRol;
	}


	public UUID getIdUser() {
		return idUser;
	}


	public void setIdUser(UUID idUser) {
		this.idUser = idUser;
	}


	public UUID getIdRol() {
		return idRol;
	}


	public void setIdRol(UUID idRol) {
		this.idRol = idRol;
	}
	
	
}