package com.project.Theatre_management_System.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.Theatre_management_System.Dto.Address;
import com.project.Theatre_management_System.service.AddressService;
import com.project.Theatre_management_System.util.ResponseStructure;
import com.project.Theatre_management_System.util.ResponseStructure1;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class AddressController {

	@Autowired
	AddressService addressService;
	
	@Operation(summary = "Save Owner", description = "API is used to save the Owner")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Owner not found for the given id") })
	@PostMapping("/saveAddress")
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@RequestBody Address address) {
		return addressService.saveAddress(address);
	}
	
	@GetMapping("/fetchAddressById")
	public ResponseEntity<ResponseStructure<Address>> fetchAddressById(@RequestParam int addressId) {
		return addressService.fetchAddressById(addressId);
	}
	
	@GetMapping("/fetchAllAddress")
	public ResponseEntity<ResponseStructure1<Address>> fetchAllAddress() {
		return addressService.fetchAllAddress();
	}
	
	@PutMapping("/updateAddressById")
	public ResponseEntity<ResponseStructure<Address>> updateAddressById(@RequestParam int oldAddressId, @RequestBody Address newAddress) {
		return addressService.updateAddressById(oldAddressId, newAddress);
	}
	
	@DeleteMapping("/deleteAddressById")
	public ResponseEntity<ResponseStructure<Address>> deleteAddressById(@RequestParam int addressId) {
		return addressService.deleteAddressById(addressId);
	}
}
