package com.mindgate.exception;

import java.util.ArrayList;
import java.util.List;

public class DataValidationException extends RuntimeException{
	
	private List<String> errorMessage = new ArrayList<>();
	
	
	public List<String> getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(List<String> errorMessage) {
		this.errorMessage = errorMessage;
	}

	public DataValidationException() {
		
	}
	
	public DataValidationException(String message) {
		super(message);
	}
	
	public DataValidationException(String message,List<String> errorMessage) {
		super(message);
		this.errorMessage = errorMessage;
		
	}
	

}
