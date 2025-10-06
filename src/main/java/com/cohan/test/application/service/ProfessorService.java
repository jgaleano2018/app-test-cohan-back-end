package com.cohan.test.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cohan.test.adapters.outbound.persistence.jpa.ProfessorEntity;
import com.cohan.test.domain.model.Professor;
import com.cohan.test.domain.port.in.ProfessorUseCases;
import com.cohan.test.domain.port.out.ProfessorRepositoryPort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
    	
    	Professor presponse = new Professor();  
    	
    	try {
    		
    		this.repository.save(professor);
    		
	    	Optional<ProfessorEntity> pfilter = this.repository.findByIdPerson(professor.getIdPerson());
	    	
	    	presponse = professor;    	
	    	
			presponse.setIdProfessor(pfilter.get().getIdProfessor());
		
	    } catch (Exception e) {
	    	
	        throw new IllegalArgumentException("Error: "+e.getMessage());
	    }
    	
        return presponse;
    }

    @Override
    @Transactional
    public Professor update(UUID id, Professor professor){
    	Professor existing = repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    	
    	existing.setIdProfessor(professor.getIdProfessor());
    	existing.setSalary(professor.getSalary());
    	existing.setIdPerson(professor.getIdPerson());
    	
    	Professor presponse = existing;    	
    	presponse.setIdProfessor(id);
    	
    	this.repository.save(existing);
    	    	
        return presponse;
    }

    @Override
    public Professor getById(UUID id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public List<Professor> getAll(){
    	
    	List<Professor> listProfessorsInitial = this.repository.findAll();
    	
    	List<Professor> listProfessorsInitialNew = new ArrayList<>();
    	 
    	 for (Professor itemProfessor : listProfessorsInitial) {
    		 
    		 Professor professorModel = new Professor();    		 
    		 professorModel = itemProfessor;
    		 
    		 
    		 Optional<ProfessorEntity> pfilter = this.repository.findByIdPerson(itemProfessor.getIdPerson());
    		 
    		 professorModel.setIdProfessor(pfilter.get().getIdProfessor());
    					 
    		 listProfessorsInitialNew.add(professorModel);
         }
    	 
        return listProfessorsInitialNew;        
    }

    @Override
    @Transactional
    public void delete(UUID id){
        repository.delete(id);
    }
}