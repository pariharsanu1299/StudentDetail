package com.infy;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.infy.dto.LoginDTO;
import com.infy.service.StudentService;

@SpringBootApplication
public class StudentApplication{
	
	@Autowired
	private StudentService studentService;

	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
		
		
		
	}

//	@Override
//	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//		createAccount();
//		
//	}
//	public void createAccount() {
//		try {
//		Long email=null;
//		String pass="";
//		LoginDTO login=new LoginDTO();
//		login.setAdminId(email);
//		login.setPassword(pass);
//		
//		String message=studentService.createAdmin(login);
//		System.err.println(message);
//		}catch(Exception e)
//		{
//			System.out.println(e.getMessage());
//		}
//		
//		
	}


