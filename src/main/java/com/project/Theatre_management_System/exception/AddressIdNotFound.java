package com.project.Theatre_management_System.exception;

public class AddressIdNotFound extends RuntimeException{
	private String message = "Address Id is not found.";

	public String getMessage() {
		return message;
	}
	
}
