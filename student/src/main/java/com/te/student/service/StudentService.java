package com.te.student.service;

import java.util.List;

import com.te.student.beans.StudentBean;

public interface StudentService {

	public StudentBean getStudent(int id);

	public boolean deleteStuData(int id);

	public List<StudentBean> getAllStu();

	public boolean addStudent(StudentBean bean);

	public boolean updateStudent(StudentBean bean);
}
