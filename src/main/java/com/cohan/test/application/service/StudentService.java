package com.cohan.test.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cohan.test.domain.model.Student;
import com.cohan.test.domain.port.in.StudentUseCases;
import com.cohan.test.domain.port.out.StudentRepositoryPort;

import java.util.List;
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
        return repository.save(student);
    }

    @Override
    @Transactional
    public Student update(UUID id, Student student){
    	Student existing = repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    	
    	existing.setIdStudent(student.getIdStudent());
    	existing.setIdPerson(student.getIdPerson());
    	existing.setStudent(student.getStudent());
    	existing.setAverageMark(student.getAverageMark());
    	
        return repository.save(existing);
    }

    @Override
    public Student getById(UUID id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Override
    public List<Student> getAll(){
        return repository.findAll();
    }

    @Override
    @Transactional
    public void delete(UUID id){
        repository.delete(id);
    }
}