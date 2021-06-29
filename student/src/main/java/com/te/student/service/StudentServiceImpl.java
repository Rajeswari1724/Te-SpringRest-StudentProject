package com.te.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.student.beans.StudentBean;
import com.te.student.dao.StudentDao;



@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao dao;

	@Override
	public StudentBean getStudent(int id) {

		return dao.getStudent(id);
	}

	@Override
	public boolean deleteStuData(int id) {

		return dao.deleteStuData(id);
	}

	@Override
	public List<StudentBean> getAllStu() {

		return dao.getAllStu();
	}

	@Override
	public boolean addStudent(StudentBean bean) {

		return dao.addStudent(bean);
	}

	@Override
	public boolean updateStudent(StudentBean bean) {

		return dao.updateStudent(bean);
	}

}

