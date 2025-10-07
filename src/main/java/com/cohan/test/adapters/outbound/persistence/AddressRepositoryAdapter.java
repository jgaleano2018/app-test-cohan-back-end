package com.cohan.test.adapters.outbound.persistence;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.cohan.test.adapters.outbound.persistence.jpa.AddressEntity;
import com.cohan.test.adapters.outbound.persistence.repository.SpringAddressRepository;
import com.cohan.test.domain.model.Address;
import com.cohan.test.domain.port.out.AddressRepositoryPort;

@Component
public class AddressRepositoryAdapter implements AddressRepositoryPort {

    private final SpringAddressRepository springRepo;

    public AddressRepositoryAdapter(SpringAddressRepository springRepo){
        this.springRepo = springRepo;
    }

    private Address toDomain(AddressEntity e) { 
    	return new Address(e.getIdAddress(), e.getStreet(), e.getCity(), e.getState(), e.getPostalCode(), e.getCountry());
    }
    
    private AddressEntity toEntity(Address c) { 
    	AddressEntity e = new AddressEntity();    	
    	e.setIdAddress(c.getIdAddress());
    	e.setStreet(c.getStreet());
    	e.setCity(c.getCity());
    	e.setState(c.getState());
    	e.setPostalCode(c.getPostalCode());
    	e.setCountry(c.getCountry());    	
		return e;
	}

    @Override
    public Address save(Address address){
    	AddressEntity entity = toEntity(address);
        if (entity.getIdAddress() == null) entity.setIdAddress(address.getIdAddress());
        AddressEntity saved = springRepo.save(entity);
        return toDomain(saved);
    }

    @Override
	public Optional<Address> findById(UUID id) {
		return springRepo.findById(id).map(this::toDomain);
	}
	
	@Override
	public List<Address> findAll() {
		return springRepo.findAll().stream().map(this::toDomain).collect(Collectors.toList());
	}
	
	@Override
	public Optional<AddressEntity> findByStreetAndCityAndStateAndPostalCodeAndCountry(
			Integer street, String city, String state, String postalCode, String country) {
		return springRepo.findByStreetAndCityAndStateAndPostalCodeAndCountry(street, city, state, postalCode, country);
	}
	
    
    @Override public void delete(UUID id){ springRepo.deleteById(id); }
}
