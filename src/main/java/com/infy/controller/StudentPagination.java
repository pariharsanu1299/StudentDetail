package com.infy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infy.dto.LoginDTO;
import com.infy.dto.StudentValidation;

import com.infy.exception.StudentException;
import com.infy.service.StudentService;

import jakarta.validation.Valid;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/student")
@Validated
public class StudentPagination {
	@Autowired
	private StudentService studentService;
	@Autowired
	private Environment environment;
	
	@GetMapping("/search/{name}")
	public ResponseEntity<StudentValidation> searchStudent(@PathVariable String name) throws StudentException
	{
		StudentValidation svalid = studentService.findBy(name);
		return new ResponseEntity<>(svalid, HttpStatus.OK);
		
	}
	@GetMapping("/identity/{age}")
public ResponseEntity<List<StudentValidation>> searchAge(@PathVariable Integer age,@RequestParam(value="startingIndex",required=true)int startingIndex ) throws StudentException{
//	public ResponseEntity<List<StudentValidation>> searchAge(@PathVariable Integer age) throws StudentException{		
		List<StudentValidation> sAge = studentService.getStudentDetails(age, startingIndex);
//		List<StudentValidation> sAge = studentService.getStudentDetails(age);
		return new ResponseEntity<>(sAge, HttpStatus.OK);
	}
	@GetMapping("/login/{id}/{password}")
	public ResponseEntity<String> adminAccess(@PathVariable Long id ,@PathVariable String password) throws StudentException
	{
		String valid = studentService.findByAdmin(id, password);
		String message = environment.getProperty(valid);
		return new ResponseEntity<>(message , HttpStatus.OK);	
}
	
	@PostMapping("/log")
	public ResponseEntity<String> adminCreation(@RequestBody LoginDTO log)throws StudentException{
		String createId =studentService.createAdmin(log);
		String message =environment.getProperty("API.ALLOCATION_SUCCESS")
				+ ":" + createId;

		return new ResponseEntity<>(message , HttpStatus.CREATED);
		
	}
	

}
