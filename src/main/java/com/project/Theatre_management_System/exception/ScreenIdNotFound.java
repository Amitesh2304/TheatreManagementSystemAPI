package com.project.Theatre_management_System.exception;

public class ScreenIdNotFound extends RuntimeException{

	private String message = "Screen Id Not Found!";

	public String getMessage() {
		return message;
	}
	
}
