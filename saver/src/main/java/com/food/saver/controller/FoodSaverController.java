package com.food.saver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.food.saver.models.Food;
import com.food.saver.models.Response;
import com.food.saver.service.FoodSaverService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin("*")
public class FoodSaverController {
	
	@Autowired
	private FoodSaverService foodSaverService;

	@PostMapping(value="/save_food_wastage", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Response> saveFoodWastageData(@RequestBody Food food){
		log.info(Double.toString(food.getFoodWasted()));
		Response response = new Response();
		try {
			response.setFood(foodSaverService.saveFoodWastageData(food));
			response.setMessage("Data Saved Successfully");
			return new ResponseEntity<Response>(response,HttpStatus.CREATED);
		}catch(Exception ex) {
			response.setMessage("Some error occurred.Please try again");
			return new ResponseEntity<Response>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
