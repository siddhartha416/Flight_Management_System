package com.project.flight_management_system.exception;

public class PaymentIdNotFound extends RuntimeException{
	private String message="Payment Not Found In The DB";

	public String getMessage() {
		return message;
	}
}
