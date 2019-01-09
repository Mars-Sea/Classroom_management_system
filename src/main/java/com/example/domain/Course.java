package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement  //MediaType 转为 XML
@Table
public class Course {


	@Id
	private Long course_no;
	private String courseName;
	

	
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

	
	
	
}
