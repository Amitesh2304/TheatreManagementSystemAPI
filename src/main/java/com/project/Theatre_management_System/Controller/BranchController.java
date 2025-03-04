package com.project.Theatre_management_System.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.Theatre_management_System.Dto.Branch;
import com.project.Theatre_management_System.Dto.Screen;
import com.project.Theatre_management_System.Dto.Staff;
import com.project.Theatre_management_System.service.BranchService;
import com.project.Theatre_management_System.util.ResponseStructure;
import com.project.Theatre_management_System.util.ResponseStructure1;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class BranchController {

	@Autowired
	BranchService branchService;
	
	
	@Operation(summary = "Save Owner", description = "API is used to save the Owner")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Owner not found for the given id") })
	@PostMapping("/saveBranch")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch branch) {
		return branchService.saveBranch(branch);
	}

	//one to many mapping
	@PutMapping("/addNewScreenToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addNewScreenToExistingBranch(@RequestParam int branchId,@RequestBody Screen newScreen) {
		return branchService.addNewScreenToExistingBranch(branchId, newScreen);
	}
	
	@PutMapping("/addExistingScreenToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addExistingScreenToExistingBranch(@RequestParam int screenId,@RequestParam int branchId) {
		return branchService.addExistingScreenToExistingBranch(screenId, branchId);
	}

	@PutMapping("/addExistingBranchToExistingManager")
	public ResponseStructure<Branch> addExistingBranchToExistingManager(@RequestParam int branchId,@RequestParam int managerId) {

		return branchService.addExistingBranchToExistingManager(branchId, managerId);
	}

	@PutMapping("/addExistingBranchToExistingAddress")
	public ResponseEntity<ResponseStructure<Branch>> addExistingBranchToExistingAddress(@RequestParam int branchId,@RequestParam int addressId) {
		return branchService.addExistingBranchToExistingAddress(branchId, addressId);
	}

	@PutMapping("/addExistingStaffToExistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addExistingStaffToExistingBranch(@RequestParam int staffId,@RequestParam int branchId) {
		return branchService.addExistingStaffToExistingBranch(staffId, branchId);
	}

	@PutMapping("/addNewStaffToexistingBranch")
	public ResponseEntity<ResponseStructure<Branch>> addNewStaffToexistingBranch(@RequestParam int BranchId,@RequestBody Staff newStaff) {
		return branchService.addNewStaffToexistingBranch(BranchId, newStaff);
	}

	@GetMapping("/fetchBranchById")
	public ResponseEntity<ResponseStructure<Branch>> fetchBranchById(@RequestParam int branchId) {
		return branchService.fetchBranchById(branchId);
	}

	@GetMapping("/fetchAllBranch")
	public ResponseEntity<ResponseStructure1<Branch>> fetchAllBranch(){
		return branchService.fetchAllBranch();
	}
	@DeleteMapping("/deleteBranchById")
	public ResponseEntity<ResponseStructure<Branch>> deleteBranchById(@RequestParam int branchId) {

		return branchService.deleteBranchById(branchId);
	}

	@PutMapping("/updateBranchById")
	public ResponseEntity<ResponseStructure<Branch>> updateBranchById(@RequestParam int oldBranchId,@RequestBody Branch newBranch) {

		return branchService.updateBranchById(oldBranchId, newBranch);
	}
}
