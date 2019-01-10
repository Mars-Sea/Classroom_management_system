package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.domain.Attendance;


public interface AttendanceRepository extends JpaRepository <Attendance,Long> {
	
//	@Query(nativeQuery = true,value="select sno,sname,class_name,absent,late,sleave,point,general_comment from attendance where class_name=:classname and course_name=:coursename"
//			)
//	List<Attendance> findByClassnameAndCoursename(
//			@Param("classname") String classname,
//			@Param("coursename") String coursename);
	List<Attendance> findByClassNameAndCourseName(String className,String courseName);
	
}
