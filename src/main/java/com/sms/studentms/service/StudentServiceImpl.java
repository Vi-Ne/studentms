package com.sms.studentms.service;

import com.sms.studentms.entity.Student;
import com.sms.studentms.exception.ResourceNotFoundException;
import com.sms.studentms.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repo;

    @Override
    public Student create(Student s) {
        return repo.save(s);
    }

    @Override
    public Student update(Long id, Student s) {
        Student existing = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));
        existing.setFirstName(s.getFirstName());
        existing.setLastName(s.getLastName());
        existing.setEmail(s.getEmail());
        existing.setCourse(s.getCourse());
        existing.setPhone(s.getPhone());
        return repo.save(existing);
    }

    @Override
    public Student getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));
    }

    @Override
    public List<Student> getAll() {
        return repo.findAll();
    }

    @Override
    public void delete(Long id) {
        Student s = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));
        repo.delete(s);
    }
}
