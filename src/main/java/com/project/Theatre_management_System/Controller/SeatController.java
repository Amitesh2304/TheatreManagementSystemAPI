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

import com.project.Theatre_management_System.Dto.Seat;
import com.project.Theatre_management_System.service.SeatService;
import com.project.Theatre_management_System.util.ResponseStructure;
import com.project.Theatre_management_System.util.ResponseStructure1;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class SeatController {

	@Autowired
	SeatService seatService;

	@Operation(summary = "Save Owner", description = "API is used to save the Owner")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Owner not found for the given id") })
	@PutMapping("/addExistingSeatToExistingViewer")
	public ResponseEntity<ResponseStructure<Seat>> addExistingSeatToExistingViewer(@RequestParam int viewerId,
			@RequestParam int seatId) {

		return seatService.addExistingSeatToExistingViewer(viewerId, seatId);
	}

	@PostMapping("/saveSeat")
	public ResponseEntity<ResponseStructure<Seat>> saveSeat(@RequestBody Seat seat) {
		return seatService.saveSeat(seat);
	}

	@GetMapping("/fetchSeatById")
	public ResponseEntity<ResponseStructure<Seat>> fetchSeatById(@RequestParam int seatId) {
		return seatService.fetchSeatById(seatId);
	}

	@GetMapping("/fetchAllSeat")
	public ResponseEntity<ResponseStructure1<Seat>> fetchAllSeat() {
		return seatService.fetchAllSeat();
	}

	@PutMapping("/updateSeatById")
	public ResponseEntity<ResponseStructure<Seat>> updateSeatById(@RequestParam int oldSeatId,
			@RequestBody Seat newSeat) {

		return seatService.updateSeatById(oldSeatId, newSeat);
	}

	@DeleteMapping("/deleteSeatById")
	public ResponseEntity<ResponseStructure<Seat>> deleteSeatById(@RequestParam int seatId) {

		return seatService.deleteSeatById(seatId);
	}
}
