package com.infy.service;

import java.util.List;

import com.infy.dto.LoginDTO;
import com.infy.dto.StudentValidation;
import com.infy.exception.StudentException;

public interface StudentService {

	public StudentValidation findBy(String Name) throws StudentException;
	public List<StudentValidation> getStudentDetails(Integer age,int PageNumber) throws StudentException;
	
//	public List<StudentValidation> getStudentDetails(Integer age) throws StudentException;
	public String findByAdmin(Long Admin , String pass) throws StudentException;
	
	public String createAdmin(LoginDTO login)throws StudentException;


}