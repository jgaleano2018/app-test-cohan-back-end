package com.cohan.test.adapters.inbound.rest;

import org.springframework.web.bind.annotation.*;

import com.cohan.test.domain.model.PersonAddress;
import com.cohan.test.domain.port.in.PersonAddressUseCases;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/personAddress")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonAddressController {

    private final PersonAddressUseCases personAddressService;

    public PersonAddressController(PersonAddressUseCases personAddressService){
        this.personAddressService = personAddressService;
    }

    @PostMapping
    public PersonAddress create(@RequestBody PersonAddress personAddress){
        return personAddressService.create(personAddress);
    }

    @GetMapping("/{id}")
    public PersonAddress get(@PathVariable UUID id){
        return personAddressService.getById(id);
    }

    @GetMapping
    public List<PersonAddress> list(){
        return personAddressService.getAll();
    }

    @PutMapping("/{id}")
    public PersonAddress update(@PathVariable UUID id, @RequestBody PersonAddress personAddress){
        return personAddressService.update(id, personAddress);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        personAddressService.delete(id);
    }
}