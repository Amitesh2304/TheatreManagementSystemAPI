package com.project.Theatre_management_System.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Theatre_management_System.Dto.Branch;
import com.project.Theatre_management_System.Dto.Theatre;
import com.project.Theatre_management_System.Repo.TheatreRepo;

@Repository
public class TheatreDao {

	@Autowired
	TheatreRepo theatreRepo;
	
	@Autowired
	BranchDao branchDao;
	
	public Theatre saveTheatre(Theatre theatre) {
		return theatreRepo.save(theatre);	
	}
	
	public Theatre addExistingBranchToexistingTheatre(int branchId, int theatreId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		Theatre theatre = fetchTheatreById(theatreId);
		List<Branch> list = theatre.getBranch();
		list.add(branch);
		theatre.setBranch(list);
		return saveTheatre(theatre);
	}
	
	public Theatre addNewBranchToExistingTheatre(int theatreId, Branch newBranch) {
		Theatre theatre = fetchTheatreById(theatreId);
		List<Branch> list = theatre.getBranch();
		list.add(newBranch);
		theatre.setBranch(list);
		return saveTheatre(theatre);
	}
	
	public Theatre fetchTheatreById(int theatreId) {
		Optional<Theatre> dbTheatre = theatreRepo.findById(theatreId);
		if(dbTheatre.isPresent()) {
			return dbTheatre.get();
		}else {
			return null;
		}
	}
	
	public List<Theatre> fetchAllTheatre(){
		
		
		return theatreRepo.findAll();
	}
	
	public Theatre updateTheatreById(int oldTheatreId,Theatre newTheatre) {
		newTheatre.setTheatreId(oldTheatreId);
		return theatreRepo.save(newTheatre);
	}
	public Theatre deleteTheatreById(int theatreId) {
		Theatre theatre = fetchTheatreById(theatreId);
		return theatre;
	}
}
