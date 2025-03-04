package com.project.Theatre_management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.Theatre_management_System.Dao.MovieDao;
import com.project.Theatre_management_System.Dao.ScreenDao;
import com.project.Theatre_management_System.Dao.SeatDao;
import com.project.Theatre_management_System.Dto.Movie;
import com.project.Theatre_management_System.Dto.Screen;
import com.project.Theatre_management_System.Dto.Seat;
import com.project.Theatre_management_System.exception.MovieIdNotFound;
import com.project.Theatre_management_System.exception.ScreenIdNotFound;
import com.project.Theatre_management_System.exception.SeatIdNotFound;
import com.project.Theatre_management_System.util.ResponseStructure;
import com.project.Theatre_management_System.util.ResponseStructure1;

@Service
public class ScreenService {

	@Autowired
	ScreenDao screenDao;

	@Autowired
	MovieDao movieDao;

	@Autowired
	SeatDao seatDao;

	@Autowired
	ResponseStructure<Screen> responseStructure;

	@Autowired
	ResponseStructure1<Screen> responseStructure1;

	public ResponseEntity<ResponseStructure<Screen>> addNewSeatToExistingScreen(int screenId, Seat newSeat) {
		Screen screen = screenDao.fetchScreenById(screenId);
		if (screen != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Screen Added into DB.");
			responseStructure.setData(screenDao.addNewSeatToExistingScreen(screenId, newSeat));
			return new ResponseEntity<ResponseStructure<Screen>>(responseStructure, HttpStatus.OK);
		} else {
			throw new ScreenIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Screen>> addExistingSeatToExistingScreen(int seatId, int screenId) {
		Seat seat = seatDao.fetchSeatById(seatId);
		if (seat != null) {
			Screen screen = screenDao.fetchScreenById(screenId);
			if (screen != null) {
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setMessage("Successfully Screen Added into DB.");
				responseStructure.setData(screenDao.addExistingSeatToExistingScreen(seatId, screenId));
				return new ResponseEntity<ResponseStructure<Screen>>(responseStructure, HttpStatus.OK);
			} else {
				throw new ScreenIdNotFound();
			}
		} else {
			throw new SeatIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Screen>> saveScreen(Screen screen) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Screen Inserted into DB.");
		responseStructure.setData(screenDao.saveScreen(screen));
		return new ResponseEntity<ResponseStructure<Screen>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Screen>> addExistingScreenToExistingMovie(int screenId, int movieId) {
		Screen screen = screenDao.fetchScreenById(screenId);
		if (screen != null) {
			Movie movie = movieDao.fetchMovieById(movieId);
			if (movie != null) {
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setMessage("Successfully Screen Added into DB.");
				responseStructure.setData(screenDao.addExistingScreenToExistingMovie(screenId, movieId));
				return new ResponseEntity<ResponseStructure<Screen>>(responseStructure, HttpStatus.OK);
			} else {
				throw new MovieIdNotFound();
			}
		} else {
			throw new ScreenIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Screen>> fetchScreenById(int screenId) {
		Screen screen = screenDao.fetchScreenById(screenId);
		if (screen != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully Screen Fetched From DB.");
			responseStructure.setData(screenDao.fetchScreenById(screenId));
			return new ResponseEntity<ResponseStructure<Screen>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new ScreenIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure1<Screen>> fetchAllScreen() {
		responseStructure1.setStatusCode(HttpStatus.FOUND.value());
		responseStructure1.setMessage("Successfully fetched all the Screen from DataBase");
		responseStructure1.setData(screenDao.fetchAllScreen());
		return new ResponseEntity<ResponseStructure1<Screen>>(responseStructure1, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Screen>> updateScreenById(int oldScreenId, Screen newScreen) {
		Screen screen = screenDao.fetchScreenById(oldScreenId);
		if (screen != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Screen Updated into DB.");
			responseStructure.setData(screenDao.updateScreenById(oldScreenId, newScreen));
			return new ResponseEntity<ResponseStructure<Screen>>(responseStructure, HttpStatus.OK);
		} else {
			throw new ScreenIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Screen>> deleteScreenById(int screenId) {
		Screen screen = screenDao.fetchScreenById(screenId);
		if (screen != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Screen Deleted From DB.");
			responseStructure.setData(screenDao.deleteScreenById(screenId));
			return new ResponseEntity<ResponseStructure<Screen>>(responseStructure, HttpStatus.OK);
		} else {
			throw new ScreenIdNotFound();
		}
	}

}
