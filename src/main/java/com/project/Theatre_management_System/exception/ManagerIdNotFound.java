package com.project.Theatre_management_System.exception;

public class ManagerIdNotFound extends RuntimeException{

	private String message = "Manager Id Not Found!";

	public String getMessage() {
		return message;
	}
	
}
