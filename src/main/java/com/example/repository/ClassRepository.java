package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.Class;

public interface ClassRepository extends JpaRepository<Class,Long> {

	
}
