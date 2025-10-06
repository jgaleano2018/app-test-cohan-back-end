package com.cohan.test.adapters.inbound.rest;

import org.springframework.web.bind.annotation.*;

import com.cohan.test.domain.model.UserRol;
import com.cohan.test.domain.port.in.UserRolUseCases;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/userRol")
@CrossOrigin(origins = "http://localhost:4200")
public class UserRolController {

    private final UserRolUseCases userRolService;

    public UserRolController(UserRolUseCases userRolService){
        this.userRolService = userRolService;
    }

    @PostMapping
    public UserRol create(@RequestBody UserRol userRol){
        return userRolService.create(userRol);
    }

    @GetMapping("/{id}")
    public UserRol get(@PathVariable UUID id){
        return userRolService.getById(id);
    }

    @GetMapping
    public List<UserRol> list(){
        return userRolService.getAll();
    }

    @PutMapping("/{id}")
    public UserRol update(@PathVariable UUID id, @RequestBody UserRol userRol){
        return userRolService.update(id, userRol);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        userRolService.delete(id);
    }
}