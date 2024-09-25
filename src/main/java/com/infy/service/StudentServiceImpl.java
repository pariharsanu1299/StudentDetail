package com.infy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.infy.dto.LoginDTO;
import com.infy.dto.StudentValidation;
import com.infy.entity.Login;
import com.infy.entity.Student;
import com.infy.exception.StudentException;
import com.infy.repository.LoginRepository;
import com.infy.repository.StudentRepository;
//import com.infy.validator.Validator;

import jakarta.transaction.Transactional;

@Service(value="studentService")
@Transactional
public class StudentServiceImpl implements StudentService {

	

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private LoginRepository loginRepository;


@Override
public StudentValidation findBy(String Name) throws StudentException {
	
//	Validator.isValidName(Name);
	

	Student name= studentRepository.findByName(Name);
	if(name==null) {
		throw new StudentException("Student.NotFound");
		
	}
	 
		StudentValidation valid= new StudentValidation();
		valid.setName(name.getName());
		valid.setAge(name.getAge());
		valid.setEmail(name.getEmail());
		valid.setId(name.getId());
		valid.setPhoneNumber(name.getPhoneNumber());
	return valid;
}
@Override
public List<StudentValidation> getStudentDetails(Integer age,int PageNumber) throws StudentException {
//public List<StudentValidation> getStudentDetails(Integer age) throws StudentException {	
	Iterable<Student> stud1=studentRepository.findAll();
	List<StudentValidation> stud2 =new ArrayList<>();
	for(Student e : stud1) {
		StudentValidation stud3= new StudentValidation();
		stud3.setName(e.getName());
		stud3.setAge(e.getAge());
		stud3.setId(e.getId());
		stud3.setEmail(e.getEmail());
		stud3.setPhoneNumber(e.getPhoneNumber());
		
		stud2.add(stud3);
		
	}
Pageable page = PageRequest.of(PageNumber, stud2.size());

	List<Student> Detail=studentRepository.findByAgeGreaterThan(age,page);
	
//	List<Student> Detail=studentRepository.findByAge(age);
	
	List<StudentValidation> studDTO = new ArrayList<>();
	for(Student s : Detail)
	{
		StudentValidation stud = new StudentValidation();
		stud.setId(s.getId());
		stud.setEmail(s.getEmail());
		stud.setName(s.getName());
		stud.setAge(s.getAge());
		stud.setPhoneNumber(s.getPhoneNumber());
		
		studDTO.add(stud);
		
	}
	
return studDTO;
}
@Override
public String findByAdmin(Long Admin, String pass) throws StudentException {
	
	Optional<Login> adminId= loginRepository.findById(Admin);
	Login login=adminId.orElseThrow(()-> new StudentException("Admin.NotFound"));
	if (login.getPassword().equals(pass)) {
		return "Service.ADMIN_ACCESS_SUCCESSFUL";
	}
	

	return "Service.ADMIN_ACCESS_INVALID";
}

@SuppressWarnings("unused")
@Override
public String createAdmin(LoginDTO login) throws StudentException {
	
	
	Login log = new Login();
	log.setAdminId(login.getAdminId());
	log.setPassword(login.getPassword());
	
	 if(log==null) {
		 throw new StudentException("Data not Found");
	 }
	
	loginRepository.save(log);
	
	

	return " "+ log.getAdminId();
}

}