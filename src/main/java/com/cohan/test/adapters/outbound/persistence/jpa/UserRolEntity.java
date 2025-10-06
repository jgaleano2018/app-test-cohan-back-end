package com.cohan.test.adapters.outbound.persistence.jpa;

import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "userRol")
public class UserRolEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_user_rol", updatable = false, nullable = false)
    private UUID idUserRol; // matches id_colaborador INT
    private UUID idUser;
	private UUID idRol;
    
	public UUID getIdUserRol() {
		return idUser;
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

    // constructors, getters, setters
}
