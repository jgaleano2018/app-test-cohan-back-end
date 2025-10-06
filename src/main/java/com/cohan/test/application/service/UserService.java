package com.cohan.test.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cohan.test.domain.model.User;
import com.cohan.test.domain.port.in.UserUseCases;
import com.cohan.test.domain.port.out.UserRepositoryPort;

import java.util.List;
import java.util.UUID;

@Service
public class UserService implements UserUseCases {
    private final UserRepositoryPort repository;

    public UserService(UserRepositoryPort repository){
        this.repository = repository;
    }

    @Override
    @Transactional
    public User create(User user){
        // add domain validations here
        return repository.save(user);
    }

    @Override
    @Transactional
    public User update(UUID id, User user){
    	User existing = repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    	
    	existing.setIdUser(user.getIdUser());
    	existing.setUserName(user.getUserName());
    	existing.setPassword(user.getPassword());
    	    	
        return repository.save(existing);
    }

    @Override
    public User getById(UUID id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public List<User> getAll(){
        return repository.findAll();
    }

    @Override
    @Transactional
    public void delete(UUID id){
        repository.delete(id);
    }
}