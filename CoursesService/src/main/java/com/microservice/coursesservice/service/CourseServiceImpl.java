package com.microservice.coursesservice.service;

import com.microservice.coursesservice.client.StudentClient;
import com.microservice.coursesservice.controller.dto.StudentDTO;
import com.microservice.coursesservice.entities.Course;
import com.microservice.coursesservice.response.StudentByCourseResponse;
import com.microservice.coursesservice.percistence.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private ICourseRepository iCourseRepository;

    @Autowired
    private StudentClient studentClient;

    @Override
    public List<Course> findAll() {
        return (List<Course>) iCourseRepository.findAll();
    }

    @Override
    public Course findById(Long id) {
        return iCourseRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Course course) {
        iCourseRepository.save(course);
    }

    @Override
    public StudentByCourseResponse findStudentByIdCourse(Long idCourse) {
        // query the course
        Course course = iCourseRepository.findById(idCourse).orElse(new Course());

        // get the students
        List<StudentDTO> studentDTOList = studentClient.findAllStudentByCourse(idCourse);

        return StudentByCourseResponse.builder()
                .courseName(course.getName())
                .teacher(course.getTeacher())
                .studentDTOList(studentDTOList)
                .build();

    }
}
