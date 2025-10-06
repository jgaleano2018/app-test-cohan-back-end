package com.cohan.test.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cohan.test.domain.model.Professor;
import com.cohan.test.domain.port.in.ProfessorUseCases;
import com.cohan.test.domain.port.out.ProfessorRepositoryPort;

import java.util.List;
import java.util.UUID;

@Service
public class ProfessorService implements ProfessorUseCases {
    private final ProfessorRepositoryPort repository;

    public ProfessorService(ProfessorRepositoryPort repository){
        this.repository = repository;
    }

    @Override
    @Transactional
    public Professor create(Professor professor){
        // add domain validations here
        return repository.save(professor);
    }

    @Override
    @Transactional
    public Professor update(UUID id, Professor professor){
    	Professor existing = repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    	
    	existing.setIdProfessor(professor.getIdProfessor());
    	existing.setSalary(professor.getSalary());
    	existing.setIdPerson(professor.getIdPerson());
    	    	
        return repository.save(existing);
    }

    @Override
    public Professor getById(UUID id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public List<Professor> getAll(){
        return repository.findAll();
    }

    @Override
    @Transactional
    public void delete(UUID id){
        repository.delete(id);
    }
}