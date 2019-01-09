package com.example.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.Course;

public interface CourseRepository extends JpaRepository<Course,Long> {

}
