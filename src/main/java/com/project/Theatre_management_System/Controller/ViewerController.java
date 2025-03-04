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

import com.project.Theatre_management_System.Dto.Food;
import com.project.Theatre_management_System.Dto.Ticket;
import com.project.Theatre_management_System.Dto.Viewer;
import com.project.Theatre_management_System.service.ViewerService;
import com.project.Theatre_management_System.util.ResponseStructure;
import com.project.Theatre_management_System.util.ResponseStructure1;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class ViewerController {

	@Autowired
	ViewerService viewerService;
	
	
	@Operation(summary = "Save Owner", description = "API is used to save the Owner")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created"),
	@ApiResponse(responseCode = "404", description = "Owner not found for the given id") })
	
	@PutMapping("/addNewFoodToExistingViewer")
	public ResponseEntity<ResponseStructure<Viewer>> addNewFoodToExistingViewer(@RequestParam int viewerId,@RequestBody Food newFood) {
		return viewerService.addNewFoodToExistingViewer(viewerId, newFood);
	}
	
	@PutMapping("/addExistingFoodToExistingViewer")
	public ResponseEntity<ResponseStructure<Viewer>> addExistingFoodToExistingViewer(@RequestParam int foodId,@RequestParam int viewerId) {
		return viewerService.addExistingFoodToExistingViewer(foodId, viewerId);
	}
	
	@PutMapping("/addNewTicketToExistingViewer")
	public ResponseEntity<ResponseStructure<Viewer>> addNewTicketToExistingViewer(@RequestParam int viewerId,@RequestBody Ticket newTicket) {
		return viewerService.addNewTicketToExistingViewer(viewerId, newTicket);
	}
	
	@PutMapping("/addExistingTicketToExistingViewer")
	public ResponseEntity<ResponseStructure<Viewer>> addExistingTicketToExistingViewer(@RequestParam int ticketId,@RequestParam int viewerId) {
		return viewerService.addExistingTicketToExistingViewer(ticketId, viewerId);
	}
	
	@PostMapping("/saveViewer")
	public ResponseEntity<ResponseStructure<Viewer>> saveViewer(@RequestBody Viewer viewer) {
		return viewerService.saveViewer(viewer);
	}
	
	@GetMapping("/fetchViewerById")
	public ResponseEntity<ResponseStructure<Viewer>> fetchViewerById(@RequestParam int viewerId) {
		return viewerService.fetchViewerById(viewerId);
	}
	
	@GetMapping("/fetchAllViewer")
	public ResponseEntity<ResponseStructure1<Viewer>> fetchAllViewer(){
		return viewerService.fetchAllViewer();
	}
	
	@PutMapping("/updateViewerById")
	public ResponseEntity<ResponseStructure<Viewer>> updateViewerById(@RequestParam int oldViewerId,@RequestBody Viewer newViewer) {
		return viewerService.updateViewerById(oldViewerId, newViewer);
	}
	
	@DeleteMapping("/deleteViewerById")
	public ResponseEntity<ResponseStructure<Viewer>> deleteViewerById(@RequestParam int viewerId) {
		return viewerService.deleteViewerById(viewerId);
	}
}
