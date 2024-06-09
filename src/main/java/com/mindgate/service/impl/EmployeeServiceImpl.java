package com.mindgate.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.dto.EmployeeDto;
import com.mindgate.exception.BadRequestException;
import com.mindgate.exception.DataValidationException;
import com.mindgate.model.EmployeeDetails;
import com.mindgate.repository.EmployeeRepository;
import com.mindgate.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepo;

	@Override
	public String saveEmployeeDetails(EmployeeDto employeeDto) {
		
		vaildateSaveEmployeeDetails(employeeDto);
		
		EmployeeDetails employeeDetail = new EmployeeDetails();
		
		employeeDetail.setEmail(employeeDto.getEmail());
		employeeDetail.setName(employeeDto.getName());
		employeeDetail.setPhoneNumber(employeeDto.getPhoneNumber());
		
		
		employeeRepo.save(employeeDetail); // insert into employee_details (id,email,name,phone_number) values(?,?,?,?) 
		
		return "Employee Record Saved Successfully";
		
		
	}

	@Override
	public EmployeeDetails updateEmployeeDetails(EmployeeDto employeeDto) {
		
		Optional<EmployeeDetails> employeeDetail = employeeRepo.findById(employeeDto.getId()); //select * from employee_details where id=:id
		
		if(employeeDetail.isPresent()) {
			
			EmployeeDetails employee = employeeDetail.get();
			
			employee.setEmail(employeeDto.getEmail());
			employee.setName(employeeDto.getName());
			employee.setPhoneNumber(employee.getPhoneNumber());
			
			EmployeeDetails e1 =employeeRepo.save(employee); // update employee_details set email=:email , name=:name, phone_number = :phonenumber where id = id;
			
			return e1;
			
			
		}else
			throw new BadRequestException("User Not Found "+employeeDto.getId());
			
		
	
		
		
	}

	@Override
	public EmployeeDetails getEmployeeDetails(Long employeeId) {
		
		validateEmployeeId(employeeId);
		
		Optional<EmployeeDetails> employeeDetail = employeeRepo.findById(employeeId); //select * from employee_details where id=:id
		
		if(employeeDetail.isPresent()) 
			return employeeDetail.get();
		else
			throw new BadRequestException("User not Found "+employeeId);
		
	}

	@Override
	public String deleteEmployeeDetails(Long employeeId) {
		
		validateEmployeeId(employeeId);
		
		Optional<EmployeeDetails> employeeDetail = employeeRepo.findById(employeeId); //select * from employee_details where id=:id
		
		if(employeeDetail.isPresent()) {
			
			employeeRepo.deleteById(employeeId); // delete from employee_details where id = :employeeId
			
			return "Deleted Successfully";
			
		}else
			throw new BadRequestException("User Not Found"+employeeId);
			
		
	}
	
	private void vaildateSaveEmployeeDetails(EmployeeDto employeeDto) {
		
		List<String> errorMessage = new ArrayList<String>();
		
		if(employeeDto.getName() == null || employeeDto.getName().isEmpty())
			errorMessage.add("Name Should not be null or Empty");
		
		if(employeeDto.getEmail() == null || employeeDto.getEmail().isEmpty())
			errorMessage.add("Email Should not be null or Empty");
		
		if(employeeDto.getPhoneNumber() == null)
			errorMessage.add("Mobile Number should not be null");
		
		if(String.valueOf(employeeDto.getPhoneNumber()).length() !=10)
			errorMessage.add("Mobile Number must be 10 digit");
		
		if(errorMessage.size() > 0)
			throw new DataValidationException("Failure",errorMessage);
			
	}
	
	private void validateEmployeeId(Long employeeId) {
		
		List<String> errorMessage = new ArrayList<String>();
		
		if(employeeId == null || employeeId == 0) {
			
			
			errorMessage.add("Employee id should not null");
			
		}
		
		if(errorMessage.size() > 0)
			throw new DataValidationException("Failure",errorMessage);
			
	}
	
	/*public static void main(String args[]) {
		
		List<String> l = new ArrayList<String>();
		
		System.out.println(l.size());
		
		l.add("mohan");
		
		System.out.println(l.size());
	}*/

}
