package com.project.flight_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.flight_management_system.dto.Address;
import com.project.flight_management_system.dto.Airport;
import com.project.flight_management_system.dto.Flight;
import com.project.flight_management_system.repo.AirportRepo;

@Repository
public class AirportDao {

	@Autowired
	AirportRepo airportRepo;
	
	@Autowired
	AddressDao addressDao;
	
	@Autowired
	FlightDao flightDao;
	
	public Airport saveAirport(Airport airport) {
		return airportRepo.save(airport);
	}
	
	public Airport fetchAirportById(int airportId) {
		Optional<Airport> airport=airportRepo.findById(airportId);
		if(airport.isPresent()) {
			return airport.get();
		}else {
			return null;
		}
	}
	
	public Airport deleteAirportById(int airportId) {
		Optional<Airport> airport=airportRepo.findById(airportId);
		if(airport.isPresent()) {
			airportRepo.delete(airport.get());
			return airport.get();
		}else {
			return null;
		}
	}
	
	public Airport updateAirportById(int oldAirportId,Airport newAirport) {
		Optional<Airport> airport=airportRepo.findById(oldAirportId);
		if(airport.isPresent()) {
			newAirport.setAirportId(oldAirportId);
			return saveAirport(newAirport);
		}else {
			return null;
		}
	}
	
	public List<Airport> fetchAllAirport(){
		return airportRepo.findAll();
	}
	
	public Airport addExistingAddressToExistingAirport(int airportId,int addressId) {
		Airport airport=fetchAirportById(airportId);
		Address address=addressDao.fetchAddressById(addressId);
		airport.setAddress(address);
		return airportRepo.save(airport);
	}
	
	public Airport addExistingFlightToExistingAirport(int flightId,int airportId) {
		Airport airport=fetchAirportById(airportId);
		Flight flight=flightDao.fetchFlightById(flightId);
		List<Flight> list= airport.getFlights();
		list.add(flight);
		airport.setFlights(list);
		return airportRepo.save(airport);
	}
	
	public Airport addNewFlightToExistingAirport(int airportId,Flight newFlight) {
		Airport airport=fetchAirportById(airportId);
		List<Flight> list= airport.getFlights();
		list.add(newFlight);
		airport.setFlights(list);
		return airportRepo.save(airport);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
