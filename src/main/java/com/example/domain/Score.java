package com.example.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement  //MediaType 转为 XML
@Table
public class Score implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	private int absent;   //旷课
	private int late;    //迟到
	private int sleave;   //请假
	private int point;   //加分
	private int general_comment;   //总分
	private String remark;
	
	
	
	
	public int getAbsent() {
		return absent;
	}
	public void setAbsent(int absent) {
		this.absent = absent;
	}
	public int getLate() {
		return late;
	}
	public void setLate(int late) {
		this.late = late;
	}
	public int getSleave() {
		return sleave;
	}
	public void setSleave(int sleave) {
		this.sleave = sleave;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getGeneral_comment() {
		return general_comment;
	}
	public void setGeneral_comment(int general_comment) {
		this.general_comment = general_comment;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
