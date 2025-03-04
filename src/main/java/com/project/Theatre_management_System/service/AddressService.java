package com.project.Theatre_management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.Theatre_management_System.Dao.AddressDao;
import com.project.Theatre_management_System.Dto.Address;
import com.project.Theatre_management_System.Dto.Owner;
import com.project.Theatre_management_System.exception.AddressIdNotFound;
import com.project.Theatre_management_System.exception.OwnerIdNotFound;
import com.project.Theatre_management_System.util.ResponseStructure;
import com.project.Theatre_management_System.util.ResponseStructure1;

@Service
public class AddressService {

	@Autowired
	AddressDao addressDao;

	@Autowired
	ResponseStructure<Address> responseStructure;

	@Autowired
	ResponseStructure1<Address> responseStructure1;

	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Address Inserted into DB.");
		responseStructure.setData(addressDao.saveAddress(address));
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Address>> fetchAddressById(int addressId) {
		Address address = addressDao.fetchAddressByid(addressId);
		if (address != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully Address Fetched from DB.");
			responseStructure.setData(addressDao.fetchAddressByid(addressId));
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.FOUND);
		} else {
			throw new AddressIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure1<Address>> fetchAllAddress() {
		responseStructure1.setStatusCode(HttpStatus.FOUND.value());
		responseStructure1.setMessage("Successfully fetched all the Addresses from DataBase");
		responseStructure1.setData(addressDao.fetchAllAddress());
		return new ResponseEntity<ResponseStructure1<Address>>(HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Address>> updateAddressById(int oldAddressId, Address newAddress) {
		Address address = addressDao.fetchAddressByid(oldAddressId);
		if (address != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Address Updated in DB.");
			responseStructure.setData(addressDao.updateAddressById(oldAddressId, newAddress));
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.OK);
		} else {
			throw new AddressIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Address>> deleteAddressById(int addressId) {
		Address address = addressDao.fetchAddressByid(addressId);
		if (address != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Address Deleted from DB.");
			responseStructure.setData(addressDao.deleteAddressById(addressId));
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.OK);
		} else {
			throw new AddressIdNotFound();
		}
	}
}
