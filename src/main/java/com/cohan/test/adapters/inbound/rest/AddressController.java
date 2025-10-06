package com.cohan.test.adapters.inbound.rest;

import org.springframework.web.bind.annotation.*;

import com.cohan.test.domain.model.Address;
import com.cohan.test.domain.port.in.AddressUseCases;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/address")
@CrossOrigin(origins = "http://localhost:4200")
public class AddressController {

    private final AddressUseCases addressService;

    public AddressController(AddressUseCases addressService){
        this.addressService = addressService;
    }

    @PostMapping
    public Address create(@RequestBody Address address){
        return addressService.create(address);
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