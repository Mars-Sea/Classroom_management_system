package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Attendance;
import com.example.repository.AttendanceRepository;

@RestController
@RequestMapping
public class AttendanceController {
	
	@Autowired
	private AttendanceRepository attendanceRepository;
	
	
	//查询指定班级指定课程的学生信息
	public List<Attendance> getAttendancelist(String classname,String coursename) {
		List<Attendance> att = new ArrayList<Attendance>();
		for (Attendance attendance : attendanceRepository.findAll()) {
			att.add(attendance);
		}
		return att;
	}

}
