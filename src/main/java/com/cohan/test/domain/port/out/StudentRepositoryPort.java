package com.cohan.test.domain.port.out;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.cohan.test.adapters.outbound.persistence.jpa.StudentEntity;
import com.cohan.test.domain.model.Student;

public interface StudentRepositoryPort {
	Student save(Student c);
    Optional<Student> findById(UUID id);
    Optional<StudentEntity> findByIdPerson(UUID idPerson); 
    List<Student> findAll();
    void delete(UUID id);
}