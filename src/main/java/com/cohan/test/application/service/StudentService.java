package com.cohan.test.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cohan.test.adapters.outbound.persistence.jpa.StudentEntity;
import com.cohan.test.domain.model.Student;
import com.cohan.test.domain.port.in.StudentUseCases;
import com.cohan.test.domain.port.out.StudentRepositoryPort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService implements StudentUseCases {
    private final StudentRepositoryPort repository;

    public StudentService(StudentRepositoryPort repository){
        this.repository = repository;
    }

    @Override
    @Transactional
    public Student create(Student student){
        // add domain validations here
    	
    	Student presponse = new Student();  
    	
    	try {
    		
    		this.repository.save(student);
    		
	    	Optional<StudentEntity> pfilter = this.repository.findByIdPerson(student.getIdPerson());
	    	
	    	presponse = student;    	
	    	
			presponse.setIdStudent(pfilter.get().getIdStudent());
		
	    } catch (Exception e) {
	    	
	        throw new IllegalArgumentException("Error: "+e.getMessage());
	    }
    	
        return presponse;
    }

    @Override
    @Transactional
    public Student update(UUID id, Student student){
    	Student existing = repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    	
    	existing.setIdStudent(student.getIdStudent());
    	existing.setIdPerson(student.getIdPerson());
    	existing.setStudent(student.getStudent());
    	existing.setAverageMark(student.getAverageMark());
    	
    	Student presponse = existing;    	
    	presponse.setIdStudent(id);
    	
    	this.repository.save(existing);
    	    	
        return presponse;
    }

    @Override
    public Student getById(UUID id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public List<Student> getAll(){
    	
    	List<Student> listStudentsInitial = this.repository.findAll();
    	
    	List<Student> listStudentsInitialNew = new ArrayList<>();
    	 
    	 for (Student itemStudent : listStudentsInitial) {
    		 
    		 Student professorModel = new Student();    		 
    		 professorModel = itemStudent;
    		 
    		 
    		 Optional<StudentEntity> pfilter = this.repository.findByIdPerson(itemStudent.getIdPerson());
    		 
    		 professorModel.setIdStudent(pfilter.get().getIdStudent());
    					 
    		 listStudentsInitialNew.add(professorModel);
         }
    	 
        return listStudentsInitialNew;    
        
    }

    @Override
    @Transactional
    public void delete(UUID id){
        repository.delete(id);
    }
}