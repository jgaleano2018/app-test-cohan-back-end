package com.cohan.test.adapters.outbound.persistence;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.cohan.test.adapters.outbound.persistence.jpa.UserEntity;
import com.cohan.test.adapters.outbound.persistence.repository.SpringUserRepository;
import com.cohan.test.domain.model.User;
import com.cohan.test.domain.port.out.UserRepositoryPort;

@Component
public class UserRepositoryAdapter implements UserRepositoryPort {

    private final SpringUserRepository springRepo;

    public UserRepositoryAdapter(SpringUserRepository springRepo){
        this.springRepo = springRepo;
    }

    private User toDomain(UserEntity e) { 
    	return new User(e.getIdUser(), e.getUserName(), e.getPassword());
    }
            
    private UserEntity toEntity(User c) { 
    	UserEntity e = new UserEntity();    	
    	e.setIdUser(c.getIdUser());
    	e.setUserName(c.getUserName());
    	e.setPassword(c.getPassword());
		return e;
	}

    @Override
    public User save(User user){
    	UserEntity entity = toEntity(user);
        if (entity.getIdUser() == null) entity.setIdUser(user.getIdUser());
        UserEntity saved = springRepo.save(entity);
        return toDomain(saved);
    }

    @Override
	public Optional<User> findById(UUID id) {
		return springRepo.findById(id).map(this::toDomain);
	}
	
	
	@Override
	public List<User> findAll() {
		return springRepo.findAll().stream().map(this::toDomain).collect(Collectors.toList());
	}
	
    
    @Override public void delete(UUID id){ springRepo.deleteById(id); }
}
