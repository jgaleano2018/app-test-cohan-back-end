package com.cohan.test.adapters.inbound.rest;

import org.springframework.web.bind.annotation.*;

import com.cohan.test.domain.model.Student;
import com.cohan.test.domain.port.in.StudentUseCases;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

    private final StudentUseCases studentService;

    public StudentController(StudentUseCases studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public Student create(@RequestBody Student student){
        return studentService.create(student);
    }

    @GetMapping("/{id}")
    public Student get(@PathVariable UUID id){
        return studentService.getById(id);
    }

    @GetMapping
    public List<Student> list(){
        return studentService.getAll();
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable UUID id, @RequestBody Student student){
        return studentService.update(id, student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
    	studentService.delete(id);
    }
}