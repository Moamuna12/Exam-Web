package com.microservice.coursesservice.service;

import com.microservice.coursesservice.entities.Course;
import com.microservice.coursesservice.response.StudentByCourseResponse;

import java.util.List;

public interface CourseService {

    List<Course> findAll();

    Course findById(Long id);

    void save(Course course);

    StudentByCourseResponse findStudentByIdCourse(Long idCourse);
}
