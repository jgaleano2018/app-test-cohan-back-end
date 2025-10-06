package com.cohan.test.domain.port.out;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.cohan.test.domain.model.Rol;

public interface RolRepositoryPort {
	Rol save(Rol c);
    Optional<Rol> findById(UUID id);
    List<Rol> findAll();
    void delete(UUID id);
}