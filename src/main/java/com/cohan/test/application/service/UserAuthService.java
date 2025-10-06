package com.cohan.test.application.service;

import com.cohan.test.adapters.mapper.UserMapper;
import com.cohan.test.adapters.outbound.persistence.jpa.User;
import com.cohan.test.domain.model.payload.UserResponse;
import com.cohan.test.adapters.outbound.persistence.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserAuthService {
    private final UserRepository userRepository;
    
    public UserAuthService(UserRepository userRepository) {
    	this.userRepository = userRepository;
    }

    public UserResponse getUserInfoById(Long id) {
        //log.debug("Getting user info by id: {}", id);

        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: %s.".formatted(id)));

        return UserMapper.mapToUserResponse(user);
    }

}
