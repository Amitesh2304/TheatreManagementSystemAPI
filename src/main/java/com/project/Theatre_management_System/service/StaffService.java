package com.project.Theatre_management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.Theatre_management_System.Dao.StaffDao;
import com.project.Theatre_management_System.Dto.Staff;
import com.project.Theatre_management_System.exception.StaffIdNotFound;
import com.project.Theatre_management_System.util.ResponseStructure;
import com.project.Theatre_management_System.util.ResponseStructure1;

@Service
public class StaffService {

	@Autowired
	StaffDao staffDao;

	@Autowired
	ResponseStructure<Staff> responseStructure;

	@Autowired
	ResponseStructure1<Staff> responseStructure1;

	public ResponseEntity<ResponseStructure<Staff>> saveStaff(Staff staff) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Seat Inserted into DB.");
		responseStructure.setData(staffDao.saveStaff(staff));
		return new ResponseEntity<ResponseStructure<Staff>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Staff>> fetchStaffById(int staffId) {
		Staff staff = staffDao.fetchStaffById(staffId);
		if (staff != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully Seat Fetched From DB.");
			responseStructure.setData(staffDao.fetchStaffById(staffId));
			return new ResponseEntity<ResponseStructure<Staff>>(responseStructure, HttpStatus.FOUND);
		} else {
			throw new StaffIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure1<Staff>> fetchAllStaff() {
		responseStructure1.setStatusCode(HttpStatus.FOUND.value());
		responseStructure1.setMessage("Successfully fetched all the Staff Details from DataBase");
		responseStructure1.setData(staffDao.fetchAllStaff());
		return new ResponseEntity<ResponseStructure1<Staff>>(responseStructure1, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Staff>> updateStaffById(int oldStaffId, Staff newStaff) {
		Staff staff = staffDao.fetchStaffById(oldStaffId);
		if (staff != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Seat Updated into DB.");
			responseStructure.setData(staffDao.updateStaffById(oldStaffId, newStaff));
			return new ResponseEntity<ResponseStructure<Staff>>(responseStructure, HttpStatus.OK);
		} else {
			throw new StaffIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Staff>> deleteStaffById(int staffId) {
		Staff staff = staffDao.fetchStaffById(staffId);
		if (staff != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Seat Deleted From DB.");
			responseStructure.setData(staffDao.deleteStaffById(staffId));
			return new ResponseEntity<ResponseStructure<Staff>>(responseStructure, HttpStatus.OK);
		} else {
			throw new StaffIdNotFound();
		}
	}
}
