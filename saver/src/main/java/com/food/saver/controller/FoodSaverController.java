package com.food.saver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import com.food.saver.service.UserService;

import com.food.saver.models.Food;
import com.food.saver.models.Response;
import com.food.saver.models.User;
import com.food.saver.service.FoodSaverService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin("*")
public class FoodSaverController {
	
	@Autowired
	private FoodSaverService foodSaverService;
	
	@Autowired
	private UserService userService;
	
	@Value("${foodsaver.token}")
	private String verifyToken;

	@PostMapping(value="/save_food_wastage", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Response> saveFoodWastageData(@RequestHeader("token") String token,@RequestBody Food food){
		log.info(Double.toString(food.getFoodWasted()));
		log.info("Token: "+token);
		Response response = new Response();
		try {
			response.setFood(foodSaverService.saveFoodWastageData(food,token));
			response.setMessage("Data Saved Successfully");
			return new ResponseEntity<Response>(response,HttpStatus.CREATED);
		}catch(Exception ex) {
			response.setMessage(ex.getMessage());
			return new ResponseEntity<Response>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(value="/authenticate", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Response> authenticateUser(@RequestBody User user) throws Exception {
		log.info("Entering inside autenticateUserMethod");
		Response response=new Response();
		try {
		response.setMessage(userService.authenticateUser(user));
		response.setToken(verifyToken);
		log.info("Logged in successfully");
		return new ResponseEntity<Response>(response,HttpStatus.OK);
		}catch(Exception ex) {
			response.setMessage(ex.getMessage());
			log.info(ex.getMessage());
			return new ResponseEntity<Response>(response,HttpStatus.BAD_REQUEST);
		}
		
	}

}
