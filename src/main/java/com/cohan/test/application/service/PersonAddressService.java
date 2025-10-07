package com.cohan.test.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cohan.test.adapters.outbound.persistence.jpa.PersonAddressEntity;
import com.cohan.test.domain.model.PersonAddress;
import com.cohan.test.domain.port.in.PersonAddressUseCases;
import com.cohan.test.domain.port.out.PersonAddressRepositoryPort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonAddressService implements PersonAddressUseCases {
    private final PersonAddressRepositoryPort repository;

    public PersonAddressService(PersonAddressRepositoryPort repository){
        this.repository = repository;
    }

    @Override
    @Transactional
    public PersonAddress create(PersonAddress personAddress){
        // add domain validations here
        return repository.save(personAddress);
    }

    @Override
    @Transactional
    public PersonAddress update(UUID id, PersonAddress personAddress){
    	PersonAddress existing = repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    	
    	existing.setIdPersonAddress(personAddress.getIdPersonAddress());
    	existing.setIdPerson(personAddress.getIdPerson());
    	existing.setIdAddress(personAddress.getIdAddress());
    	    	
        return repository.save(existing);
    }

    @Override
    public PersonAddress getById(UUID id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public List<PersonAddress> getAll(){
        
       List<PersonAddress> listPersonAddressInitial = this.repository.findAll();
   	 
       List<PersonAddress> listPersonAddressInitialNew = new ArrayList<>();
 
	   for (PersonAddress itemPerson : listPersonAddressInitial) {
			 
		 PersonAddress personModel = new PersonAddress();    		 
		 personModel = itemPerson;
		 
		 System.out.print("IPERSON:: " + itemPerson.getIdPerson());
		 System.out.print("idaddress:: " + itemPerson.getIdPersonAddress());
		 
		 
		 //Optional<PersonAddressEntity> pfilter = this.repository.findByIdPersonAndIdAddress(itemPerson.getIdPerson(), itemPerson.getIdAddress());
		 Optional<PersonAddressEntity> pfilter = this.repository.findByIdPerson(itemPerson.getIdPerson());
		 
		 personModel.setIdPerson(pfilter.get().getId_person());
		 personModel.setIdAddress(pfilter.get().getId_address());
		 personModel.setIdPersonAddress(pfilter.get().getId_person_address());
		 
					 
		 listPersonAddressInitialNew.add(personModel);
	   }
   	 
       return listPersonAddressInitialNew;
    }

    @Override
    @Transactional
    public void delete(UUID id){
        repository.delete(id);
    }
}