package com.cohan.test.adapters.outbound.persistence.jpa;

import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "rol")
public class RolEntity {
   
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_rol")
    
    private UUID idRol; // matches id_colaborador INT
	private String name;
    
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

    // constructors, getters, setters
}
