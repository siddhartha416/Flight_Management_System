package com.project.flight_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.flight_management_system.dto.Seat;
import com.project.flight_management_system.repo.SeatRepo;

@Repository
public class SeatDao {

	@Autowired
	SeatRepo seatRepo;
	
	public Seat saveSeat(Seat seat) {
		return seatRepo.save(seat);
	}
	
	public Seat fetchSeatById(int seatId) {
		Optional<Seat> seat=seatRepo.findById(seatId);
		if(seat.isPresent()) {
			return seat.get();
		}else {
			return null;
		}
	}
	
	public Seat deleteSeatById(int seatId) {
		Optional<Seat> seat=seatRepo.findById(seatId);
		if(seat.isPresent()) {
			seatRepo.delete(seat.get());
			return seat.get();
		}else {
			return null;
		}
	}
	
	public Seat updateSeatById(int oldSeatId,Seat newSeat) {
		Optional<Seat> seat=seatRepo.findById(oldSeatId);
		if(seat.isPresent()) {
			newSeat.setSeatId(oldSeatId);
			return saveSeat(newSeat);
		}else {
			return null;
		}
	}
	
	public List<Seat> fetchAllSeat(){
		return seatRepo.findAll();
	}
}
