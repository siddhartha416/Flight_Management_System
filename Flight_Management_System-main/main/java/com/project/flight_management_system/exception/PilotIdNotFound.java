package com.project.flight_management_system.exception;

public class PilotIdNotFound extends RuntimeException {
	private String message="Pilot Not Found In The DB";

	public String getMessage() {
		return message;
	}
}
