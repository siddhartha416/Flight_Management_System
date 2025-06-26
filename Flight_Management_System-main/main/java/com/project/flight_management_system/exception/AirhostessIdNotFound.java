package com.project.flight_management_system.exception;

public class AirhostessIdNotFound  extends RuntimeException{

	private String message="Airhostess Not Found In The DB";

	public String getMessage() {
		return message;
	}
}
