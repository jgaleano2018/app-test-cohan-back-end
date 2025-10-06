package com.cohan.test.domain.port.out;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.cohan.test.adapters.outbound.persistence.jpa.ProfessorEntity;
import com.cohan.test.domain.model.Professor;

public interface ProfessorRepositoryPort {
	Professor save(Professor c);
    Optional<Professor> findById(UUID id);
    Optional<ProfessorEntity> findByIdPerson(UUID idPerson); 
    List<Professor> findAll();
    void delete(UUID id);
}