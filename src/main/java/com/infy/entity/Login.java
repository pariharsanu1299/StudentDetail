package com.infy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "login")
public class Login {

	@Id
	private long adminId;
	private String password;
	
	
	public Login(long adminId,String password) {
		super();
		this.adminId=adminId;
		this.password=password;
		
	}
	
	
	public Login() {
		super();
	}


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
