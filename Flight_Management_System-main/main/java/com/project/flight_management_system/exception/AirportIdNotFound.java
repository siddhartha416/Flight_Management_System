package com.project.flight_management_system.exception;

public class AirportIdNotFound extends RuntimeException{
	private String message="Airport Not Found In The DB";

	public String getMessage() {
		return message;
	}

}
