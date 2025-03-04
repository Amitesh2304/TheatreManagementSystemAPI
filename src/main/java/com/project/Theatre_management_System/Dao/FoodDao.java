package com.project.Theatre_management_System.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.Theatre_management_System.Dto.Food;
import com.project.Theatre_management_System.Repo.FoodRepo;

@Repository
public class FoodDao {

	@Autowired
	FoodRepo foodRepo;
	
	public Food saveFood(Food food) {
		return foodRepo.save(food);
	}
	
	public Food fetchFoodById(int foodId) {
		Optional<Food> dbFood =  foodRepo.findById(foodId);
		if(dbFood.isPresent()) {
			return dbFood.get();
		}else {
			return null;
		}
	}
	
	public List<Food> fetchAllFood(){
		return foodRepo.findAll();
	}
	
	public Food updateFoodById(int oldFoodId, Food newFood) {
		newFood.setFoodId(oldFoodId);
		return foodRepo.save(newFood);
	}
	
	public Food deletefoodById(int foodId) {
		Food food = fetchFoodById(foodId);
		 foodRepo.delete(food);
		 return food;
	}
}
