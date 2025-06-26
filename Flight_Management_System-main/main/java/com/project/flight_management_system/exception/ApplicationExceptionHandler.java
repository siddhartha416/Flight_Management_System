package com.project.flight_management_system.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.flight_management_system.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	
	@Autowired
	ResponseStructure<String> responseStructure;

	@ExceptionHandler(AddressIdNotFound.class)
	public ResponseStructure<String> addressIdNotFound(AddressIdNotFound addressIdNotFound) {
		responseStructure.setMessage("AddressId Not Found");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(addressIdNotFound.getMessage());
		return responseStructure;
	}
	
	@ExceptionHandler(AirhostessIdNotFound.class)
	public ResponseStructure<String> airhostessIdNotFound(AirhostessIdNotFound airhostessIdNotFound){
		responseStructure.setMessage("AirhostessId Not Found");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(airhostessIdNotFound.getMessage());
		return responseStructure;
	}
	
	@ExceptionHandler(AirportIdNotFound.class)
	public ResponseStructure<String> airportIdNotFound(AirportIdNotFound airportIdNotFound){
		responseStructure.setMessage("AirportId Not Found");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(airportIdNotFound.getMessage());
		return responseStructure;
	}
	
	@ExceptionHandler(FlightIdNotFound.class)
	public ResponseStructure<String> flightIdNotFound(FlightIdNotFound flightIdNotFound){
		responseStructure.setMessage("FlightId Not Found");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(flightIdNotFound.getMessage());
		return responseStructure;
	}
	
	@ExceptionHandler(FoodIdNotFound.class)
	public ResponseStructure<String> foodIdNotFound(FoodIdNotFound foodIdNotFound){
		responseStructure.setMessage("FoodId Not Found");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(foodIdNotFound.getMessage());
		return responseStructure;
	}
	
	@ExceptionHandler(PassengerIdNotFound.class)
	public ResponseStructure<String> passengerIdNotFound(PassengerIdNotFound passengerIdNotFound){
		responseStructure.setMessage("PassengerId Not Found");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(passengerIdNotFound.getMessage());
		return responseStructure;
	}
	
	@ExceptionHandler(PassportIdNotFound.class)
	public ResponseStructure<String> passportIdNotFound(PassportIdNotFound passportIdNotFound){
		responseStructure.setMessage("PassportId Not Found");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(passportIdNotFound.getMessage());
		return responseStructure;
	}
	
	@ExceptionHandler(PaymentIdNotFound.class)
	public ResponseStructure<String> paymentIdNotFound(PaymentIdNotFound paymentIdNotFound){
		responseStructure.setMessage("PaymentId Not Found");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(paymentIdNotFound.getMessage());
		return responseStructure;
	}
	
	@ExceptionHandler(PilotIdNotFound.class)
	public ResponseStructure<String> pilotIdNotFound(PilotIdNotFound pilotIdNotFound){
		responseStructure.setMessage("PilotId Not Found");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(pilotIdNotFound.getMessage());
		return responseStructure;
	}
	
	@ExceptionHandler(SeatIdNotFound.class)
	public ResponseStructure<String> seatIdNotFound(SeatIdNotFound seatIdNotFound){
		responseStructure.setMessage("SeatId Not Found");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(seatIdNotFound.getMessage());
		return responseStructure;
	}
	
	@ExceptionHandler(TicketIdNotFound.class)
	public ResponseStructure<String> ticketIdNotFound(TicketIdNotFound ticketIdNotFound){
		responseStructure.setMessage("TicketId Not Found");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(ticketIdNotFound.getMessage());
		return responseStructure;
	}
}
