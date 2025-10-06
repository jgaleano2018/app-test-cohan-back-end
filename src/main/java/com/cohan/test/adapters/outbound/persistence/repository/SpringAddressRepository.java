package com.cohan.test.adapters.outbound.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cohan.test.adapters.outbound.persistence.jpa.AddressEntity;

public interface SpringAddressRepository extends JpaRepository<AddressEntity, UUID> { }