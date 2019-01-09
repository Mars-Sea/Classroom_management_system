package com.example.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement  //MediaType 转为 XML
@Table
public class Class {
	
	
	@Id
	private Long class_no;
	private String className;
	private String classSize;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Give_lessons")
	private List<Give_lessons> give_lessons;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Score")
	private List<Score> Score;
	
	
	
	public Long getClass_no() {
		return class_no;
	}
	public void setClass_no(Long class_no) {
		this.class_no = class_no;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getClassSize() {
		return classSize;
	}
	public void setClassSize(String classSize) {
		this.classSize = classSize;
	}
	public List<Score> getScore() {
		return Score;
	}
	public void setScore(List<Score> score) {
		Score = score;
	}
	

}
