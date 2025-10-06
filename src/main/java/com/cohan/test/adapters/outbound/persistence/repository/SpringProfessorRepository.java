package com.cohan.test.adapters.outbound.persistence.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cohan.test.adapters.outbound.persistence.jpa.ProfessorEntity;

public interface SpringProfessorRepository extends JpaRepository<ProfessorEntity, UUID> { 

	Optional<ProfessorEntity> findByIdPerson(UUID idPerson); 
}