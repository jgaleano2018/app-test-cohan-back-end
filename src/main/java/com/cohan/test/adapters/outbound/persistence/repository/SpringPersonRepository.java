package com.cohan.test.adapters.outbound.persistence.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cohan.test.adapters.outbound.persistence.jpa.PersonEntity;

public interface SpringPersonRepository extends JpaRepository<PersonEntity, UUID> {

	Optional<PersonEntity> findByEmail(String email); 
	
}