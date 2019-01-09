package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {

}
