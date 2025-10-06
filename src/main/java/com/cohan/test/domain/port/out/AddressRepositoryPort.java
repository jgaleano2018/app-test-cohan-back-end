package com.cohan.test.domain.port.out;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.cohan.test.domain.model.Address;

public interface AddressRepositoryPort {
    Address save(Address c);
    Optional<Address> findById(UUID id);
    List<Address> findAll();
    void delete(UUID id);
}