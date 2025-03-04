package com.project.Theatre_management_System.exception;

public class ViewerIdNotFound extends RuntimeException{

	private String message = "Viewer Id Not Found!";

	public String getMessage() {
		return message;
	}
	
}
