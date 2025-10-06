package com.cohan.test.domain.port.in;

import java.util.List;
import java.util.UUID;

import com.cohan.test.domain.model.Address;

public interface AddressUseCases {
	Address create(Address address);
	Address update(UUID id, Address address);
	Address getById(UUID id);
    List<Address> getAll();
    void delete(UUID id);
}