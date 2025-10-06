package com.cohan.test.adapters.outbound.persistence;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.cohan.test.adapters.outbound.persistence.jpa.PersonEntity;
import com.cohan.test.adapters.outbound.persistence.repository.SpringPersonRepository;
import com.cohan.test.domain.model.Person;
import com.cohan.test.domain.port.out.PersonRepositoryPort;

@Component
public class PersonRepositoryAdapter implements PersonRepositoryPort {

    private final SpringPersonRepository springRepo;

    public PersonRepositoryAdapter(SpringPersonRepository springRepo){
        this.springRepo = springRepo;
    }

    private Person toDomain(PersonEntity e) { 
    	UUID newUUID = null;
    	return new Person(newUUID, e.getName(), e.getPhone(), e.getEmail_address());
    }
    
    private PersonEntity toEntity(Person c) { 
    	PersonEntity e = new PersonEntity();    	
    	e.setId_Person(c.getId_Person());
    	e.setName(c.getEmail());
    	e.setPhone(c.getPhone());
    	e.setEmail_address(c.getEmail());
		return e;
	}

    @Override
    public Person save(Person person){
    	PersonEntity entity = toEntity(person);
        if (entity.getId_Person() == null) entity.setId_Person(person.getId_Person());
        PersonEntity saved = springRepo.save(entity);
        return toDomain(saved);
    }

    @Override
	public Optional<Person> findById(UUID id) {
		return springRepo.findById(id).map(this::toDomain);
	}
	
	
	@Override
	public List<Person> findAll() {
		return springRepo.findAll().stream().map(this::toDomain).collect(Collectors.toList());
	}
	
    
    @Override public void delete(UUID id){ springRepo.deleteById(id); }
}
