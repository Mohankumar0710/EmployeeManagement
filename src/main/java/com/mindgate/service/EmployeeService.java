package com.mindgate.service;

import com.mindgate.dto.EmployeeDto;
import com.mindgate.model.EmployeeDetails;

public interface EmployeeService {
	
	public String saveEmployeeDetails(EmployeeDto employeeDto);
	
	public EmployeeDetails updateEmployeeDetails(EmployeeDto employeeDto);
	
	public EmployeeDetails getEmployeeDetails(Long employeeId);
	
	public String deleteEmployeeDetails(Long employeeId);

}
