package com.cohan.test.domain.port.out;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.cohan.test.domain.model.PersonAddress;

public interface PersonAddressRepositoryPort {
	PersonAddress save(PersonAddress c);
    Optional<PersonAddress> findById(UUID id);
    List<PersonAddress> findAll();
    void delete(UUID id);
}