package com.project.flight_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.flight_management_system.dao.PassengerDao;
import com.project.flight_management_system.dto.Food;
import com.project.flight_management_system.dto.Passenger;
import com.project.flight_management_system.dto.Ticket;
import com.project.flight_management_system.exception.PassengerIdNotFound;
import com.project.flight_management_system.util.ResponseStructure;
import com.project.flight_management_system.util.ResponseStructureAll;

@Service
public class PassengerService {

	@Autowired
	PassengerDao passengerDao;
	
	@Autowired
	ResponseStructure<Passenger> responseStructure;
	
	@Autowired
	ResponseStructureAll<Passenger> responseStructureAll;

	public ResponseStructure<Passenger> savePassenger(Passenger passenger) {
		responseStructure.setMessage("Successfully Passeneger Saved In DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(passengerDao.savePassenger(passenger));
		return responseStructure;
	}

	public ResponseStructure<Passenger> fetchPassengerById(int passengerId) {
		Passenger passenger=passengerDao.fetchPassengerById(passengerId);
		if(passenger!=null) {
		responseStructure.setMessage("Successfully Passeneger Fetched From DB");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(passengerDao.fetchPassengerById(passengerId));
		return responseStructure;
		}else {
			throw new PassengerIdNotFound();
		}
	}

	public ResponseStructure<Passenger> deletePassengerById(int passengerId) {
		Passenger passenger=passengerDao.fetchPassengerById(passengerId);
		if(passenger!=null) {
		responseStructure.setMessage("Successfully Passeneger Deleted From DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(passengerDao.deletePassengerById(passengerId));
		return responseStructure;
		}else {
			throw new PassengerIdNotFound();
		}
	}

	public ResponseStructure<Passenger> updatePassengerById(int oldPassengerId, Passenger newPassenger) {
		Passenger passenger=passengerDao.fetchPassengerById(oldPassengerId);
		if(passenger!=null) {
		responseStructure.setMessage("Successfully Passeneger Updated In DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(passengerDao.updatePassengerById(oldPassengerId, newPassenger));
		return responseStructure;
		}else {
			throw new PassengerIdNotFound();
		}
	}

	public ResponseStructureAll<Passenger> fetchAllPassenger() {
		responseStructureAll.setMessage("Successfully All Passengers Fetched From DB");
		responseStructureAll.setStatusCode(HttpStatus.FOUND.value());
		responseStructureAll.setData(passengerDao.fetchAllPassenger());
		return responseStructureAll;
	}

	public ResponseStructure<Passenger> addExistingPassportToExistingPassenger(int passengerId, int passportId) {
		responseStructure.setMessage("Successfully Existing Passport Added To Existing Passeneger");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(passengerDao.addExistingPassportToExistingPassenger(passengerId, passportId));
		return responseStructure;
	}
	
	public ResponseStructure<Passenger> addExistingSeatToExistingPassenger(int seatId,int passengerId) {
		responseStructure.setMessage("Successfully Existing Seat Added To Existing Passeneger");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData( passengerDao.addExistingSeatToExistingPassenger(seatId, passengerId));
		return responseStructure;
	}
	
	public ResponseStructure<Passenger> addExistingAddressToExistingPassenger(int addressId,int passengerId) {
		responseStructure.setMessage("Successfully Existing Address Added To Existing Passeneger");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(passengerDao.addExistingAddressToExistingPassenger(addressId, passengerId));
		return responseStructure;
	}
	
	public ResponseStructure<Passenger> addExistingFoodToExistingPassenger(int foodId,int passengerId) {
		responseStructure.setMessage("Successfully Existing Food Added To Existing Passeneger");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(passengerDao.addExistingFoodToExistingPassenger(foodId, passengerId));
		return responseStructure;
	}
	
	public ResponseStructure<Passenger> addNewFoodToExistingPassenger(int passengerId, Food newFood) {
		responseStructure.setMessage("Successfully New Food Added To Existing Passeneger");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(passengerDao.addNewFoodToExistingPassenger(passengerId, newFood));
		return responseStructure;
	}

	public ResponseStructure<Passenger> addExistingTicketToExistingPassenger(int passengerId,int ticketId) {
		responseStructure.setMessage("Successfully Existing Ticket Added To Existing Passeneger");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(passengerDao.addExistingTicketToExixtingPassenger(passengerId, ticketId));
		return responseStructure;
	}
	
	public ResponseStructure<Passenger> addNewTicketToExistingPassenger(int passengerId,Ticket newTicket) {
		responseStructure.setMessage("Successfully New Ticket Added To Existing Passeneger");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(passengerDao.addNewTicketToExistingPassenger(passengerId, newTicket));
		return responseStructure;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
