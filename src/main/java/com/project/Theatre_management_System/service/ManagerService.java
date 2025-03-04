package com.project.Theatre_management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.Theatre_management_System.Dao.ManagerDao;
import com.project.Theatre_management_System.Dto.Manager;
import com.project.Theatre_management_System.exception.ManagerIdNotFound;
import com.project.Theatre_management_System.util.ResponseStructure;
import com.project.Theatre_management_System.util.ResponseStructure1;

@Service
public class ManagerService {

	@Autowired
	ManagerDao managerDao;

	@Autowired
	ResponseStructure<Manager> responseStructure;

	@Autowired
	ResponseStructure1<Manager> responseStructure1;

	public ResponseEntity<ResponseStructure<Manager>> saveManager(Manager manager) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Manager Inserted into DB.");
		responseStructure.setData(managerDao.saveManager(manager));
		return new ResponseEntity<ResponseStructure<Manager>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Manager>> fetchManagerById(int managerId) {
		Manager manager = managerDao.fetchManagerById(managerId);
		if (manager != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully Manager Fetched from DB.");
			responseStructure.setData(managerDao.fetchManagerById(managerId));
			return new ResponseEntity<ResponseStructure<Manager>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new ManagerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure1<Manager>> fetchAllManager() {
		responseStructure1.setStatusCode(HttpStatus.FOUND.value());
		responseStructure1.setMessage("Successfully fetched all the Manager from DataBase");
		responseStructure1.setData(managerDao.fetchAllManager());
		return new ResponseEntity<ResponseStructure1<Manager>>(HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Manager>> deleteManagerById(int managerId) {
		Manager manager = managerDao.fetchManagerById(managerId);
		if (manager != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Manager Deleted from DB.");
			responseStructure.setData(managerDao.deleteManagerById(managerId));
			return new ResponseEntity<ResponseStructure<Manager>>(responseStructure, HttpStatus.OK);
		} else {
			throw new ManagerIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Manager>> updateManagerById(int oldManagerId, Manager newManager) {
		Manager manager = managerDao.fetchManagerById(oldManagerId);
		if (manager != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Manager Updated in DB.");
			responseStructure.setData(managerDao.updateManagerById(oldManagerId, newManager));
			return new ResponseEntity<ResponseStructure<Manager>>(responseStructure, HttpStatus.OK);
		} else {
			throw new ManagerIdNotFound();
		}
	}
}
