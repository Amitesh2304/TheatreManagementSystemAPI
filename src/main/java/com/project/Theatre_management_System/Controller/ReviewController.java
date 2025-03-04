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

import com.project.Theatre_management_System.Dto.Review;
import com.project.Theatre_management_System.service.ReviewService;
import com.project.Theatre_management_System.util.ResponseStructure;
import com.project.Theatre_management_System.util.ResponseStructure1;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class ReviewController {

	@Autowired
	ReviewService reviewService;

	@Operation(summary = "Save Owner", description = "API is used to save the Owner")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Owner not found for the given id") })
	@PostMapping("/saveReview")
	public ResponseEntity<ResponseStructure<Review>> saveReview(@RequestBody Review review) {
		return reviewService.saveReview(review);
	}

	@GetMapping("/fetchReviewById")
	public ResponseEntity<ResponseStructure<Review>> fetchReviewById(@RequestParam int reviewId) {
		return reviewService.fetchReviewById(reviewId);
	}

	@GetMapping("/fetchAllReview")
	public ResponseEntity<ResponseStructure1<Review>> fetchAllReview() {
		return reviewService.fetchAllReview();
	}

	@PutMapping("/updateReviewById")
	public ResponseEntity<ResponseStructure<Review>> updateReviewById(@RequestParam int oldReviewId,
			@RequestBody Review newReview) {

		return reviewService.updateReviewById(oldReviewId, newReview);
	}

	@DeleteMapping("/deleteReviewById")
	public ResponseEntity<ResponseStructure<Review>> deleteReviewById(@RequestParam int reviewId) {

		return reviewService.deleteReviewById(reviewId);
	}
}
