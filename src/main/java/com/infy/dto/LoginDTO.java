package com.infy.dto;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.Pattern;

@Validated
public class LoginDTO{
    @Pattern(regexp="[0-9]{10}",message="{Admin.required}")
    private long adminId;
    @Pattern(regexp="[A-Za-z]{0-20}@[0-9]{3}",message="{Password.required}")
	private String password;
    
    
	public long getAdminId() {
		return adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
