package com.mindgate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindgate.model.EmployeeDetails;

public interface EmployeeRepository extends JpaRepository<EmployeeDetails, Long> {
	
}
