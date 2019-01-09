package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.Classes;

public interface ClassesRepository extends JpaRepository<Classes,Long> {

	
}
