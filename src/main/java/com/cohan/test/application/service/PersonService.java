package com.cohan.test.application.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cohan.test.adapters.outbound.persistence.jpa.PersonEntity;
import com.cohan.test.domain.model.Person;
import com.cohan.test.domain.port.in.PersonUseCases;
import com.cohan.test.domain.port.out.PersonRepositoryPort;

@Service
public class PersonService implements PersonUseCases {
    private final PersonRepositoryPort repository;

    public PersonService(PersonRepositoryPort repository){
        this.repository = repository;
    }

    @Override
    @Transactional
    public Person create(Person person){
        // add domain validations here
    	
    	this.repository.save(person);
    	
    	Optional<PersonEntity> pfilter = this.repository.findByEmail(person.getEmail());
    	
    	Person presponse = person;
    	
    	presponse.setId_Person(pfilter.get().getId_Person());
    	
        return presponse;
    }

    @Override
    @Transactional
    public Person update(UUID id, Person person){
    	Person existing = repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    	
    	existing.setId_Person(person.getId_Person());
    	existing.setName(person.getName());
    	existing.setPhone(person.getPhone());
    	existing.setEmail(person.getEmail());
    	    	
        return repository.save(existing);
    }

    @Override
    public Person getById(UUID id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public List<Person> getAll(){
        return repository.findAll();
    }

    @Override
    @Transactional
    public void delete(UUID id){
        repository.delete(id);
    }
}