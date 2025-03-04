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

import com.project.Theatre_management_System.Dto.Movie;
import com.project.Theatre_management_System.Dto.Review;
import com.project.Theatre_management_System.Dto.Viewer;
import com.project.Theatre_management_System.service.MovieService;
import com.project.Theatre_management_System.util.ResponseStructure;
import com.project.Theatre_management_System.util.ResponseStructure1;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class MovieController {

	@Autowired
	MovieService movieService;
	
	@Operation(summary = "Save Owner", description = "API is used to save the Owner")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Owner not found for the given id") })
	@PutMapping("/addNewReviewToExistingMovie")
	public ResponseEntity<ResponseStructure<Movie>> addNewReviewToExistingMovie(@RequestParam int movieId,@RequestBody Review newReview) {
		return movieService.addNewReviewToExistingMovie(movieId, newReview);
	}
	
	@PutMapping("/addExistingReviewToExistingMovie")
	public ResponseEntity<ResponseStructure<Movie>> addExistingReviewToExistingMovie(@RequestParam int reviewId,@RequestParam int movieId) {
		return movieService.addExistingReviewToExistingMovie(reviewId, movieId);
	}
	
	@PostMapping("/saveMovie")
	public ResponseEntity<ResponseStructure<Movie>> saveMovie(@RequestBody Movie movie) {
		return movieService.saveMovie(movie);	
	}
	
	@GetMapping("/fetchMovieById")
	public ResponseEntity<ResponseStructure<Movie>> fetchMovieById(@RequestParam int movieId) {
		return movieService.fetchMovieById(movieId);
		
	}
	
	@GetMapping("/fetchAllMovie")
	public ResponseEntity<ResponseStructure1<Movie>> fetchAllMovie(){
		return movieService.fetchAllMovie();
	}
	
	@PutMapping("/updateMovieById")
	public ResponseEntity<ResponseStructure<Movie>> updateMovieById(@RequestParam int oldMovieId,@RequestBody Movie newMovie) {
		
		return movieService.updateMovieById(oldMovieId, newMovie);
	}
	
	@DeleteMapping("/deleteMovieById")
	public ResponseEntity<ResponseStructure<Movie>> deleteMovieById(@RequestParam int movieId) {
		return movieService.deleteMovieById(movieId);
	}
	
	@PutMapping("/addExistingViewerToExistingMovie")
	public ResponseEntity<ResponseStructure<Movie>> addExistingViewerToExistingMovie(@RequestParam int viewerId,@RequestParam int movieId) {
		return movieService.addExistingViewerToExistingMovie(viewerId, movieId);
	}
	
	@PutMapping("/addNewViewerToExistingMovie")
	public ResponseEntity<ResponseStructure<Movie>> addNewViewerToExistingMovie(@RequestParam int movieId,@RequestBody Viewer newViewer) {
		return movieService.addNewViewerToExistingMovie(movieId, newViewer);
	}
}
