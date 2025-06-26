package com.project.flight_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.flight_management_system.dao.FlightDao;
import com.project.flight_management_system.dto.Airhostess;
import com.project.flight_management_system.dto.Flight;
import com.project.flight_management_system.dto.Passenger;
import com.project.flight_management_system.dto.Pilot;
import com.project.flight_management_system.dto.Seat;
import com.project.flight_management_system.exception.FlightIdNotFound;
import com.project.flight_management_system.util.ResponseStructure;
import com.project.flight_management_system.util.ResponseStructureAll;

@Service
public class FlightService {

	@Autowired
	FlightDao flightDao;

	@Autowired
	ResponseStructure<Flight> responseStructure;

	@Autowired
	ResponseStructureAll<Flight> responseStructureAll;

	public ResponseStructure<Flight> saveFlight(Flight flight) {
		responseStructure.setMessage("Succesfully Flight Saved In DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(flightDao.saveFlight(flight));
		return responseStructure;
	}

	public ResponseStructure<Flight> fetchFlightById(int flightId) {
		Flight flight = flightDao.fetchFlightById(flightId);
		if (flight != null) {
			responseStructure.setMessage("Succesfully Flight Fetched From DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(flightDao.fetchFlightById(flightId));
			return responseStructure;
		} else {
			throw new FlightIdNotFound();
		}
	}

	public ResponseStructure<Flight> deleteFlightById(int flightId) {
		Flight flight = flightDao.fetchFlightById(flightId);
		if (flight != null) {
			responseStructure.setMessage("Succesfully Flight Deleted From DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(flightDao.deleteFlightById(flightId));
			return responseStructure;
		} else {
			throw new FlightIdNotFound();
		}
	}

	public ResponseStructure<Flight> updateFlightById(int oldFlightId, Flight newFlight) {
		Flight flight = flightDao.fetchFlightById(oldFlightId);
		if (flight != null) {
			responseStructure.setMessage("Succesfully Flight Updated In DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(flightDao.updateFlightById(oldFlightId, newFlight));
			return responseStructure;
		} else {
			throw new FlightIdNotFound();
		}
	}

	public ResponseStructureAll<Flight> fetchAllFlight() {
		responseStructureAll.setMessage("Successfully All Flight Fetched From DB");
		responseStructureAll.setStatusCode(HttpStatus.FOUND.value());
		responseStructureAll.setData(flightDao.fetchAllFlight());
		return responseStructureAll;
	}

	public ResponseStructure<Flight> addExistingPilotToExistingFlight(int flightId, int pilotId) {
		responseStructure.setMessage("Succesfully Existing Pilot Added To Existing Flight");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(flightDao.addExistingPilotToExistingFlight(flightId, pilotId));
		return responseStructure;
	}

	public ResponseStructure<Flight> addNewPilotToExistingFlight(int flightId, Pilot newPilot) {
		responseStructure.setMessage("Succesfully New Pilot Added To Existing Flight");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(flightDao.addNewPilotToExistingFlight(flightId, newPilot));
		return responseStructure;
	}

	public ResponseStructure<Flight> addExistingAirhostessToExistingFlight(int airhostessId, int flightId) {
		responseStructure.setMessage("Succesfully Existing Airhostess Added To Existing Flight");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(flightDao.addExistingAirhostessToExistingFlight(airhostessId, flightId));
		return responseStructure;
	}

	public ResponseStructure<Flight> addNewAirhostessToExistingFlight(int flightId, Airhostess newAirhostess) {
		responseStructure.setMessage("Succesfully New Airhostess Added To Existing Flight");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(flightDao.addNewAirhostessToExistingFlight(flightId, newAirhostess));
		return responseStructure;
	}

	public ResponseStructure<Flight> addExistingPassengerToExistingFlight(int passengerId, int flightId) {
		responseStructure.setMessage("Succesfully Existing Passenger Added To Existing Flight");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(flightDao.addExistingPassengerToExistingFlight(passengerId, flightId));
		return responseStructure;
	}

	public ResponseStructure<Flight> addNewPassengerToExistingFlight(int flightId, Passenger newPassenger) {
		responseStructure.setMessage("Succesfully New Passenger Added To Existing Flight");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(flightDao.addNewPassengerToExistingFlight(flightId, newPassenger));
		return responseStructure;
	}
	
	public ResponseStructure<Flight> addExistingSeatToExistingFlight(int flightId, int seatId) {
		responseStructure.setMessage("Succesfully Existing Seat Added To Existing Flight");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(flightDao.addExistingSeatToExistingFlight(flightId, seatId));
		return responseStructure;
	}

	public ResponseStructure<Flight> addNewSeatToExistingFlight(int flightId, Seat newSeat) {
		responseStructure.setMessage("Succesfully New Seat Added To Existing Flight");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(flightDao.addNewSeatToExistingFlight(flightId, newSeat));
		return responseStructure;
	}
}
