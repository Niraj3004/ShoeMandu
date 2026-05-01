package com.service;

import com.dao.StudentDAO;
import com.model.StudentModel;

public class StudentService {

	 public StudentModel getStudentByUsername(String username) throws Exception {
	        StudentDAO dao = new StudentDAO();
	        return dao.getStudentByUsername(username);

	 }

}



