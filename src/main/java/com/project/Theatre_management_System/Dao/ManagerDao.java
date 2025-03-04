package com.project.Theatre_management_System.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Theatre_management_System.Dto.Manager;
import com.project.Theatre_management_System.Repo.ManagerRepo;

@Repository
public class ManagerDao {

	@Autowired
	ManagerRepo managerRepo;

	public Manager saveManager(Manager manager) {
		return managerRepo.save(manager);
	}

	public Manager fetchManagerById(int managerId) {
		Optional<Manager> dbManager = managerRepo.findById(managerId);
		if(dbManager.isPresent()) {
			return dbManager.get();
		}else {
			return null;
		}
	}

	public List<Manager> fetchAllManager(){
		return managerRepo.findAll();
	}

	public Manager deleteManagerById(int managerId) {
		Manager manager = fetchManagerById(managerId);
		return manager;
	}
	
	public Manager updateManagerById(int oldManagerId, Manager newManager) {
		newManager.setManagerId(oldManagerId);
		return managerRepo.save(newManager);
	}
}
