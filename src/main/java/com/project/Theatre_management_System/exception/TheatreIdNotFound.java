package com.project.Theatre_management_System.exception;

public class TheatreIdNotFound extends RuntimeException{

	private String message = "Theatre Id Not Found!";

	public String getMessage() {
		return message;
	}
	
}
