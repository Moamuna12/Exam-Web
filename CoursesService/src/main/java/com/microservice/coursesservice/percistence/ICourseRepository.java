package com.microservice.coursesservice.percistence;

import com.microservice.coursesservice.entities.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourseRepository extends CrudRepository <Course, Long>{

}
