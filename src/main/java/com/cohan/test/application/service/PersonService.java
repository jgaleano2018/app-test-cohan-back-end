package com.cohan.test.application.service;

import java.util.ArrayList;
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
    	
    	Person presponse = new Person();  
    	
    	try {
    		
    		this.repository.save(person);
    		
	    	Optional<PersonEntity> pfilter = this.repository.findByEmail(person.getEmail());
	    	
	    	presponse = person;    	
	    	
	    	pfilter = this.repository.findByEmail(person.getEmail());
			presponse.setId_Person(pfilter.get().getId_Person());
		
	    } catch (Exception e) {
	    	
	        throw new IllegalArgumentException("Error: "+e.getMessage());
	    }
    	
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
    	
    	Person presponse = existing;    	
    	presponse.setId_Person(id);
    	
    	this.repository.save(existing);
    	    	
        return presponse;
    }

    @Override
    public Person getById(UUID id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public List<Person> getAll(){
    	 List<Person> listPersonsInitial = this.repository.findAll();
    	 
    	 List<Person> listPersonsInitialNew = new ArrayList<>();
    	 
    	 for (Person itemPerson : listPersonsInitial) {
    		 
    		 Person personModel = new Person();    		 
    		 personModel = itemPerson;
    		 
    		 System.out.print("Email VALUEEEE:: " + personModel.getEmail());
    		 
    		 Optional<PersonEntity> pfilter = this.repository.findByEmail(itemPerson.getEmail());
    		 
    		 personModel.setId_Person(pfilter.get().getId_Person());
    					 
    		 listPersonsInitialNew.add(personModel);
         }
    	 
        return listPersonsInitialNew;
    }

    @Override
    @Transactional
    public void delete(UUID id){
        repository.delete(id);
    }
}