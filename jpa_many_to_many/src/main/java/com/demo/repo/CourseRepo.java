package com.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course,Integer> {

}
