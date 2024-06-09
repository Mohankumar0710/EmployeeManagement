package com.mindgate.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee_details")
public class EmployeeDetails {
	

	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	private String name;
	
	private String email;
	
	@Column(name = "phone_number")
	private Long phoneNumber;

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

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "EmployeeDetails [id=" + id + ", name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ "]";
	}
	
	

}
