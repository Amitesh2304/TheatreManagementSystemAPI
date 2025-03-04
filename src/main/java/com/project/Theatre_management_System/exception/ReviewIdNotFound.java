package com.project.Theatre_management_System.exception;

public class ReviewIdNotFound extends RuntimeException{

	private String message = "Review Id Not Found!";

	public String getMessage() {
		return message;
	}
	
}
