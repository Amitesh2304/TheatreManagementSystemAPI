package com.project.Theatre_management_System.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Theatre_management_System.Dto.Owner;
import com.project.Theatre_management_System.Dto.Theatre;
import com.project.Theatre_management_System.Repo.OwnerRepo;

@Repository
public class OwnerDao {

	@Autowired
	OwnerRepo ownerRepo;
	
	@Autowired
	TheatreDao theatreDoa;
	
//	@Autowired
//	Owner ownerDao;
	
	//saving the Owners Details
	public Owner saveOwner(Owner owner) {
		return ownerRepo.save(owner);
	}
	
	public Owner addExistingTheatreToExistingOwner(int theatreId, int ownerId) {
		Theatre theatre = theatreDoa.fetchTheatreById(theatreId);
		Owner owner = fetchOwnerById(ownerId);
		owner.setTheatre(theatre);
		return saveOwner(owner);
	}
	//printing single owner details
	public Owner fetchOwnerById(int  ownerId) {
		Optional<Owner> dbOwner = ownerRepo.findById(ownerId);
		if(dbOwner.isPresent()) {
			return dbOwner.get();
		}else {
			return null;
		}
		
	}
	
	//printing all owner details
	public List<Owner> fetchAllOwner() {
		return ownerRepo.findAll();
	}
	
	//deleting Owner details
	public Owner deleteOwnerById(int ownerId) {
		Owner owner = fetchOwnerById(ownerId);
		ownerRepo.delete(owner);
		return owner;
	}
	
	//updating Owner details 
	public Owner updateOwnerById(int oldOwnerId,  Owner newOwner) {
		newOwner.setOwnerId(oldOwnerId);
		return ownerRepo.save(newOwner);
	}
}
