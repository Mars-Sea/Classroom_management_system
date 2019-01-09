package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement  //MediaType 转为 XML
@Table
public class Classes {
	
	
	@Id
	private Long class_no;
	private String className;
	private String classSize;

	
	
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
	

}
