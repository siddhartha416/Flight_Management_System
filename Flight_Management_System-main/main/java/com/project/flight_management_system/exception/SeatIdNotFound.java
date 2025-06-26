package com.project.flight_management_system.exception;

public class SeatIdNotFound extends RuntimeException{
	private String message="Seat Not Found In The DB";

	public String getMessage() {
		return message;
	}
}
