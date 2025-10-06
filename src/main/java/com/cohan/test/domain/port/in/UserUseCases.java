package com.cohan.test.domain.port.in;

import java.util.List;
import java.util.UUID;

import com.cohan.test.domain.model.User;

public interface UserUseCases {
	User create(User user);
	User update(UUID id, User user);
	User getById(UUID id);
    List<User> getAll();
    void delete(UUID id);
}