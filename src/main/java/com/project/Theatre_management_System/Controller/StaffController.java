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

import com.project.Theatre_management_System.Dto.Staff;
import com.project.Theatre_management_System.service.StaffService;
import com.project.Theatre_management_System.util.ResponseStructure;
import com.project.Theatre_management_System.util.ResponseStructure1;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class StaffController {

	@Autowired
	StaffService staffService;
	
	@Operation(summary = "Save Owner", description = "API is used to save the Owner")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created"),
	@ApiResponse(responseCode = "404", description = "Owner not found for the given id") })
	@PostMapping("/saveStaff")
	public ResponseEntity<ResponseStructure<Staff>> saveStaff(@RequestBody Staff staff) {
		return staffService.saveStaff(staff);
	}
	
	@GetMapping("/fetchStaffById")
	public ResponseEntity<ResponseStructure<Staff>> fetchStaffById(@RequestParam int staffId) {
		return staffService.fetchStaffById(staffId);
	}
	
	@GetMapping("/fetchAllStaff")
	public ResponseEntity<ResponseStructure1<Staff>> fetchAllStaff(){
		return staffService.fetchAllStaff();
	}
	
	@PutMapping("/updateStaffById")
	public ResponseEntity<ResponseStructure<Staff>> updateStaffById(@RequestParam int oldStaffId,@RequestBody Staff newStaff) {
		
		return staffService.updateStaffById(oldStaffId, newStaff);
	}
	
	@DeleteMapping("/deleteStaffById")
	public ResponseEntity<ResponseStructure<Staff>> deleteStaffById(@RequestParam int staffId) {
		
		return staffService.deleteStaffById(staffId);
	}
}
