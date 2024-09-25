package com.infy.dto;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Validated
public class StudentValidation {
    
    @NotBlank(message = "{Name.required}")
    private String name;

    @Email(message = "{Invalid.mail}")
    private String email;
    
    @Pattern(regexp="[6-9](0-9){9}",message="{Phone.required}")
    private Long phoneNumber;
    

    
	private Integer age;
    
    private Integer id;
    
    
    

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	 public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}


		
	

    // getters and setters
}