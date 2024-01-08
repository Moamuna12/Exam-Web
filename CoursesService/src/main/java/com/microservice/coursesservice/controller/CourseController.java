package com.microservice.coursesservice.controller;

import com.microservice.coursesservice.entities.Course;
import com.microservice.coursesservice.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCourse(@RequestBody Course course) {
        courseService.save(course);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllCourse(){
        return ResponseEntity.ok(courseService.findAll());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(courseService.findById(id));
    }

    @GetMapping("/search-students/{idCourse}")
    public ResponseEntity<?> findStudentByIdCourse(@PathVariable Long idCourse){
        return ResponseEntity.ok(courseService.findStudentByIdCourse(idCourse));
    }
}
