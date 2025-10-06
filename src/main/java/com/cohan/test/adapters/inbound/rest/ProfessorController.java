package com.cohan.test.adapters.inbound.rest;

import org.springframework.web.bind.annotation.*;

import com.cohan.test.domain.model.Professor;
import com.cohan.test.domain.port.in.ProfessorUseCases;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/professors")
@CrossOrigin(origins = "http://localhost:4200")
public class ProfessorController {

    private final ProfessorUseCases professorService;

    public ProfessorController(ProfessorUseCases professorService){
        this.professorService = professorService;
    }

    @PostMapping
    public Professor create(@RequestBody Professor professor){
        return professorService.create(professor);
    }

    @GetMapping("/{id}")
    public Professor get(@PathVariable UUID id){
        return professorService.getById(id);
    }

    @GetMapping
    public List<Professor> list(){
        return professorService.getAll();
    }

    @PutMapping("/{id}")
    public Professor update(@PathVariable UUID id, @RequestBody Professor professor){
        return professorService.update(id, professor);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
    	professorService.delete(id);
    }
}