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

import com.project.Theatre_management_System.Dto.Ticket;
import com.project.Theatre_management_System.service.TicketService;
import com.project.Theatre_management_System.util.ResponseStructure;
import com.project.Theatre_management_System.util.ResponseStructure1;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class TicketController {

	@Autowired
	TicketService ticketService;

	@Operation(summary = "Save Owner", description = "API is used to save the Owner")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Owner not found for the given id") })
	@PostMapping("/saveTicket")
	public ResponseEntity<ResponseStructure<Ticket>> saveTicket(@RequestBody Ticket ticket) {
		return ticketService.saveTicket(ticket);
	}

	@PutMapping("/addExistingTicketToExistingPayment")
	public ResponseEntity<ResponseStructure<Ticket>> addExistingTicketToExistingPayment(@RequestParam int ticketId,@RequestParam int paymentId) {

		return ticketService.addExistingTicketToExistingPayment(ticketId, paymentId);
	}

	@GetMapping("/fetchTicketById")
	public ResponseEntity<ResponseStructure<Ticket>> fetchTicketById(@RequestParam int ticketId) {
		return ticketService.fetchTicketById(ticketId);
	}

	@GetMapping("/fetchAllTicket")
	public ResponseEntity<ResponseStructure1<Ticket>> fetchAllTicket(){
		return ticketService.fetchAllTicket();
	}

	@PutMapping("/updateTicketById")
	public ResponseEntity<ResponseStructure<Ticket>> updateTicketById(@RequestParam int oldTicketId,@RequestBody Ticket newTicket) {
		return ticketService.updateTicketById(oldTicketId, newTicket);
	}

	@DeleteMapping("/deleteTicketById")
	public ResponseEntity<ResponseStructure<Ticket>> deleteTicketById(@RequestParam int ticketId) {
		return ticketService.deleteTicketById(ticketId);
	}
}
