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

import com.project.Theatre_management_System.Dto.Screen;
import com.project.Theatre_management_System.Dto.Seat;
import com.project.Theatre_management_System.service.ScreenService;
import com.project.Theatre_management_System.util.ResponseStructure;
import com.project.Theatre_management_System.util.ResponseStructure1;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class ScreenController {

	@Autowired
	ScreenService screenService;
	
	@Operation(summary = "Save Owner", description = "API is used to save the Owner")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Owner not found for the given id") })
	@PutMapping("/addNewSeatToExistingScreen")
	public ResponseEntity<ResponseStructure<Screen>> addNewSeatToExistingScreen(@RequestParam int screenId,@RequestBody Seat newSeat) {
		return screenService.addNewSeatToExistingScreen(screenId, newSeat);
	}
	
	@PutMapping("/addExistingSeatToExistingScreen")
	public ResponseEntity<ResponseStructure<Screen>> addExistingSeatToExistingScreen(@RequestParam int seatId,@RequestParam int screenId) {
		return screenService.addExistingSeatToExistingScreen(seatId, screenId);
	}

	@PostMapping("/saveScreen")
	public ResponseEntity<ResponseStructure<Screen>> saveScreen(@RequestBody Screen screen) {
		return screenService.saveScreen(screen);
	}

	@PutMapping("/addExistingScreenToExistingMovie")
	public ResponseEntity<ResponseStructure<Screen>> addExistingScreenToExistingMovie(@RequestParam int screenId,@RequestParam int movieId) {

		return screenService.addExistingScreenToExistingMovie(screenId, movieId);
	}

	@GetMapping("/fetchScreenById")
	public ResponseEntity<ResponseStructure<Screen>> fetchScreenById(@RequestParam int screenId) {
		return screenService.fetchScreenById(screenId);
	}

	@GetMapping("/fetchAllScreen")
	public ResponseEntity<ResponseStructure1<Screen>> fetchAllScreen(){
		return screenService.fetchAllScreen();
	}

	@PutMapping("/updateScreenById")
	public ResponseEntity<ResponseStructure<Screen>> updateScreenById(@RequestParam int oldScreenId,@RequestBody Screen newScreen) {

		return screenService.updateScreenById(oldScreenId, newScreen);
	}
	@DeleteMapping("/deleteScreenById")
	public ResponseEntity<ResponseStructure<Screen>> deleteScreenById(@RequestParam int screenId) {
		return screenService.deleteScreenById(screenId);
	}
}
