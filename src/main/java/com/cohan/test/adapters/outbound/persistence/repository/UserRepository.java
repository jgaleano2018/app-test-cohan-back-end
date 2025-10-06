package com.cohan.test.adapters.outbound.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cohan.test.adapters.outbound.persistence.jpa.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

}
