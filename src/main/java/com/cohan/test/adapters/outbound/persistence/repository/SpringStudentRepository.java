package com.cohan.test.adapters.outbound.persistence.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cohan.test.adapters.outbound.persistence.jpa.StudentEntity;

public interface SpringStudentRepository extends JpaRepository<StudentEntity, UUID> { 
	
	Optional<StudentEntity> findByIdPerson(UUID idPerson); 
}