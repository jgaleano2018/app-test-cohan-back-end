package com.cohan.test.domain.port.in;

import java.util.List;
import java.util.UUID;

import com.cohan.test.domain.model.Student;

public interface StudentUseCases {
	Student create(Student student);
	Student update(UUID id, Student student);
	Student getById(UUID id);
    List<Student> getAll();
    void delete(UUID id);
}