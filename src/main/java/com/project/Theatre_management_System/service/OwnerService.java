package com.project.Theatre_management_System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.Theatre_management_System.Dao.OwnerDao;
import com.project.Theatre_management_System.Dao.TheatreDao;
import com.project.Theatre_management_System.Dto.Owner;
import com.project.Theatre_management_System.Dto.Theatre;
import com.project.Theatre_management_System.exception.OwnerIdNotFound;
import com.project.Theatre_management_System.exception.TheatreIdNotFound;
import com.project.Theatre_management_System.util.ResponseStructure;
import com.project.Theatre_management_System.util.ResponseStructure1;

@Service
public class OwnerService {

	@Autowired
	OwnerDao ownerDao;

	@Autowired
	TheatreDao theatreDao;

	@Autowired
	ResponseStructure<Owner> responseStructure;

	@Autowired
	ResponseStructure1<Owner> responseStructure1;

	// saving Owner details

	public ResponseEntity<ResponseStructure<Owner>> saveOwner(Owner ownwer) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Owner Inserted into DB.");
		responseStructure.setData(ownerDao.saveOwner(ownwer));
		return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseStructure<Owner> addExistingTheatreToExistingOwner(int theatreId, int ownerId) {
		Owner owner = ownerDao.fetchOwnerById(ownerId);
		Theatre theatre = theatreDao.fetchTheatreById(theatreId);
		if (theatre != null) {
			if (owner != null) {
				responseStructure.setStatusCode(HttpStatus.FOUND.value());
				responseStructure.setMessage("Successfully Owner Added into DB.");
				responseStructure.setData(ownerDao.addExistingTheatreToExistingOwner(theatreId, ownerId));
				return responseStructure;
			} else {
				throw new OwnerIdNotFound();
			}
		} else {
			throw new TheatreIdNotFound();
		}

	}

	public ResponseEntity<ResponseStructure<Owner>> fetchOwnerById(int ownerId) {
		Owner owner = ownerDao.fetchOwnerById(ownerId);
		if (owner != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully Owner Fetched From DB.");
			responseStructure.setData(ownerDao.fetchOwnerById(ownerId));
			return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new OwnerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure1<Owner>> fetchAllOwner() {
		responseStructure1.setStatusCode(HttpStatus.FOUND.value());
		responseStructure1.setMessage("Successfully fetched all the Owner from DataBase");
		responseStructure1.setData(ownerDao.fetchAllOwner());
		return new ResponseEntity<ResponseStructure1<Owner>>(responseStructure1, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Owner>> deleteOwnerById(int ownerId) {
		Owner owner = ownerDao.fetchOwnerById(ownerId);
		if (owner != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Owner Deleted From DB.");
			responseStructure.setData(ownerDao.deleteOwnerById(ownerId));
			return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.OK);
		} else {
			throw new OwnerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Owner>> UpdateOwnerById(int oldOwnerId, Owner newOwner) {
		Owner owner = ownerDao.fetchOwnerById(oldOwnerId);
		if (owner != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Owner Updated into DB.");
			responseStructure.setData(ownerDao.updateOwnerById(oldOwnerId, newOwner));
			return new ResponseEntity<ResponseStructure<Owner>>(responseStructure, HttpStatus.OK);
		} else {
			throw new OwnerIdNotFound();
		}
	}
}
