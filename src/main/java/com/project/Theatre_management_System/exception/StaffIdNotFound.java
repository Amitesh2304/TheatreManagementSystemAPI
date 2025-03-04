package com.project.Theatre_management_System.exception;

public class StaffIdNotFound extends RuntimeException{

	private String messate = "Staff Id Not Found!";

	public String getMessate() {
		return messate;
	}
	
}
