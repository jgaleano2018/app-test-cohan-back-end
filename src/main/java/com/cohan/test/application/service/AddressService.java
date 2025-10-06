package com.cohan.test.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cohan.test.domain.model.Address;
import com.cohan.test.domain.port.in.AddressUseCases;
import com.cohan.test.domain.port.out.AddressRepositoryPort;

import java.util.List;
import java.util.UUID;

@Service
public class AddressService implements AddressUseCases {
    private final AddressRepositoryPort repository;

    public AddressService(AddressRepositoryPort repository){
        this.repository = repository;
    }

    @Override
    @Transactional
    public Address create(Address address){
        // add domain validations here
        return repository.save(address);
    }

    @Override
    @Transactional
    public Address update(UUID id, Address address){
    	Address existing = repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    	
    	existing.setIdAddress(address.getIdAddress());
    	existing.setStreet(address.getStreet());
    	existing.setCity(address.getCity());
    	existing.setState(address.getState());
    	existing.setPostalCode(address.getPostalCode());
    	existing.setCountry(address.getCountry());
    	
        return repository.save(existing);
    }

    @Override
    public Address getById(UUID id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public List<Address> getAll(){
        return repository.findAll();
    }

    @Override
    @Transactional
    public void delete(UUID id){
        repository.delete(id);
    }
}