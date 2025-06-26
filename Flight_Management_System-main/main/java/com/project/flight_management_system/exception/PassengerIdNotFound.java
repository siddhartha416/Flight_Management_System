package com.project.flight_management_system.exception;

public class PassengerIdNotFound extends RuntimeException {
	private String message="Passenger Not Found In The DB";

	public String getMessage() {
		return message;
	}
}
