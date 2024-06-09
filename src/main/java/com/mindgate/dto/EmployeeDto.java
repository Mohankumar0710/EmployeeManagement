package com.mindgate.dto;

public class EmployeeDto {
	
	private Long id;
	
	private String name;
	
	private String email;
	
	private Long phoneNumber;

	public String getName() {
		return name;
		
	}
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
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

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "EmployeeDto [name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber + "]";
	}
	
	

}
