package com.cohan.test.adapters.outbound.persistence.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cohan.test.adapters.outbound.persistence.jpa.AddressEntity;

public interface SpringAddressRepository extends JpaRepository<AddressEntity, UUID> { 
	
	Optional<AddressEntity> findByStreetAndCityAndStateAndPostalCodeAndCountry(
	        Integer street, String city, String state, String postalCode, String country);
}