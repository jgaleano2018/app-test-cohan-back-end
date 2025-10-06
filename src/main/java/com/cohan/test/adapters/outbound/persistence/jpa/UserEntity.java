package com.cohan.test.adapters.outbound.persistence.jpa;

import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class UserEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_user")
	
    private UUID idUser; // matches id_colaborador INT
    private String userName;
	private String password;
    
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


    // constructors, getters, setters
}
