package com.project.Theatre_management_System.exception;

public class PaymentIdNotFound extends RuntimeException{

	private String message = "Payment Id Not Found!";

	public String getMessage() {
		return message;
	}
	
}
