package com.cohan.test.domain.port.out;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.cohan.test.domain.model.User;

public interface UserRepositoryPort {
	User save(User c);
    Optional<User> findById(UUID id);
    List<User> findAll();
    void delete(UUID id);
}