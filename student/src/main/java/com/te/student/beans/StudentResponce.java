package com.te.student.beans;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;


import lombok.Data;

@Data
@JsonRootName("stu_response")
@JsonPropertyOrder({ "statusCode", "msg" })
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentResponce implements Serializable {

	private int statusCode;

	private String msg;

	private String description;

	@JsonProperty("stu_info")
	private StudentBean bean;
	
	@JsonProperty("stu_details")
	private List<StudentBean>  studentBeans;
}
