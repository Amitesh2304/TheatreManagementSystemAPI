package com.project.Theatre_management_System.exception;

public class OwnerIdNotFound extends RuntimeException {

	private String message = "owner id is not found.";

	public String getMessage() {
		return message;
	}

	
}
