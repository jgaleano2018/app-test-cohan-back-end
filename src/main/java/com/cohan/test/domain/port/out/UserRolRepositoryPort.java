package com.cohan.test.domain.port.out;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.cohan.test.domain.model.UserRol;

public interface UserRolRepositoryPort {
	UserRol save(UserRol c);
    Optional<UserRol> findById(UUID id);
    List<UserRol> findAll();
    void delete(UUID id);
}