package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.Attendance;


public interface AttendanceRepository extends JpaRepository<Attendance,Long> {

}
