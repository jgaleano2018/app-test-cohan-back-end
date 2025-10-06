package com.cohan.test.adapters.outbound.persistence;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.cohan.test.adapters.outbound.persistence.jpa.RolEntity;
import com.cohan.test.adapters.outbound.persistence.repository.SpringRolRepository;
import com.cohan.test.domain.model.Rol;
import com.cohan.test.domain.port.out.RolRepositoryPort;

@Component
public class RolRepositoryAdapter implements RolRepositoryPort {

    private final SpringRolRepository springRepo;

    public RolRepositoryAdapter(SpringRolRepository springRepo){
        this.springRepo = springRepo;
    }

    private Rol toDomain(RolEntity e) { 
    	return new Rol(e.getIdRol(), e.getName());
    }
        
    private RolEntity toEntity(Rol c) { 
    	RolEntity e = new RolEntity();    	
    	e.setIdRol(c.getIdRol());
    	e.setName(c.getName());
		return e;
	}

    @Override
    public Rol save(Rol rol){
    	RolEntity entity = toEntity(rol);
        if (entity.getIdRol() == null) entity.setIdRol(rol.getIdRol());
        RolEntity saved = springRepo.save(entity);
        return toDomain(saved);
    }

    @Override
	public Optional<Rol> findById(UUID id) {
		return springRepo.findById(id).map(this::toDomain);
	}
	
	
	@Override
	public List<Rol> findAll() {
		return springRepo.findAll().stream().map(this::toDomain).collect(Collectors.toList());
	}
	
    
    @Override public void delete(UUID id){ springRepo.deleteById(id); }
}
