package com.service;

import java.util.List;

import com.dao.StudentDAO;
import com.model.StudentModel;

public class ListService {
	public List<StudentModel> fetchAll() throws Exception {
		StudentDAO studentDAO = new StudentDAO();
        return studentDAO.getAllStudents();
    }
}
