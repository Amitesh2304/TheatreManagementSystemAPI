package com.project.Theatre_management_System.exception;

public class FoodIdNotFound extends RuntimeException{

	private  String message = "Food Id Not Found!";

	public String getMessage() {
		return message;
	}
	
}
