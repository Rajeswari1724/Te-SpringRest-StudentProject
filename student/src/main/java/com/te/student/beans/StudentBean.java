package com.te.student.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Query;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;


import lombok.Data;

@Data
@Entity
@Table(name = "student1")
@JsonRootName("student-info")
@JsonPropertyOrder({ "id", "name" })
//@XmlRootElement(name = "employee-info")
public class StudentBean implements Serializable {

	@Id
	@Column
	@JsonProperty("stu_id")
	private Integer id;

	@Column
	private String name;

	@Column
	private Double marks;
	
	private String email;
	
	private String grade;

}
