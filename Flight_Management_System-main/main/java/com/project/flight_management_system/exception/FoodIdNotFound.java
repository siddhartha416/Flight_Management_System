package com.project.flight_management_system.exception;

public class FoodIdNotFound extends RuntimeException {
	private String message="Food Not Found In The DB";

	public String getMessage() {
		return message;
	}
}
