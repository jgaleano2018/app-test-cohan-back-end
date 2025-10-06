package com.cohan.test.adapters.outbound.persistence;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.cohan.test.adapters.outbound.persistence.jpa.StudentEntity;
import com.cohan.test.adapters.outbound.persistence.repository.SpringStudentRepository;
import com.cohan.test.domain.model.Student;
import com.cohan.test.domain.port.out.StudentRepositoryPort;

@Component
public class StudentRepositoryAdapter implements StudentRepositoryPort {

    private final SpringStudentRepository springRepo;

    public StudentRepositoryAdapter(SpringStudentRepository springRepo){
        this.springRepo = springRepo;
    }

    private Student toDomain(StudentEntity e) { 
    	return new Student(e.getIdStudent(), e.getIdPerson(), e.getStudent(), e.getAverageMark());
    }
            
    private StudentEntity toEntity(Student c) { 
    	StudentEntity e = new StudentEntity();    	
    	e.setIdStudent(c.getIdStudent());
    	e.setIdPerson(c.getIdPerson());
    	e.setStudent(c.getStudent());    	
    	e.setAverageMark(c.getAverageMark());
		return e;
	}

    @Override
    public Student save(Student student){
    	StudentEntity entity = toEntity(student);
        if (entity.getIdStudent() == null) entity.setIdStudent(student.getIdStudent());
        StudentEntity saved = springRepo.save(entity);
        return toDomain(saved);
    }

    @Override
	public Optional<Student> findById(UUID id) {
		return springRepo.findById(id).map(this::toDomain);
	}
	
	
	@Override
	public List<Student> findAll() {
		return springRepo.findAll().stream().map(this::toDomain).collect(Collectors.toList());
	}
	
	public Optional<StudentEntity> findByIdPerson(UUID idPerson) {
		return springRepo.findByIdPerson(idPerson);
	}
    
    @Override public void delete(UUID id){ springRepo.deleteById(id); }
}
