package com.cohan.test.adapters.outbound.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cohan.test.adapters.outbound.persistence.jpa.UserRolEntity;

public interface SpringUserRolRepository extends JpaRepository<UserRolEntity, UUID> { }