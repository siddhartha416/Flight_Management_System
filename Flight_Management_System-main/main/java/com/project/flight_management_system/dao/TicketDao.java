package com.project.flight_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.flight_management_system.dto.Payment;
import com.project.flight_management_system.dto.Ticket;
import com.project.flight_management_system.repo.TicketRepo;

@Repository
public class TicketDao {

	@Autowired
	TicketRepo ticketRepo;

	@Autowired
	PaymentDao paymentDao;

	@Autowired
	SeatDao seatDao;

	public Ticket saveTicket(Ticket ticket) {
		return ticketRepo.save(ticket);
	}

	public Ticket fetchTicketById(int ticketId) {
		Optional<Ticket> ticket = ticketRepo.findById(ticketId);
		if (ticket.isPresent()) {
			return ticket.get();
		} else {
			return null;
		}
	}

	public Ticket deleteTicketById(int ticketId) {
		Optional<Ticket> ticket = ticketRepo.findById(ticketId);
		if (ticket.isPresent()) {
			ticketRepo.delete(ticket.get());
			return ticket.get();
		} else {
			return null;
		}
	}

	public Ticket updateTicketById(int oldTicketId, Ticket newTicket) {
		Optional<Ticket> ticket = ticketRepo.findById(oldTicketId);
		if (ticket.isPresent()) {
			newTicket.setTicketId(oldTicketId);
			return saveTicket(newTicket);
		} else {
			return null;
		}
	}

	public List<Ticket> fetchAllTicket() {
		return ticketRepo.findAll();
	}

	public Ticket addExistingPaymentToExistingTicket(int ticketId, int paymentId) {
		Ticket ticket = fetchTicketById(ticketId);
		Payment payment = paymentDao.fetchPaymentById(paymentId);
		ticket.setPayment(payment);
		return ticketRepo.save(ticket);
	}

	

}
