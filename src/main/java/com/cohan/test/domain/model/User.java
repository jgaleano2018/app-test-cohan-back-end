package com.cohan.test.domain.model;

import java.util.UUID;

public class User {
	private UUID idUser; // matches id_colaborador INT
	private String userName;
	private String password;
	
	// constructors, getters, setters
	
	
	public User() {}
	
	
	public User(UUID idUser, String userName, String password) {
		this.idUser = idUser;
		this.userName = userName;
		this.password = password;
	}


	public UUID getIdUser() {
		return idUser;
	}


	public void setIdUser(UUID idUser) {
		this.idUser = idUser;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	
}