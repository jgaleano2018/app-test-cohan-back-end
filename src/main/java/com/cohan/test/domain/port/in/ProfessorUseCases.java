package com.cohan.test.domain.port.in;

import java.util.List;
import java.util.UUID;

import com.cohan.test.domain.model.Professor;

public interface ProfessorUseCases {
	Professor create(Professor professor);
	Professor update(UUID id, Professor professor);
	Professor getById(UUID id);
    List<Professor> getAll();
    void delete(UUID id);
}