package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.Score;


public interface ScoreRepository extends JpaRepository<Score,Long> {

}
