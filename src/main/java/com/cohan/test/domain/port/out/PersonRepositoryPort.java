package com.cohan.test.domain.port.out;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.cohan.test.domain.model.Person;

public interface PersonRepositoryPort {
	Person save(Person c);
    Optional<Person> findById(UUID id);
    List<Person> findAll();
    void delete(UUID id);
}