package com.project.flight_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.flight_management_system.dto.Airhostess;
import com.project.flight_management_system.dto.Flight;
import com.project.flight_management_system.dto.Passenger;
import com.project.flight_management_system.dto.Pilot;
import com.project.flight_management_system.dto.Seat;
import com.project.flight_management_system.service.FlightService;
import com.project.flight_management_system.util.ResponseStructure;
import com.project.flight_management_system.util.ResponseStructureAll;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class FlightController {

	@Autowired
	FlightService flightService;
	
	@Operation(summary = "Save Flight", description = "API is used to save the Flight")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully Flight created"),
			@ApiResponse(responseCode = "404", description = "Flight not found for the given id") })
	@PostMapping("/saveFlight")
	public ResponseStructure<Flight> saveFlight(@RequestBody Flight flight) {
		return flightService.saveFlight(flight);
	}
	
	@Operation(summary = "Fetch Flight", description = "API is used to Fetch the Flight")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully Flight Fetched"),
			@ApiResponse(responseCode = "404", description = "Flight not found for the given id") })
	@GetMapping("/fetchFlightById")
	public ResponseStructure<Flight> fetchFlightById(@RequestParam int flightId) {
		return flightService.fetchFlightById(flightId);
	}
	
	@Operation(summary = "Delete Flight", description = "API is used to Delete the Flight")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Flight Deleted"),
			@ApiResponse(responseCode = "404", description = "Flight not found for the given id") })
	@DeleteMapping("/deleteFlightById")
	public ResponseStructure<Flight> deleteFlightById(@RequestParam int flightId) {
		return flightService.deleteFlightById(flightId);
	}
	
	@Operation(summary = "Update Flight", description = "API is used to Update the Flight")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Flight Updated"),
			@ApiResponse(responseCode = "404", description = "Flight not found for the given id") })
	@PutMapping("/updateFlightById")
	public ResponseStructure<Flight> updateFlightById(@RequestParam int oldFlightId,@RequestBody Flight newFlight) {
		return flightService.updateFlightById(oldFlightId, newFlight);
	}
	
	@Operation(summary = "Fetch All Flight's", description = "API is used to Fetch All the Flight's")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully All the Flight's Fetched"),
			@ApiResponse(responseCode = "404", description = "No Flight found") })
	@GetMapping("/fetchAllFlight")
	public ResponseStructureAll<Flight> fetchAllFlight() {
		return flightService.fetchAllFlight();
	}
	
	@Operation(summary = "Add Existing Pilot To Existing Flight", description = "API is used to Add Existing Pilot To Existing Flight")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Existing Pilot Added To Existing Flight"),
			@ApiResponse(responseCode = "404", description = "Flight/Pilot not found for the given id") })
	@PutMapping("/addExistingPilotToExistingFlight")
	public ResponseStructure<Flight> addExistingPilotToExistingFlight(@RequestParam int flightId,@RequestParam int pilotId) {
		return flightService.addExistingPilotToExistingFlight(flightId, pilotId);
	}
	
	@Operation(summary = "Add New Pilot To Existing Flight", description = "API is used to Add New Pilot To Existing Flight")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully New Pilot Added To Existing Flight"),
			@ApiResponse(responseCode = "404", description = "Flight not found for the given id") })
	@PutMapping("/addNewPilotToExistingFlight")
	public ResponseStructure<Flight> addNewPilotToExistingFlight(@RequestParam int flightId,@RequestBody Pilot newPilot) {
		return flightService.addNewPilotToExistingFlight(flightId, newPilot);
	}
	
	@Operation(summary = "Add Existing Airhostess To Existing Flight", description = "API is used to Add Existing Airhostess To Existing Flight")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Existing Airhostess Added To Existing Flight"),
			@ApiResponse(responseCode = "404", description = "Flight/Airhostess not found for the given id") })
	@PutMapping("/addExistingAirhostessToExistingFlight")
	public ResponseStructure<Flight> addExistingAirhostessToExistingFlight(@RequestParam int airhostessId,@RequestParam int flightId) {
		return flightService.addExistingAirhostessToExistingFlight(airhostessId, flightId);
	}
	
	@Operation(summary = "Add New Airhostess To Existing Flight", description = "API is used to Add New Airhostess To Existing Flight")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully New Airhostess Added To Existing Flight"),
			@ApiResponse(responseCode = "404", description = "Flight not found for the given id") })
	@PutMapping("/addNewAirhostessToExistingFlight")
	public ResponseStructure<Flight> addNewAirhostessToExistingFlight(@RequestParam int flightId,@RequestBody Airhostess newAirhostess) {
		return flightService.addNewAirhostessToExistingFlight(flightId, newAirhostess);
	}
	
	@Operation(summary = "Add Existing Passenger To Existing Flight", description = "API is used to Add Existing Passenger To Existing Flight")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Existing Passenger Added To Existing Flight"),
			@ApiResponse(responseCode = "404", description = "Flight/Passenger not found for the given id") })
	@PutMapping("/addExistingPassengerToExistingFlight")
	public ResponseStructure<Flight> addExistingPassengerToExistingFlight(@RequestParam int passengerId,@RequestParam int flightId) {
		return flightService.addExistingPassengerToExistingFlight(passengerId, flightId);
	}
	
	@Operation(summary = "Add New Passenger To Existing Flight", description = "API is used to Add New Passenger To Existing Flight")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully New Passenger Added To Existing Flight"),
			@ApiResponse(responseCode = "404", description = "Flight not found for the given id") })
	@PutMapping("/addNewPassengerToExistingFlight")
	public ResponseStructure<Flight> addNewPassengerToExistingFlight(@RequestParam int flightId,@RequestBody Passenger newPassenger) {
		return flightService.addNewPassengerToExistingFlight(flightId, newPassenger);
	}
	
	@Operation(summary = "Add Existing Seat To Existing Flight", description = "API is used to Add Existing Seat To Existing Flight")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Existing Seat Added To Existing Flight"),
			@ApiResponse(responseCode = "404", description = "Flight/Seat not found for the given id") })
	@PutMapping("/addExistingSeatToExistingFlight")
	public ResponseStructure<Flight> addExistingSeatToExistingFlight(@RequestParam int flightId,@RequestParam int seatId) {
		return flightService.addExistingSeatToExistingFlight(flightId, seatId);
	}

	@Operation(summary = "Add New Seat To Existing Flight", description = "API is used to Add New Seat To Existing Flight")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully New Seat Added To Existing Flight"),
			@ApiResponse(responseCode = "404", description = "Flight not found for the given id") })
	@PutMapping("/addNewSeatToExistingFlight")
	public ResponseStructure<Flight> addNewSeatToExistingFlight(@RequestParam int flightId,@RequestBody Seat newSeat) {
		return flightService.addNewSeatToExistingFlight(flightId, newSeat);
	}
}
