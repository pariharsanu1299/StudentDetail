package com.infy.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;


import com.infy.entity.Student;
import com.infy.exception.StudentException;

public interface StudentRepository extends CrudRepository<Student, Integer> {
	
	public Student findByName(String name) throws StudentException;
	public List<Student> findByAgeGreaterThan(Integer age , Pageable pageable);
	

	
//	public List<Student> findByAge(Integer age);
}