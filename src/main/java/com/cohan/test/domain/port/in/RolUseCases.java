package com.cohan.test.domain.port.in;

import java.util.List;
import java.util.UUID;

import com.cohan.test.domain.model.Rol;

public interface RolUseCases {
	Rol create(Rol rol);
	Rol update(UUID id, Rol rol);
	Rol getById(UUID id);
    List<Rol> getAll();
    void delete(UUID id);
}