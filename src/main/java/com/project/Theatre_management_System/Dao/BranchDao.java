package com.project.Theatre_management_System.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Theatre_management_System.Dto.Address;
import com.project.Theatre_management_System.Dto.Branch;
import com.project.Theatre_management_System.Dto.Manager;
import com.project.Theatre_management_System.Dto.Branch;
import com.project.Theatre_management_System.Dto.Screen;
import com.project.Theatre_management_System.Dto.Staff;
import com.project.Theatre_management_System.Dto.Theatre;
import com.project.Theatre_management_System.Repo.BranchRepo;

@Repository
public class BranchDao {

	@Autowired
	BranchRepo branchRepo;
	
	@Autowired
	ManagerDao managerDao;
	
	@Autowired
	AddressDao addressDao;
	
	@Autowired
	StaffDao staffDao;
	
	@Autowired
	ScreenDao screenDao;
	
	//one to many mapping
	public Branch addNewScreenToExistingBranch( int branchId, Screen newScreen) {
		Branch branch = fetchBranchById(branchId);
		List<Screen> list = branch.getScreen();
		list.add(newScreen);
		branch.setScreen(list);
		return saveBranch(branch);
	}
	
	public Branch addExistingScreenToExistingBranch(int screenId, int branchId) {
		Screen screen = screenDao.fetchScreenById(screenId);
		Branch branch = fetchBranchById(branchId);
		List<Screen> list = branch.getScreen();
		list.add(screen);
		branch.setScreen(list);
		return saveBranch(branch);
	}
	
	//end of
	
	public Branch addExistingBranchToExistingManager(int branchId,int managerId) {
		Manager manager = managerDao.fetchManagerById(managerId);
		Branch branch = fetchBranchById(branchId);
		branch.setManager(manager);
		return saveBranch(branch);
	}
	
	public Branch addExistingBranchToExistingAddress(int branchId,int addressId) {
		Address address = addressDao.fetchAddressByid(addressId);
		Branch branch = fetchBranchById(branchId);
		branch.setAddress(address);
		return saveBranch(branch);
	}
	/*
	 * public Theatre addNewBranchToExistingTheatre(int theatreId, Branch newBranch) {
		Theatre theatre = fetchTheatreById(theatreId);
		List<Branch> list = theatre.getBranch();
		list.add(newBranch);
		theatre.setBranch(list);
		return saveTheatre(theatre);
	}
	 */
	
	public Branch addNewStaffToexistingBranch( int BranchId, Staff newStaff) {
		Branch branch = fetchBranchById(BranchId);
		List<Staff> list = branch.getStaff();
		list.add(newStaff);
		branch.setStaff(list);
		return saveBranch(branch);
	}
	
	public Branch addExistingStaffToExistingBranch(int staffId, int branchId) {
		Staff staff = staffDao.fetchStaffById(staffId);
		Branch branch = fetchBranchById(branchId);
		List<Staff> list = branch.getStaff();
		list.add(staff);
		branch.setStaff(list);
		return saveBranch(branch);
	}
	
	public Branch saveBranch(Branch branch) {
		return branchRepo.save(branch);
	}
	
	public Branch fetchBranchById(int branchId) {
		Optional <Branch> dbBranch = branchRepo.findById(branchId);
		 if(dbBranch.isPresent()) {
			 return dbBranch.get();
		 }else {
			 return null;
		 }
		 
	}
	
	public List<Branch> fetchAllBranch(){
		return branchRepo.findAll();
	}
	
	public Branch deleteBranchById(int branchId) {
		Branch branch = fetchBranchById(branchId);
		branchRepo.delete(branch);
		return branch;
	}
	
	public Branch updateBranchById(int oldBranchId, Branch newBranch) {
		newBranch.setBranchId(oldBranchId);
		return branchRepo.save(newBranch);
	}
}
