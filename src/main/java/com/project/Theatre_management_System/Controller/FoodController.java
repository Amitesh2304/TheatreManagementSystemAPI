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

import com.project.Theatre_management_System.Dto.Food;
import com.project.Theatre_management_System.service.FoodService;
import com.project.Theatre_management_System.util.ResponseStructure;
import com.project.Theatre_management_System.util.ResponseStructure1;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class FoodController {

	@Autowired
	FoodService foodService;
	
	@Operation(summary = "Save Owner", description = "API is used to save the Owner")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Owner not found for the given id") })
	
	@PostMapping("/saveFood")
	public ResponseEntity<ResponseStructure<Food>> saveFood(@RequestBody Food food) {
		return foodService.saveFood(food);
	}
	
	@GetMapping("/fetchFoodById")
	public ResponseEntity<ResponseStructure<Food>> fetchFoodById(@RequestParam int foodId) {
		return foodService.fetchFoodById(foodId);
	}
	
	@GetMapping("/fetchAllFood")
	public ResponseEntity<ResponseStructure1<Food>> fetchAllFood(){
		return foodService.fetchAllFood();
	}
	
	@PutMapping("/updateFoodById")
	public ResponseEntity<ResponseStructure<Food>> updateFoodById(@RequestParam int oldFoodId,@RequestBody Food newFood) {
		
		return foodService.updateFoodById(oldFoodId, newFood);
	}
	
	@DeleteMapping("/deletefoodById")
	public ResponseEntity<ResponseStructure<Food>> deletefoodById(@RequestParam int foodId) {
		return foodService.deletefoodById(foodId);
	}
}
