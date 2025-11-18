package com.sms.studentms.service;

import com.sms.studentms.entity.Student;

import java.util.List;

public interface StudentService {
    Student create(Student s);
    Student update(Long id, Student s);
    Student getById(Long id);
    List<Student> getAll();
    void delete(Long id);
}
