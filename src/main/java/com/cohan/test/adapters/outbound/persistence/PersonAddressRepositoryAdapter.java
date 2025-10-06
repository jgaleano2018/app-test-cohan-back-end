package com.cohan.test.adapters.outbound.persistence;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.cohan.test.adapters.outbound.persistence.jpa.PersonAddressEntity;
import com.cohan.test.adapters.outbound.persistence.repository.SpringPersonAddressRepository;
import com.cohan.test.domain.model.PersonAddress;
import com.cohan.test.domain.port.out.PersonAddressRepositoryPort;

@Component
public class PersonAddressRepositoryAdapter implements PersonAddressRepositoryPort {

    private final SpringPersonAddressRepository springRepo;

    public PersonAddressRepositoryAdapter(SpringPersonAddressRepository springRepo){
        this.springRepo = springRepo;
    }

    private PersonAddress toDomain(PersonAddressEntity e) { 
    	UUID newUUID = null;
    	return new PersonAddress(newUUID, e.getId_person(), e.getId_person());
    }
    
    private PersonAddressEntity toEntity(PersonAddress c) { 
    	PersonAddressEntity e = new PersonAddressEntity();    	
    	e.setId_person_address(c.getIdPersonAddress());
    	e.setId_person(c.getIdPerson());
    	e.setId_address(c.getIdAddress());    	
		return e;
	}

    @Override
    public PersonAddress save(PersonAddress address){
    	PersonAddressEntity entity = toEntity(address);
        if (entity.getId_address() == null) entity.setId_address(address.getIdAddress());
        PersonAddressEntity saved = springRepo.save(entity);
        return toDomain(saved);
    }

    @Override
	public Optional<PersonAddress> findById(UUID id) {
		return springRepo.findById(id).map(this::toDomain);
	}
	
	
	@Override
	public List<PersonAddress> findAll() {
		return springRepo.findAll().stream().map(this::toDomain).collect(Collectors.toList());
	}
	
    
    @Override public void delete(UUID id){ springRepo.deleteById(id); }
}
