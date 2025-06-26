package com.project.flight_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.flight_management_system.dao.TicketDao;
import com.project.flight_management_system.dto.Ticket;
import com.project.flight_management_system.exception.TicketIdNotFound;
import com.project.flight_management_system.util.ResponseStructure;
import com.project.flight_management_system.util.ResponseStructureAll;

@Service
public class TicketService {

	@Autowired
	TicketDao ticketDao;
	
	@Autowired
	ResponseStructure<Ticket> responseStructure;
	
	@Autowired
	ResponseStructureAll<Ticket> responseStructureAll;
	
	public ResponseStructure<Ticket> saveTicket(Ticket ticket) {
		responseStructure.setMessage("Successfully Ticket Saved In DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(ticketDao.saveTicket(ticket));
		return responseStructure;
	}
	
	public ResponseStructure<Ticket> fetchTicketById(int ticketId) {
		Ticket ticket=ticketDao.fetchTicketById(ticketId);
		if(ticket!=null) {
		responseStructure.setMessage("Successfully Ticket Fetched From DB");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(ticketDao.fetchTicketById(ticketId));
		return responseStructure;
		}else {
			throw new TicketIdNotFound();
		}
	}
	
	public ResponseStructure<Ticket> deleteTicketById(int ticketId) {
		Ticket ticket=ticketDao.fetchTicketById(ticketId);
		if(ticket!=null) {
		responseStructure.setMessage("Successfully Ticket Dleted From DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(ticketDao.deleteTicketById(ticketId));
		return responseStructure;
		}else {
			throw new TicketIdNotFound();
		}
	}
	
	public ResponseStructure<Ticket> updateTicketById(int oldTicketId, Ticket newTicket) {
		Ticket ticket=ticketDao.fetchTicketById(oldTicketId);
		if(ticket!=null) {
		responseStructure.setMessage("Successfully Ticket Updated In DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(ticketDao.updateTicketById(oldTicketId, newTicket));
		return responseStructure;
		}else {
			throw new TicketIdNotFound();
		}
	}
	
	public ResponseStructureAll<Ticket> fetchAllTicket(){
		responseStructureAll.setMessage("Successfully All Ticket Fetched From DB");
		responseStructureAll.setStatusCode(HttpStatus.FOUND.value());
		responseStructureAll.setData(ticketDao.fetchAllTicket());
		return responseStructureAll;
		
	}
	
	public ResponseStructure<Ticket> addExistingPaymentToExistingTicket(int ticketId,int paymentId) {
		responseStructure.setMessage("Successfully Existing Payment Added To Existing Ticket");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(ticketDao.addExistingPaymentToExistingTicket(ticketId, paymentId));
		return responseStructure;
	}
	
	
}
