package com.cohan.test.domain.port.in;

import java.util.List;
import java.util.UUID;

import com.cohan.test.domain.model.UserRol;

public interface UserRolUseCases {
	UserRol create(UserRol userRol);
	UserRol update(UUID id, UserRol userRol);
	UserRol getById(UUID id);
    List<UserRol> getAll();
    void delete(UUID id);
}