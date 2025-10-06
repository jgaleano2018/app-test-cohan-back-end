package com.cohan.test.domain.port.in;

import java.util.List;
import java.util.UUID;

import com.cohan.test.domain.model.PersonAddress;

public interface PersonAddressUseCases {
	PersonAddress create(PersonAddress personAddress);
	PersonAddress update(UUID id, PersonAddress personAddress);
	PersonAddress getById(UUID id);
    List<PersonAddress> getAll();
    void delete(UUID id);
}