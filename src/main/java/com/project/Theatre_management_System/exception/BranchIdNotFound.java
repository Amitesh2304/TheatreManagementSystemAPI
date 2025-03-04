package com.project.Theatre_management_System.exception;

public class BranchIdNotFound extends RuntimeException{

	private String message = "Branch Id not found in database.";

	public String getMessage() {
		return message;
	}
	
}
