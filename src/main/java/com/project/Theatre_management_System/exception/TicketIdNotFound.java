package com.project.Theatre_management_System.exception;

public class TicketIdNotFound extends RuntimeException{

	private String message = "Ticket Id Not Found!";

	public String getMessage() {
		return message;
	}
	
}
