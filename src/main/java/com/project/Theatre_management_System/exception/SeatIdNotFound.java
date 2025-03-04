package com.project.Theatre_management_System.exception;

public class SeatIdNotFound extends RuntimeException{

	private String message = "Seat Id Not Found!";

	public String getMessage() {
		return message;
	}
	
}
