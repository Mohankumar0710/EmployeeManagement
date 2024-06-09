package com.mindgate.exception;

import java.util.List;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandleGlobalException {
	
	@ExceptionHandler(DataValidationException.class)
	public List<String> handleDataValidationException(DataValidationException d){
		
		return d.getErrorMessage();
		
	}
	
	@ExceptionHandler(BadRequestException.class)
	public String handleBadRequestException(BadRequestException b) {
		
		return b.getMessage();
		
	}
	
	
	

}
