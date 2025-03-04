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

import com.project.Theatre_management_System.Dto.Branch;
import com.project.Theatre_management_System.Dto.Theatre;
import com.project.Theatre_management_System.service.TheatreService;
import com.project.Theatre_management_System.util.ResponseStructure;
import com.project.Theatre_management_System.util.ResponseStructure1;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class TheatreController {

	@Autowired
	TheatreService theatreService;

	@Operation(summary = "Save Owner", description = "API is used to save the Owner")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Owner not found for the given id") })
	@PostMapping("/saveTheatre")
	public ResponseEntity<ResponseStructure<Theatre>> saveTheatre(@RequestBody Theatre theatre) {
		return theatreService.saveTheatre(theatre);
	}

	@PutMapping("/addExistingBranchToexistingTheatre")
	public ResponseEntity<ResponseStructure<Theatre>> addExistingBranchToexistingTheatre(@RequestParam int branchId,
			@RequestParam int theatreId) {
		return theatreService.addExistingBranchToexistingTheatre(branchId, theatreId);
	}

	@PutMapping("/addNewBranchToExistingTheatre")
	public ResponseEntity<ResponseStructure<Theatre>> addNewBranchToExistingTheatre(@RequestParam int theatreId,
			@RequestBody Branch newBranch) {
		return theatreService.addNewBranchToExistingTheatre(theatreId, newBranch);
	}

	@GetMapping("/fetchTheatreById")
	public ResponseEntity<ResponseStructure<Theatre>> fetchTheatreById(@RequestParam int theatreId) {
		return theatreService.fetchTheatreById(theatreId);
	}

	@GetMapping("/fetchAllTheatre")
	public ResponseEntity<ResponseStructure1<Theatre>> fetchAllTheatre() {
		return theatreService.fetchAllTheatre();
	}

	@PutMapping("/updateTheatreById")
	public ResponseEntity<ResponseStructure<Theatre>> updateTheatreById(@RequestParam int oldTheatreId,
			@RequestParam Theatre newTheatre) {

		return theatreService.updateTheatreById(oldTheatreId, newTheatre);
	}

	@DeleteMapping("/deleteTheatreById")
	public ResponseEntity<ResponseStructure<Theatre>> deleteTheatreById(@RequestParam int theatreId) {

		return theatreService.deleteTheatreById(theatreId);
	}
}
