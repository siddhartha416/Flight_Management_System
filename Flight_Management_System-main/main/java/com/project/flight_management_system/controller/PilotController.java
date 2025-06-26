package com.project.flight_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.flight_management_system.dto.Pilot;
import com.project.flight_management_system.service.PilotService;
import com.project.flight_management_system.util.ResponseStructure;
import com.project.flight_management_system.util.ResponseStructureAll;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class PilotController {

	@Autowired
	PilotService pilotService;
	
	@Operation(summary = "Save Pilot", description = "API is used to save the Pilot")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully Pilot created"),
			@ApiResponse(responseCode = "404", description = "Pilot not found for the given id") })
	@PostMapping("/savePilot")
	public ResponseStructure<Pilot> savePilot(@RequestBody Pilot pilot) {
		return pilotService.savePilot(pilot);
	}
	
	@Operation(summary = "Fetch Pilot", description = "API is used to Fetch the Pilot")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully Pilot Fetched"),
			@ApiResponse(responseCode = "404", description = "Pilot not found for the given id") })
	@GetMapping("/fetchPilotById")
	public ResponseStructure<Pilot> fetchPilotById(@RequestParam int pilotId) {
		return pilotService.fetchPilotById(pilotId);
	}
	
	@Operation(summary = "Delete Pilot", description = "API is used to Delete the Pilot")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Pilot Deleted"),
			@ApiResponse(responseCode = "404", description = "Pilot not found for the given id") })
	@DeleteMapping("/deletePilotById")
	public ResponseStructure<Pilot> deletePilotById(@RequestParam int pilotId) {
		return pilotService.deletePilotById(pilotId);
	}
	
	@Operation(summary = "Update Pilot", description = "API is used to Update the Pilot")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Pilot Updated"),
			@ApiResponse(responseCode = "404", description = "Pilot not found for the given id") })
	@PutMapping("/updatePilotById")
	public ResponseStructure<Pilot> updatePilotById(@RequestParam int oldPilotId,@RequestBody Pilot newPilot) {
		return pilotService.updatePilotById(oldPilotId, newPilot);
	}
	
	@Operation(summary = "Fetch All Pilot's", description = "API is used to Fetch All the Pilot's")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully All the Pilot's Fetched"),
			@ApiResponse(responseCode = "404", description = "No Pilot found") })
	@GetMapping("/fetchAllPilot")
	public ResponseStructureAll<Pilot> fetchAllPilot() {
		return pilotService.fetchAllPilot();
	}
}
