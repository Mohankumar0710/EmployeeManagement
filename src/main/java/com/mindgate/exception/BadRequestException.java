package com.mindgate.exception;

public class BadRequestException extends DataValidationException{
	
	
	public BadRequestException() {
		
	}
	
	public BadRequestException(String message) {
		super(message);
	}

}
