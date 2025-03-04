package com.project.Theatre_management_System.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Theatre_management_System.Dto.Staff;
import com.project.Theatre_management_System.Repo.StaffRepo;

@Repository
public class StaffDao{

	@Autowired
	StaffRepo staffRepo;
	
	public Staff saveStaff(Staff staff) {
		return staffRepo.save(staff);	
	}
	
	public Staff fetchStaffById(int staffId) {
		Optional<Staff> dbStaff =  staffRepo.findById(staffId);
		if(dbStaff.isPresent()) {
			return dbStaff.get();
		}
		else{
			return null;
		}
	}
	
	public List<Staff> fetchAllStaff(){
		return staffRepo.findAll();
	}
	
	public Staff updateStaffById(int oldStaffId,Staff newStaff) {
		newStaff.setStaffId(oldStaffId);
		return staffRepo.save(newStaff);
	}
	public Staff deleteStaffById(int staffId) {
		Staff staff = fetchStaffById(staffId);
		return staff;
	}
}
