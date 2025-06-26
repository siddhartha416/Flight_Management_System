package com.project.flight_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.flight_management_system.dao.AirportDao;
import com.project.flight_management_system.dto.Airport;
import com.project.flight_management_system.dto.Flight;
import com.project.flight_management_system.exception.AirportIdNotFound;
import com.project.flight_management_system.util.ResponseStructure;
import com.project.flight_management_system.util.ResponseStructureAll;

@Service
public class AirportService {

	@Autowired
	AirportDao airportDao;

	@Autowired
	ResponseStructure<Airport> responseStructure;

	@Autowired
	ResponseStructureAll<Airport> responseStructureAll;

	public ResponseStructure<Airport> saveAirport(Airport airport) {
		responseStructure.setMessage("Successfully Airport Saved In DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(airportDao.saveAirport(airport));
		return responseStructure;
	}

	public ResponseStructure<Airport> fetchAirportById(int airportId) {
		Airport airport = airportDao.fetchAirportById(airportId);
		if (airport != null) {
			responseStructure.setMessage("Successfully Airport Fetched From DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(airportDao.fetchAirportById(airportId));
			return responseStructure;
		} else {
			throw new AirportIdNotFound();
		}
	}

	public ResponseStructure<Airport> deleteAirportById(int airportId) {
		Airport airport = airportDao.fetchAirportById(airportId);
		if (airport != null) {
			responseStructure.setMessage("Successfully Airport Deleted From DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(airportDao.deleteAirportById(airportId));
			return responseStructure;
		} else {
			throw new AirportIdNotFound();
		}
	}

	public ResponseStructure<Airport> updateAirportById(int oldAirportId, Airport newAirport) {
		Airport airport = airportDao.fetchAirportById(oldAirportId);
		if (airport != null) {
			responseStructure.setMessage("Successfully Airport Updated In DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(airportDao.updateAirportById(oldAirportId, newAirport));
			return responseStructure;
		} else {
			throw new AirportIdNotFound();
		}
	}

	public ResponseStructureAll<Airport> fetchAllAirport() {
		responseStructureAll.setMessage("Successfully All Airport Fetched From DB");
		responseStructureAll.setStatusCode(HttpStatus.FOUND.value());
		responseStructureAll.setData(airportDao.fetchAllAirport());
		return responseStructureAll;
	}

	public ResponseStructure<Airport> addExistingAddressToExistingAirport(int airportId, int addressId) {
		responseStructure.setMessage("Successfully Existing Address Added To Existing Airport");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(airportDao.addExistingAddressToExistingAirport(airportId, addressId));
		return responseStructure;
	}

	public ResponseStructure<Airport> addExistingFlightToExistingAirport(int flightId, int airportId) {
		responseStructure.setMessage("Successfully Existing Flight Added TO Existing Airport ");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(airportDao.addExistingFlightToExistingAirport(flightId, airportId));
		return responseStructure;
	}

	public ResponseStructure<Airport> addNewFlightToExistingAirport(int airportId, Flight newFlight) {
		responseStructure.setMessage("Successfully New Flight Added TO Existing Airport");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(airportDao.addNewFlightToExistingAirport(airportId, newFlight));
		return responseStructure;
	}
}
