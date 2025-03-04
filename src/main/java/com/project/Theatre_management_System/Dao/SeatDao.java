package com.project.Theatre_management_System.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Theatre_management_System.Dto.Seat;
import com.project.Theatre_management_System.Dto.Viewer;
import com.project.Theatre_management_System.Repo.SeatRepo;

@Repository
public class SeatDao {

	@Autowired
	SeatRepo seatRepo;
	
	@Autowired
	ViewerDao viewerDao;
	
	public Seat addExistingSeatToExistingViewer(int viewerId, int seatId) {
		Viewer viewer = viewerDao.fetchViewerById(seatId);
		Seat seat = fetchSeatById(seatId);
		seat.setViewer(viewer);
		return saveSeat(seat);
	}

	
	public Seat saveSeat(Seat seat) {
		return seatRepo.save(seat);	
	}
	
	public Seat fetchSeatById(int seatId) {
		Optional<Seat> dbSeat = seatRepo.findById(seatId);
		if(dbSeat.isPresent()) {
			return dbSeat.get();
		}else {
			return null;
		}
	}
	
	public List<Seat> fetchAllSeat(){
		return seatRepo.findAll();
	}
	
	public Seat updateSeatById(int oldSeatId,Seat newSeat) {
		newSeat.setSeatId(oldSeatId);
		return seatRepo.save(newSeat);
	}
	public Seat deleteSeatById(int seatId) {
		Seat seat = fetchSeatById(seatId);
		return seat;
	}
}
