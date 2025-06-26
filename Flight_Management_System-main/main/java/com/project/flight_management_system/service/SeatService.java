package com.project.flight_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.flight_management_system.dao.SeatDao;
import com.project.flight_management_system.dto.Seat;
import com.project.flight_management_system.exception.SeatIdNotFound;
import com.project.flight_management_system.util.ResponseStructure;
import com.project.flight_management_system.util.ResponseStructureAll;

@Service
public class SeatService {

	@Autowired
	SeatDao seatDao;

	@Autowired
	ResponseStructure<Seat> responseStructure;
	
	@Autowired
	ResponseStructureAll<Seat> responseStructureAll;

	public ResponseStructure<Seat> saveSeat(Seat seat) {
		responseStructure.setMessage("Successfully Seat Saved In DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(seatDao.saveSeat(seat));
		return responseStructure;
	}

	public ResponseStructure<Seat> fetchSeatById(int seatId) {
		Seat seat=seatDao.fetchSeatById(seatId);
		if(seat!=null) {
		responseStructure.setMessage("Successfully Seat Fetched From DB");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(seatDao.fetchSeatById(seatId));
		return responseStructure;
		}else {
			throw new SeatIdNotFound();
		}
	}

	public ResponseStructure<Seat> deleteSeatById(int seatId) {
		Seat seat=seatDao.fetchSeatById(seatId);
		if(seat!=null) {
		responseStructure.setMessage("Successfully Seat Deleted From DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(seatDao.deleteSeatById(seatId));
		return responseStructure;
		}else {
			throw new SeatIdNotFound();
		}
	}

	public ResponseStructure<Seat> updateSeatById(int oldSeatId, Seat newSeat) {
		Seat seat=seatDao.fetchSeatById(oldSeatId);
		if(seat!=null) {
		responseStructure.setMessage("Successfully Seat Updated In DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(seatDao.updateSeatById(oldSeatId, newSeat));
		return responseStructure;
		}else {
			throw new SeatIdNotFound();
		}
	}

	public ResponseStructureAll<Seat> fetchAllSeat() {
		responseStructureAll.setMessage("Successfully All Seat Fetched From DB");
		responseStructureAll.setStatusCode(HttpStatus.FOUND.value());
		responseStructureAll.setData(seatDao.fetchAllSeat());
		return responseStructureAll;
	}
}
