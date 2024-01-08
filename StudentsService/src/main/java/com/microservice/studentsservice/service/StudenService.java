package com.microservice.studentsservice.service;

import com.microservice.studentsservice.entities.Student;

import java.util.List;

public interface StudenService {

    List<Student> findAll();

    Student findById(Long id);

    void save(Student student);

    List<Student> findByIdCourse(Long idCourse);
}
