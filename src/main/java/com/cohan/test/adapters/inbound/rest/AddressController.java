package com.cohan.test.adapters.inbound.rest;

import org.springframework.web.bind.annotation.*;

import com.cohan.test.domain.model.Address;
import com.cohan.test.domain.port.in.AddressUseCases;
import com.cohan.test.domain.model.PersonAddress;
import com.cohan.test.domain.port.in.PersonAddressUseCases;


import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/addresses")
@CrossOrigin(origins = "http://localhost:4200")
public class AddressController {

    private final AddressUseCases addressService;
    private final PersonAddressUseCases personAddressService;

    public AddressController(AddressUseCases addressService, PersonAddressUseCases personAddressService){    	
        this.addressService = addressService;
        this.personAddressService = personAddressService;
    }

    @PostMapping("/{idPerson}")
    public Address create(@PathVariable UUID idPerson, @RequestBody Address address){
    	
    	Address addressModel = addressService.create(address);
    	
    	PersonAddress personAddress = new PersonAddress();
    	personAddress.setIdPerson(idPerson);    	
    	personAddress.setIdAddress(addressModel.getIdAddress());
    	
    	personAddressService.create(personAddress);
    	
        return addressModel;
    }

    @GetMapping("/{id}")
    public Address get(@PathVariable UUID id){
        return addressService.getById(id);
    }

    @GetMapping
    public List<Address> list(){
        return addressService.getAll();
    }

    @PutMapping("/{id}")
    public Address update(@PathVariable UUID id, @RequestBody Address address){
        return addressService.update(id, address);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        addressService.delete(id);
    }
}