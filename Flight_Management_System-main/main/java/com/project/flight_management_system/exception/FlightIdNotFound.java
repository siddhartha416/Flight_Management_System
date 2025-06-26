package com.project.flight_management_system.exception;

public class FlightIdNotFound extends RuntimeException {
	private String message="Flight Not Found In The DB";

	public String getMessage() {
		return message;
	}
}
