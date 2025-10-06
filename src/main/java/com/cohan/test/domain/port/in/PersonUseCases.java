package com.cohan.test.domain.port.in;

import java.util.List;
import java.util.UUID;

import com.cohan.test.domain.model.Person;

public interface PersonUseCases {
	Person create(Person person);
	Person update(UUID id, Person person);
	Person getById(UUID id);
    List<Person> getAll();
    void delete(UUID id);
}