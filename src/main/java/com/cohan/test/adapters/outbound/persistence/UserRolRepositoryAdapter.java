package com.cohan.test.adapters.outbound.persistence;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.cohan.test.adapters.outbound.persistence.jpa.UserRolEntity;
import com.cohan.test.adapters.outbound.persistence.repository.SpringUserRolRepository;
import com.cohan.test.domain.model.UserRol;
import com.cohan.test.domain.port.out.UserRolRepositoryPort;

@Component
public class UserRolRepositoryAdapter implements UserRolRepositoryPort {

    private final SpringUserRolRepository springRepo;

    public UserRolRepositoryAdapter(SpringUserRolRepository springRepo){
        this.springRepo = springRepo;
    }

    private UserRol toDomain(UserRolEntity e) { 
    	return new UserRol(e.getIdUserRol(), e.getIdUser(), e.getIdRol());
    }
            
    private UserRolEntity toEntity(UserRol c) { 
    	UserRolEntity e = new UserRolEntity();
    	e.setIdUserRol(c.getIdUserRol());
    	e.setIdUser(c.getIdUser());
    	e.setIdRol(c.getIdRol());
    	return e;
	}

    @Override
    public UserRol save(UserRol userRol){
    	UserRolEntity entity = toEntity(userRol);
        if (entity.getIdUserRol() == null) entity.setIdUserRol(userRol.getIdUserRol());
        UserRolEntity saved = springRepo.save(entity);
        return toDomain(saved);
    }

    @Override
	public Optional<UserRol> findById(UUID id) {
		return springRepo.findById(id).map(this::toDomain);
	}
	
	
	@Override
	public List<UserRol> findAll() {
		return springRepo.findAll().stream().map(this::toDomain).collect(Collectors.toList());
	}
	
    
    @Override public void delete(UUID id){ springRepo.deleteById(id); }
}
