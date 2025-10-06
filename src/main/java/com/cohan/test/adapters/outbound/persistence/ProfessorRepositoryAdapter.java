package com.cohan.test.adapters.outbound.persistence;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.cohan.test.adapters.outbound.persistence.jpa.ProfessorEntity;
import com.cohan.test.adapters.outbound.persistence.repository.SpringProfessorRepository;
import com.cohan.test.domain.model.Professor;
import com.cohan.test.domain.port.out.ProfessorRepositoryPort;

@Component
public class ProfessorRepositoryAdapter implements ProfessorRepositoryPort {

    private final SpringProfessorRepository springRepo;

    public ProfessorRepositoryAdapter(SpringProfessorRepository springRepo){
        this.springRepo = springRepo;
    }

    private Professor toDomain(ProfessorEntity e) { 
    	return new Professor(e.getIdProfessor(), e.getSalary(), e.getIdPerson());
    }
        
    private ProfessorEntity toEntity(Professor c) { 
    	ProfessorEntity e = new ProfessorEntity();    	
    	e.setIdProfessor(c.getIdProfessor());
    	e.setSalary(c.getSalary());
    	e.setIdPerson(c.getIdPerson());
		return e;
	}

    @Override
    public Professor save(Professor professor){
    	ProfessorEntity entity = toEntity(professor);
        if (entity.getIdProfessor() == null) entity.setIdProfessor(professor.getIdProfessor());
        ProfessorEntity saved = springRepo.save(entity);
        return toDomain(saved);
    }

    @Override
	public Optional<Professor> findById(UUID id) {
		return springRepo.findById(id).map(this::toDomain);
	}
	
	
	@Override
	public List<Professor> findAll() {
		return springRepo.findAll().stream().map(this::toDomain).collect(Collectors.toList());
	}
	
	public Optional<ProfessorEntity> findByIdPerson(UUID idPerson) {
		return springRepo.findByIdPerson(idPerson);
	}
	
    
    @Override public void delete(UUID id){ springRepo.deleteById(id); }
}
