package com.project.flight_management_system.exception;

public class PassportIdNotFound extends RuntimeException{
	private String message="Passport Not Found In The DB";

	public String getMessage() {
		return message;
	}
}
