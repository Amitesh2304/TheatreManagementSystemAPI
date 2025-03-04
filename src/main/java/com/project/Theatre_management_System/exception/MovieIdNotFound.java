package com.project.Theatre_management_System.exception;

public class MovieIdNotFound extends RuntimeException{

	private String message = "Movie Id Not Found!";

	public String getMessage() {
		return message;
	}
	
}
