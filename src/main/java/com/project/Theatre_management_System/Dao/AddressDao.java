package com.project.Theatre_management_System.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Theatre_management_System.Dto.Address;
import com.project.Theatre_management_System.Repo.AddressRepo;

@Repository
public class AddressDao {

	@Autowired
	AddressRepo addressRepo;
	
	public Address saveAddress(Address address) {
		return addressRepo.save(address);
	}
	
	public Address fetchAddressByid(int addressId) {
		 Optional <Address> dbAddress = addressRepo.findById(addressId);
		 if(dbAddress.isPresent()) {
			 return dbAddress.get();
		 }else {
			 return null;
		 }
		 
	}
	
	public List<Address> fetchAllAddress() {
		return addressRepo.findAll();
	}
	
	public Address deleteAddressById(int addressById){
		Address address = fetchAddressByid(addressById);
		addressRepo.delete(address);
		return address;
	}
	
	public Address updateAddressById(int oldAddressId, Address newAddress) {
		newAddress.setAddressId(oldAddressId);
		return addressRepo.save(newAddress);
	}
}
