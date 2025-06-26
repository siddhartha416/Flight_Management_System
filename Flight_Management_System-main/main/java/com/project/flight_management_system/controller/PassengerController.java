package com.project.flight_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.flight_management_system.dto.Food;
import com.project.flight_management_system.dto.Passenger;
import com.project.flight_management_system.dto.Ticket;
import com.project.flight_management_system.service.PassengerService;
import com.project.flight_management_system.util.ResponseStructure;
import com.project.flight_management_system.util.ResponseStructureAll;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class PassengerController {

	@Autowired
	PassengerService passengerService;
	
	@Operation(summary = "Save Passenger", description = "API is used to save the Passenger")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully Passenger created"),
			@ApiResponse(responseCode = "404", description = "Passenger not found for the given id") })
	@PostMapping("/savePassenger")
	public ResponseStructure<Passenger> savePassenger(@RequestBody Passenger passenger) {
		return passengerService.savePassenger(passenger);
	}
	
	@Operation(summary = "Fetch Passenger", description = "API is used to Fetch the Passenger")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully Passenger Fetched"),
			@ApiResponse(responseCode = "404", description = "Passenger not found for the given id") })
	@GetMapping("/fetchPassengerById")
	public ResponseStructure<Passenger> fetchPassengerById(@RequestParam int passengerId) {
		return passengerService.fetchPassengerById(passengerId);
	}
	
	@Operation(summary = "Delete Passenger", description = "API is used to Delete the Passenger")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Passenger Deleted"),
			@ApiResponse(responseCode = "404", description = "Passenger not found for the given id") })
	@DeleteMapping("/deletePassengerById")
	public ResponseStructure<Passenger> deletePassengerById(@RequestParam int passengerId) {
		return passengerService.deletePassengerById(passengerId);
	}
	
	@Operation(summary = "Update Passenger", description = "API is used to Update the Passenger")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Passenger Updated"),
			@ApiResponse(responseCode = "404", description = "Passenger not found for the given id") })
	@PutMapping("/updatePassengerById")
	public ResponseStructure<Passenger> updatePassengerById(@RequestParam int oldPassengerId,@RequestBody Passenger newPassenger) {
		return passengerService.updatePassengerById(oldPassengerId, newPassenger);
	}
	
	@Operation(summary = "Fetch All Passenger's", description = "API is used to Fetch All the Passenger's")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully All the Passenger's Fetched"),
			@ApiResponse(responseCode = "404", description = "No Passenger found") })
	@GetMapping("/fetchAllPassenger")
	public ResponseStructureAll<Passenger> fetchAllPassenger() {
		return passengerService.fetchAllPassenger();
	}
	
	@Operation(summary = "Add Existing Passport To Existing Passenger", description = "API is used to Add Existing Passport To Existing Passenger")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Existing Passport Added To Existing Passenger"),
			@ApiResponse(responseCode = "404", description = "Passenger/Passport not found for the given id") })
	@PutMapping("/addExistingPassportToExistingPassenger")
	public ResponseStructure<Passenger> addExistingPassportToExistingPassenger(@RequestParam int passengerId,@RequestParam int passportId) {
		return passengerService.addExistingPassportToExistingPassenger(passengerId, passportId);
	}

	@Operation(summary = "Add Existing Seat To Existing Passenger", description = "API is used to Add Seat Passport To Existing Passenger")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Existing Seat Added To Existing Passenger"),
			@ApiResponse(responseCode = "404", description = "Passenger/Seat not found for the given id") })
	@PutMapping("/addExistingSeatToExistingPassenger")
	public ResponseStructure<Passenger> addExistingSeatToExistingPassenger(@RequestParam int seatId,@RequestParam int passengerId) {
		return passengerService.addExistingSeatToExistingPassenger(seatId, passengerId);
	}

	@Operation(summary = "Add Existing Address To Existing Passenger", description = "API is used to Add Existing Address To Existing Passenger")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Existing Address Added To Existing Passenger"),
			@ApiResponse(responseCode = "404", description = "Passenger/Address not found for the given id") })
	@PutMapping("/addExistingAddressToExistingPassenger")
	public ResponseStructure<Passenger> addExistingAddressToExistingPassenger(@RequestParam int addressId,@RequestParam int passengerId) {
		return passengerService.addExistingAddressToExistingPassenger(addressId, passengerId);
	}
	
	@Operation(summary = "Add Existing Food To Existing Passenger", description = "API is used to Add Existing Food To Existing Passenger")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Existing Food Added To Existing Passenger"),
			@ApiResponse(responseCode = "404", description = "Passenger/Food not found for the given id") })
	@PutMapping("/addExistingFoodToExistingPassenger")
	public ResponseStructure<Passenger> addExistingFoodToExistingPassenger(@RequestParam int foodId,@RequestParam int passengerId) {
		return passengerService.addExistingFoodToExistingPassenger(foodId, passengerId);
	}
	
	@Operation(summary = "Add New Food To Existing Passenger", description = "API is used to Add New Food To Existing Passenger")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully New Food Added To Existing Passenger"),
			@ApiResponse(responseCode = "404", description = "Passenger not found for the given id") })
	@PutMapping("/addNewFoodToExistingPassenger")
	public ResponseStructure<Passenger> addNewFoodToExistingPassenger(@RequestParam int passengerId,@RequestBody Food newFood) {
		return passengerService.addNewFoodToExistingPassenger(passengerId, newFood);
	}
	
	@Operation(summary = "Add Existing Ticket To Existing Passenger", description = "API is used to Add Existing Ticket To Existing Passenger")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Existing Ticket Added To Existing Passenger"),
			@ApiResponse(responseCode = "404", description = "Passenger/Ticket not found for the given id") })
	@PutMapping("/addExistingTicketToExistingPassenger")
	public ResponseStructure<Passenger> addExistingTicketToExistingPassenger(@RequestParam int passengerId,@RequestParam int ticketId) {
		return passengerService.addExistingTicketToExistingPassenger(passengerId, ticketId);
	}
	
	@Operation(summary = "Add New Ticket To Existing Passenger", description = "API is used to Add New Ticket To Existing Passenger")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully New Ticket Added To Existing Passenger"),
			@ApiResponse(responseCode = "404", description = "Passenger not found for the given id") })
	@PutMapping("/addNewTicketToExistingPassenger")
	public ResponseStructure<Passenger> addNewTicketToExistingPassenger(@RequestParam int passengerId,@RequestBody Ticket newTicket) {
		return passengerService.addNewTicketToExistingPassenger(passengerId, newTicket);
	}
	
	
	
}
