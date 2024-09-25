package com.infy.validator;

import com.infy.dto.StudentValidation;

import com.infy.exception.StudentException;

public class Validator {

	public static void validator(StudentValidation student) throws StudentException {
		if (!isValidPhoneNumber(student.getPhoneNumber())) {
			throw new StudentException("Invalid Phone Number");
		}
		if (!isValidId(student.getId())) {
			throw new StudentException("Invalid Id Number");
		}
		if (!isValidName(student.getName())) {
			throw new StudentException("Invalid Name");
		}
		if (!isValidEmail(student.getEmail())) {
			throw new StudentException("Invalid Email");
		}
		if (!isValidAge(student.getAge())) {
			throw new StudentException("Invalid Age");
		}
		
		
	}

		public static boolean isValidPhoneNumber(Long phoneNumber) throws StudentException {
			String pNumber = phoneNumber.toString();
			if (pNumber.matches("(\\d)(?!\\1+$)\\d{9}")) {
				return true;
			}
			return false;
	}
		
		public static boolean isValidName(String name) throws StudentException {
			String studentName= name.toString();
			if (studentName.matches("^[A-Za-z]+$")) {
				return true;
				
			}
			return false;
	}
		
		
		public static boolean isValidEmail(String email) throws StudentException {
			String studentName= email.toString();
			if (studentName.matches("^[A-Za-z0-9._%+-]+@[a-zA-Z0-9.-]\\.[a-zA-Z]{2,}$")) {
				return true;
			}
			return false;
	}
		
		
		
		public static boolean isValidId(Integer id) throws StudentException {
			String idNo = id.toString();
			if (idNo.matches("[0-9]{4}")) {
				return true;
			}
			return false;

}
		public static boolean isValidAge(Integer age) throws StudentException {
			String ageNo = age.toString();
			if (ageNo.matches("[0-9]{2}")) {
				return true;
			}
			return false;

}
		}
