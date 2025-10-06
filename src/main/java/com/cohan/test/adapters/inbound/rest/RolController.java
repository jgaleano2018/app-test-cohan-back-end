package com.cohan.test.adapters.inbound.rest;

import org.springframework.web.bind.annotation.*;

import com.cohan.test.domain.model.Rol;
import com.cohan.test.domain.port.in.RolUseCases;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/roles")
@CrossOrigin(origins = "http://localhost:4200")
public class RolController {

    private final RolUseCases rolService;

    public RolController(RolUseCases rolService){
        this.rolService = rolService;
    }

    @PostMapping
    public Rol create(@RequestBody Rol rol){
        return rolService.create(rol);
    }

    @GetMapping("/{id}")
    public Rol get(@PathVariable UUID id){
        return rolService.getById(id);
    }

    @GetMapping
    public List<Rol> list(){
        return rolService.getAll();
    }

    @PutMapping("/{id}")
    public Rol update(@PathVariable UUID id, @RequestBody Rol rol){
        return rolService.update(id, rol);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
    	rolService.delete(id);
    }
}