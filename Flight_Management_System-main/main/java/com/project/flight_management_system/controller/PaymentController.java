package com.project.flight_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.flight_management_system.dto.Payment;
import com.project.flight_management_system.service.PaymentService;
import com.project.flight_management_system.util.ResponseStructure;
import com.project.flight_management_system.util.ResponseStructureAll;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class PaymentController {

	@Autowired
	PaymentService paymentService;
	
	@Operation(summary = "Save Payment", description = "API is used to save the Payment")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully Payment created"),
			@ApiResponse(responseCode = "404", description = "Payment not found for the given id") })
	@PostMapping("/savePayment")
	public ResponseStructure<Payment> savePayment(@RequestBody Payment payment) {
		return paymentService.savePayment(payment);
	}
	
	@Operation(summary = "Fetch Payment", description = "API is used to Fetch the Payment")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully Payment Fetched"),
			@ApiResponse(responseCode = "404", description = "Payment not found for the given id") })
	@GetMapping("/fetchPaymentById")
	public ResponseStructure<Payment> fetchPaymentById(@RequestParam int paymentId) {
		return paymentService.fetchPaymentById(paymentId);
	}
	
	@Operation(summary = "Delete Payment", description = "API is used to Delete the Payment")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Payment Deleted"),
			@ApiResponse(responseCode = "404", description = "Payment not found for the given id") })
	@DeleteMapping("/deletePaymentById")
	public ResponseStructure<Payment> deletePaymentById(@RequestParam int paymentId) {
		return paymentService.deletePaymentById(paymentId);
	}
	
	@Operation(summary = "Update Payment", description = "API is used to Update the Payment")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully Payment Updated"),
			@ApiResponse(responseCode = "404", description = "Payment not found for the given id") })
	@PutMapping("/updatePaymentById")
	public ResponseStructure<Payment> updatePaymentById(@RequestParam int oldPaymentId,@RequestBody Payment newPayment) {
		return paymentService.updatePaymentById(oldPaymentId, newPayment);
	}
	
	@Operation(summary = "Fetch All Payment's", description = "API is used to Fetch All the Payment's")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully All the Payment's Fetched"),
			@ApiResponse(responseCode = "404", description = "No Payment found") })
	@GetMapping("/fetchAllPayment")
	public ResponseStructureAll<Payment> fetchAllPayment() {
		return paymentService.fetchAllPayment();
	}
}
