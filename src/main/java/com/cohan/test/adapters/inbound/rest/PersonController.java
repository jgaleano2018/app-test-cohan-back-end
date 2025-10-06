package com.cohan.test.adapters.inbound.rest;

import org.springframework.web.bind.annotation.*;

import com.cohan.test.domain.model.Person;
import com.cohan.test.domain.port.in.PersonUseCases;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/persons")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonController {

    private final PersonUseCases personService;

    public PersonController(PersonUseCases personService){
        this.personService = personService;
    }

    @PostMapping
    public Person create(@RequestBody Person person){
        return personService.create(person);
    }

    @GetMapping("/{id}")
    public Person get(@PathVariable UUID id){
        return personService.getById(id);
    }

    @GetMapping
    public List<Person> list(){
        return personService.getAll();
    }

    @PutMapping("/{id}")
    public Person update(@PathVariable UUID id, @RequestBody Person person){
        return personService.update(id, person);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        personService.delete(id);
    }
}