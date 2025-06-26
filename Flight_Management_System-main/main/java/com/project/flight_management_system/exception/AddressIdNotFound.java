package com.project.flight_management_system.exception;

public class AddressIdNotFound extends RuntimeException{

	private String message="Address Not Found In The DB";

	public String getMessage() {
		return message;
	}
	
	
}
