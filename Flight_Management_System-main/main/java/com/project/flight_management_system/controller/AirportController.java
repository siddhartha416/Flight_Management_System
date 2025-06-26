package com.project.flight_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.flight_management_system.dto.Airport;
import com.project.flight_management_system.dto.Flight;
import com.project.flight_management_system.service.AirportService;
import com.project.flight_management_system.util.ResponseStructure;
import com.project.flight_management_system.util.ResponseStructureAll;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class AirportController {

	@Autowired
	AirportService airportService;
	
	@Operation(summary = "Save Airport", description = "API is used to save the Airport")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully  Airport created"),
			@ApiResponse(responseCode = "404", description = "Airport not found for the given id") })
	@PostMapping("/saveAirport")
	public ResponseStructure<Airport> saveAirport(@RequestBody Airport airport) {
		return airportService.saveAirport(airport);
	}
	
	@Operation(summary = "Fetch Airport", description = "API is used to Fetch the Airport")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully Airport Fetched"),
			@ApiResponse(responseCode = "404", description = "Airport not found for the given id") })
	@GetMapping("/fetchAirportById")
	public ResponseStructure<Airport> fetchAirportById(@RequestParam int airportId) {
		return airportService.fetchAirportById(airportId);
	}
	
	@Operation(summary = "Delete Airport", description = "API is used to Delete the AirPort")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  Airport Deleted"),
			@ApiResponse(responseCode = "404", description = "Airport not found for the given id") })
	@DeleteMapping("/deleteAirportById")
	public ResponseStructure<Airport> deleteAirportById(@RequestParam int airportId) {
		return airportService.deleteAirportById(airportId);
	}
	
	@Operation(summary = "Update Airport", description = "API is used to Update the Airport")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  Airport Updated"),
			@ApiResponse(responseCode = "404", description = "Airport not found for the given id") })
	@PutMapping("/updateAirportById")
	public ResponseStructure<Airport> updateAirportById(@RequestParam int oldAirportId,@RequestBody Airport newAirport) {
		return airportService.updateAirportById(oldAirportId, newAirport);
	}
	
	@Operation(summary = "Fetch All AirPort's", description = "API is used to Fetch All the Airport's")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully All the Airports's Fetched"),
			@ApiResponse(responseCode = "404", description = "No Airport found") })
	@GetMapping("/fetchAllAirport")
	public ResponseStructureAll<Airport> fetchAllAirport() {
		return airportService.fetchAllAirport();
	}
	
	@Operation(summary = "Add Existing Address To Existing Airport", description = "API is used to Add Existing Address To Existing Airport")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Existing Address Added To Existing Airport"),
			@ApiResponse(responseCode = "404", description = "Airport/Address not found for the given id") })
	@PutMapping("/addExistingAddressToExistingAirport")
	public ResponseStructure<Airport> addExistingAddressToExistingAirport(@RequestParam int airportId,@RequestParam int addressId) {
		return airportService.addExistingAddressToExistingAirport(airportId, addressId);
	}
	
	@Operation(summary = "Add Existing Flight To Existing Airport", description = "API is used to Add Existing Flight To Existing Airport")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Existing Flight Added To Existing Airport"),
			@ApiResponse(responseCode = "404", description = "Airport/Flight not found for the given id") })
	@PutMapping("/addExistingFlightToExistingAirport")
	public ResponseStructure<Airport> addExistingFlightToExistingAirport(@RequestParam int flightId,@RequestParam int airportId) {
		return airportService.addExistingFlightToExistingAirport(flightId, airportId);
	}
	
	@Operation(summary = "Add New Flight To Existing Airport", description = "API is used to Add New Flight To Existing Airport")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully New Flight Added To Existing Airport"),
			@ApiResponse(responseCode = "404", description = "Airport not found for the given id") })
	@PutMapping("/addNewFlightToExistingAirport")
	public ResponseStructure<Airport> addNewFlightToExistingAirport(@RequestParam int airportId,@RequestBody Flight newFlight) {
		return airportService.addNewFlightToExistingAirport(airportId, newFlight);
	}
	
}
