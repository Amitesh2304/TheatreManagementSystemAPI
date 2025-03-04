package com.project.Theatre_management_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.Theatre_management_System.Dao.FoodDao;
import com.project.Theatre_management_System.Dto.Branch;
import com.project.Theatre_management_System.Dto.Food;
import com.project.Theatre_management_System.exception.FoodIdNotFound;
import com.project.Theatre_management_System.util.ResponseStructure;
import com.project.Theatre_management_System.util.ResponseStructure1;

@Service
public class FoodService {

	@Autowired
	FoodDao foodDao;

	@Autowired
	ResponseStructure<Food> responseStructure;

	@Autowired
	ResponseStructure1<Food> responseStructure1;
	
	

	public ResponseEntity<ResponseStructure<Food>> saveFood(Food food) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Successfully Food Inserted into DB.");
		responseStructure.setData(foodDao.saveFood(food));
		return new ResponseEntity<ResponseStructure<Food>>(responseStructure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Food>> fetchFoodById(int foodId) {
		Food food = foodDao.fetchFoodById(foodId);
		if (food != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully Food Fetched from DB.");
			responseStructure.setData(foodDao.fetchFoodById(foodId));
			return new ResponseEntity<ResponseStructure<Food>>(responseStructure,HttpStatus.FOUND);
		} else {
			throw new FoodIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure1<Food>> fetchAllFood() {
		responseStructure1.setStatusCode(HttpStatus.FOUND.value());
		responseStructure1.setMessage("Successfully fetched all the Food from DataBase");
		responseStructure1.setData(foodDao.fetchAllFood());
		return new ResponseEntity<ResponseStructure1<Food>>(responseStructure1,HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Food>> updateFoodById(int oldFoodId, Food newFood) {
		Food food = foodDao.fetchFoodById(oldFoodId);
		if (food != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Food Updated in DB.");
			responseStructure.setData(foodDao.updateFoodById(oldFoodId, newFood));
			return new ResponseEntity<ResponseStructure<Food>>(responseStructure,HttpStatus.OK);
		} else {
			throw new FoodIdNotFound();
		}
	}

	public ResponseEntity<ResponseStructure<Food>> deletefoodById(int foodId) {
		Food food = foodDao.fetchFoodById(foodId);
		if (food != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully Food Deleted from DB.");
			responseStructure.setData(foodDao.deletefoodById(foodId));
			return new ResponseEntity<ResponseStructure<Food>>(responseStructure,HttpStatus.OK);
		} else {
			throw new FoodIdNotFound();
		}
	}

}
