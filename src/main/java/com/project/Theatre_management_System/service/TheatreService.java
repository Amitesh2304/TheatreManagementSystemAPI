package com.project.Theatre_management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.Theatre_management_System.Dao.BranchDao;
import com.project.Theatre_management_System.Dao.TheatreDao;
import com.project.Theatre_management_System.Dto.Branch;
import com.project.Theatre_management_System.Dto.Theatre;
import com.project.Theatre_management_System.exception.BranchIdNotFound;
import com.project.Theatre_management_System.exception.TheatreIdNotFound;
import com.project.Theatre_management_System.util.ResponseStructure;
import com.project.Theatre_management_System.util.ResponseStructure1;

@Service
public class TheatreService {

	@Autowired
	TheatreDao theatreDao;

	@Autowired
	BranchDao branchDao;

	@Autowired
	ResponseStructure<Theatre> responseStructure;

	@Autowired
	ResponseStructure1<Theatre> responseStructure1;

	public ResponseEntity<ResponseStructure<Theatre>> saveTheatre(Theatre theatre) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Theatre Inserted into DB.");
		responseStructure.setData(theatreDao.saveTheatre(theatre));
		return new ResponseEntity<ResponseStructure<Theatre>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Theatre>> addExistingBranchToexistingTheatre(int branchId, int theatreId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			Theatre theatre = theatreDao.fetchTheatreById(theatreId);
			if (theatre != null) {
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setMessage("Successfully Theatre Added into DB.");
				responseStructure.setData(theatreDao.addExistingBranchToexistingTheatre(branchId, theatreId));
				return new ResponseEntity<ResponseStructure<Theatre>>(responseStructure, HttpStatus.OK);
			} else {
				throw new TheatreIdNotFound();
			}
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Theatre>> addNewBranchToExistingTheatre(int theatreId, Branch newBranch) {
		Theatre theatre = theatreDao.fetchTheatreById(theatreId);
		if (theatre != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully New Theatre Added  into DB.");
			responseStructure.setData(theatreDao.addNewBranchToExistingTheatre(theatreId, newBranch));
			return new ResponseEntity<ResponseStructure<Theatre>>(responseStructure, HttpStatus.OK);
		} else {
			throw new TheatreIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Theatre>> fetchTheatreById(int theatreId) {
		Theatre theatre = theatreDao.fetchTheatreById(theatreId);
		if (theatre != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully Theatre Fetched into DB.");
			responseStructure.setData(theatreDao.fetchTheatreById(theatreId));
			return new ResponseEntity<ResponseStructure<Theatre>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new TheatreIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure1<Theatre>> fetchAllTheatre() {
		responseStructure1.setStatusCode(HttpStatus.FOUND.value());
		responseStructure1.setMessage("Successfully fetched all the Theatre Details from DataBase");
		responseStructure1.setData(theatreDao.fetchAllTheatre());
		return new ResponseEntity<ResponseStructure1<Theatre>>(responseStructure1, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Theatre>> updateTheatreById(int oldTheatreId, Theatre newTheatre) {
		Theatre theatre = theatreDao.fetchTheatreById(oldTheatreId);
		if (theatre != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Theatre Updated into DB.");
			responseStructure.setData(theatreDao.updateTheatreById(oldTheatreId, newTheatre));
			return new ResponseEntity<ResponseStructure<Theatre>>(responseStructure, HttpStatus.OK);
		} else {
			throw new TheatreIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Theatre>> deleteTheatreById(int theatreId) {
		Theatre theatre = theatreDao.fetchTheatreById(theatreId);
		if (theatre != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Theatre Deleted From DB.");
			responseStructure.setData(theatreDao.deleteTheatreById(theatreId));
			return new ResponseEntity<ResponseStructure<Theatre>>(responseStructure, HttpStatus.OK);
		} else {
			throw new TheatreIdNotFound();
		}
	}
}
