package com.cohan.test.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cohan.test.domain.model.Rol;
import com.cohan.test.domain.port.in.RolUseCases;
import com.cohan.test.domain.port.out.RolRepositoryPort;

import java.util.List;
import java.util.UUID;

@Service
public class RolService implements RolUseCases {
    private final RolRepositoryPort repository;

    public RolService(RolRepositoryPort repository){
        this.repository = repository;
    }

    @Override
    @Transactional
    public Rol create(Rol rol){
        // add domain validations here
        return repository.save(rol);
    }

    @Override
    @Transactional
    public Rol update(UUID id, Rol rol){
    	Rol existing = repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    	
    	existing.setIdRol(rol.getIdRol());
    	existing.setName(rol.getName());
    	    	
        return repository.save(existing);
    }

    @Override
    public Rol getById(UUID id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public List<Rol> getAll(){
        return repository.findAll();
    }

    @Override
    @Transactional
    public void delete(UUID id){
        repository.delete(id);
    }
}