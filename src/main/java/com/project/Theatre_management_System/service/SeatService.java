package com.project.Theatre_management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.Theatre_management_System.Dao.SeatDao;
import com.project.Theatre_management_System.Dao.ViewerDao;
import com.project.Theatre_management_System.Dto.Seat;
import com.project.Theatre_management_System.Dto.Viewer;
import com.project.Theatre_management_System.exception.SeatIdNotFound;
import com.project.Theatre_management_System.exception.ViewerIdNotFound;
import com.project.Theatre_management_System.util.ResponseStructure;
import com.project.Theatre_management_System.util.ResponseStructure1;

@Service
public class SeatService {

	@Autowired
	SeatDao seatDao;

	@Autowired
	ViewerDao viewerDao;

	@Autowired
	ResponseStructure<Seat> responseStructure;

	@Autowired
	ResponseStructure1<Seat> responseStructure1;

	public ResponseEntity<ResponseStructure<Seat>> addExistingSeatToExistingViewer(int viewerId, int seatId) {
		Viewer viewer = viewerDao.fetchViewerById(viewerId);
		if (viewer != null) {
			Seat seat = seatDao.fetchSeatById(seatId);
			if (seat != null) {
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setMessage("Successfully Seat Added into DB.");
				responseStructure.setData(seatDao.addExistingSeatToExistingViewer(viewerId, seatId));
				return new ResponseEntity<ResponseStructure<Seat>>(responseStructure, HttpStatus.OK);
			} else {
				throw new SeatIdNotFound();
			}
		} else {
			throw new ViewerIdNotFound();

		}
	}

	public ResponseEntity<ResponseStructure<Seat>> saveSeat(Seat seat) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Seat Inserted into DB.");
		responseStructure.setData(seatDao.saveSeat(seat));
		return new ResponseEntity<ResponseStructure<Seat>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Seat>> fetchSeatById(int seatId) {
		Seat seat = seatDao.fetchSeatById(seatId);
		if (seat != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully Seat Fetched into DB.");
			responseStructure.setData(seatDao.fetchSeatById(seatId));
			return new ResponseEntity<ResponseStructure<Seat>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new SeatIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure1<Seat>> fetchAllSeat() {
		responseStructure1.setStatusCode(HttpStatus.FOUND.value());
		responseStructure1.setMessage("Successfully fetched all the Seat from DataBase");
		responseStructure1.setData(seatDao.fetchAllSeat());
		return new ResponseEntity<ResponseStructure1<Seat>>(responseStructure1, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Seat>> updateSeatById(int oldSeatId, Seat newSeat) {
		Seat seat = seatDao.fetchSeatById(oldSeatId);
		if (seat != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Seat Updated into DB.");
			responseStructure.setData(seatDao.updateSeatById(oldSeatId, newSeat));
			return new ResponseEntity<ResponseStructure<Seat>>(responseStructure, HttpStatus.OK);
		} else {
			throw new SeatIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Seat>> deleteSeatById(int seatId) {
		Seat seat = seatDao.fetchSeatById(seatId);
		if (seat != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Seat Deleted From DB.");
			responseStructure.setData(seatDao.deleteSeatById(seatId));
			return new ResponseEntity<ResponseStructure<Seat>>(responseStructure, HttpStatus.OK);
		} else {
			throw new SeatIdNotFound();
		}
	}

}
