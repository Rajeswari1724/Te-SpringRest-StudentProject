package com.te.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.student.beans.StudentBean;
import com.te.student.beans.StudentResponce;
import com.te.student.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService service;

	@GetMapping(path = "/getAll", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public StudentResponce getAll() {
		StudentResponce response = new StudentResponce();
		List<StudentBean> studentBeans = service.getAllStu();
		if (studentBeans != null) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setDescription("Employee details found");
			response.setStudentBeans(studentBeans);
		} else {
			response.setStatusCode(400);
			response.setMsg("failure");
			response.setDescription("Details Not found");
		}
		return response;
	}

	@GetMapping(path = "/getEmp", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public StudentResponce getStudent(int id) {
		StudentBean studentBeans = service.getStudent(id);
		StudentResponce response = new StudentResponce();
		if (studentBeans != null) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setDescription(" Data found for id : " + id);
			response.setBean(studentBeans);
		} else {
			response.setStatusCode(404);
			response.setMsg("failure");
			response.setDescription("Error Data Not found");
		}
		return response;
	}// end of getEmp

	@DeleteMapping(path = "/delete/{stu_id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public StudentResponce deleteStu(@PathVariable(name = "stu_id") int id) {
		StudentResponce response = new StudentResponce();
		if (service.deleteStuData(id)) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setDescription(" Data Deleted for id : " + id);
		} else {
			response.setStatusCode(400);
			response.setMsg("failure");
			response.setDescription(" Data Not for id : " + id);
		}

		return response;
	}//

	@PostMapping(path = "/add", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public StudentResponce addStu(@RequestBody StudentBean bean) {
		StudentResponce response = new StudentResponce();
		if (service.addStudent(bean)) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setDescription("Added Successfully");
		} else {
			response.setStatusCode(400);
			response.setMsg("failure");
			response.setDescription("Something Went Wrong");
		}
		return response;
	}//

	@PutMapping(path = "/update", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public StudentResponce updateStu(@RequestBody StudentBean bean) {
		System.out.println(bean);
		StudentResponce response = new StudentResponce();
		if (service.updateStudent(bean)) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setDescription("Added Successfully");
		} else {
			response.setStatusCode(400);
			response.setMsg("failure");
			response.setDescription("Something Went Wrong");
		}
		return response;
	}

}
