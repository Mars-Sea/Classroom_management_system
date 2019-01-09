package com.example.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement  //MediaType 转为 XML
@Table
public class Course {


	@Id
	private Long course_no;
	private String courseName;
	
	 @ManyToMany(cascade = CascadeType.ALL, mappedBy = "courses")
	 private List<Teacher> teachers;
	 
	 @ManyToMany(cascade = CascadeType.ALL, mappedBy = "courses")
	 private List<Student> students;
	
	public Long getCourse_no() {
		return course_no;
	}
	public void setCourse_no(Long course_no) {
		this.course_no = course_no;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public List<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
	
}
