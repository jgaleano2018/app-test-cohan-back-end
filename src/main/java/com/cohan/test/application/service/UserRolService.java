package com.cohan.test.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cohan.test.domain.model.UserRol;
import com.cohan.test.domain.port.in.UserRolUseCases;
import com.cohan.test.domain.port.out.UserRolRepositoryPort;

import java.util.List;
import java.util.UUID;

@Service
public class UserRolService implements UserRolUseCases {
    private final UserRolRepositoryPort repository;

    public UserRolService(UserRolRepositoryPort repository){
        this.repository = repository;
    }

    @Override
    @Transactional
    public UserRol create(UserRol userRol){
        // add domain validations here
        return repository.save(userRol);
    }

    @Override
    @Transactional
    public UserRol update(UUID id, UserRol userRol){
    	UserRol existing = repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    	
    	existing.setIdUserRol(userRol.getIdUserRol());
    	existing.setIdUser(userRol.getIdUser());
    	existing.setIdRol(userRol.getIdRol());
    	    	    	
        return repository.save(existing);
    }

    @Override
    public UserRol getById(UUID id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public List<UserRol> getAll(){
        return repository.findAll();
    }

    @Override
    @Transactional
    public void delete(UUID id){
        repository.delete(id);
    }
}