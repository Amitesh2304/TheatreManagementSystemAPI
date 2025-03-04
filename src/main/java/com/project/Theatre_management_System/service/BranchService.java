package com.project.Theatre_management_System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.Theatre_management_System.Dao.AddressDao;
import com.project.Theatre_management_System.Dao.BranchDao;
import com.project.Theatre_management_System.Dao.ManagerDao;
import com.project.Theatre_management_System.Dao.ScreenDao;
import com.project.Theatre_management_System.Dao.StaffDao;
import com.project.Theatre_management_System.Dto.Address;
import com.project.Theatre_management_System.Dto.Branch;
import com.project.Theatre_management_System.Dto.Manager;
import com.project.Theatre_management_System.Dto.Screen;
import com.project.Theatre_management_System.Dto.Staff;
import com.project.Theatre_management_System.exception.AddressIdNotFound;
import com.project.Theatre_management_System.exception.BranchIdNotFound;
import com.project.Theatre_management_System.exception.ManagerIdNotFound;
import com.project.Theatre_management_System.exception.ScreenIdNotFound;
import com.project.Theatre_management_System.exception.StaffIdNotFound;
import com.project.Theatre_management_System.util.ResponseStructure;
import com.project.Theatre_management_System.util.ResponseStructure1;

@Service
public class BranchService {

	@Autowired
	BranchDao branchDao;

	@Autowired
	ScreenDao screenDao;

	@Autowired
	ManagerDao managerDao;

	@Autowired
	AddressDao addressDao;

	@Autowired
	StaffDao staffDao;

	@Autowired
	ResponseStructure<Branch> responseStructure;

	@Autowired
	ResponseStructure1<Branch> responseStructure1;

	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Branch Inserted into DB.");
		responseStructure.setData(branchDao.saveBranch(branch));
		return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.CREATED);
	}

	// one to many mapping
	public ResponseEntity<ResponseStructure<Branch>> addNewScreenToExistingBranch(int branchId, Screen newScreen) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Branch Fetched From DB.");
			responseStructure.setData(branchDao.addExistingScreenToExistingBranch(branchId, branchId));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> addExistingScreenToExistingBranch(int screenId, int branchId) {
		Screen screen = screenDao.fetchScreenById(screenId);
		if (screen != null) {
			Branch branch = branchDao.fetchBranchById(branchId);
			if (branch != null) {
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setMessage("Successfully  addExistingScreenToExistingBranch into DB.");
				responseStructure.setData(branchDao.addExistingScreenToExistingBranch(screenId, branchId));
				return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
			} else {
				throw new BranchIdNotFound();
			}
		} else {
			throw new ScreenIdNotFound();
		}
	}

	public ResponseStructure<Branch> addExistingBranchToExistingManager(int branchId, int managerId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			Manager manager = managerDao.fetchManagerById(managerId);
			if (manager != null) {
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setMessage("Successfully addExistingBranchToExistingManager  into DB.");
				responseStructure.setData(branchDao.addExistingBranchToExistingManager(branchId, managerId));
				return responseStructure;
			} else {
				throw new ManagerIdNotFound();
			}
		} else {
			throw new BranchIdNotFound();
		}
	}

	// change set message from hare
	public ResponseEntity<ResponseStructure<Branch>> addExistingBranchToExistingAddress(int branchId, int addressId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			Address address = addressDao.fetchAddressByid(addressId);
			if (address != null) {
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setMessage("Successfully addExistingBranchToExistingManager  into DB.");
				responseStructure.setData(branchDao.addExistingBranchToExistingAddress(branchId, addressId));
				return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
			} else {
				throw new AddressIdNotFound();
			}
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> addExistingStaffToExistingBranch(int staffId, int branchId) {
		Staff staff = staffDao.fetchStaffById(staffId);
		if (staff != null) {
			Branch branch = branchDao.fetchBranchById(branchId);
			if (branch != null) {
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setMessage("Successfully addExistingBranchToExistingAddress  into DB.");
				responseStructure.setData(branchDao.addExistingStaffToExistingBranch(staffId, branchId));
				return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
			} else {
				throw new BranchIdNotFound();
			}
		} else {
			throw new StaffIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> addNewStaffToexistingBranch(int branchId, Staff newStaff) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully addNewStaffToexistingBranch  into DB.");
			responseStructure.setData(branchDao.addNewStaffToexistingBranch(branchId, newStaff));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> fetchBranchById(int branchId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully Branch Fetched From DB.");
			responseStructure.setData(branchDao.fetchBranchById(branchId));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.FOUND);
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure1<Branch>> fetchAllBranch() {
		responseStructure1.setStatusCode(HttpStatus.FOUND.value());
		responseStructure1.setMessage("Successfully fetched all the branches data from DataBase");
		responseStructure1.setData(branchDao.fetchAllBranch());

		return new ResponseEntity<ResponseStructure1<Branch>>(HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Branch>> deleteBranchById(int branchId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Branch Deleted From DB.");
			responseStructure.setData(branchDao.deleteBranchById(branchId));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> updateBranchById(int oldBranchId, Branch newBranch) {
		Branch branch = branchDao.fetchBranchById(oldBranchId);
		if (branch != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Updated  into DB.");
			responseStructure.setData(branchDao.updateBranchById(oldBranchId, newBranch));
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
		} else {
			throw new BranchIdNotFound();
		}
	}
}
