package com.mindgate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.dto.EmployeeDto;
import com.mindgate.model.EmployeeDetails;
import com.mindgate.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	
	@PostMapping(value="/saveEmployeeDetails")
	public String saveEmployeeDetails(@RequestBody EmployeeDto employeeDto) {
		System.out.println("Hello");
		return employeeService.saveEmployeeDetails(employeeDto);
		
	}
	
	@PutMapping("/updateEmployeeDetails")
	public EmployeeDetails updateEmployeeDetails(@RequestBody EmployeeDto employeeDto) {
		
		return employeeService.updateEmployeeDetails(employeeDto);
	}
	
	@GetMapping(value="/getEmployeeDetails")
	public EmployeeDetails getEmployeeDetails(@RequestParam("employeeId") Long employeeId) {
		
		return employeeService.getEmployeeDetails(employeeId);
		
	}
	
	@DeleteMapping(value="/deleteEmployeeDetails/{employeeId}")
	public String deleteEmployeeDetails(@PathVariable("employeeId") Long employeeId) {
		
		return employeeService.deleteEmployeeDetails(employeeId);
		
	}
	
	

}
