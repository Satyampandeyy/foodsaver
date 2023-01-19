package com.food.saver.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.food.saver.models.Food;
import com.food.saver.repo.FoodRepository;
import com.food.saver.service.FoodSaverService;
@Service
public class FoodSaverServiceImpl implements FoodSaverService {

	@Autowired
	FoodRepository foodRepository;
	
	@Value("${foodsaver.token}")
	private String verifyToken;
	
	@Override
	public Food saveFoodWastageData(Food food, String token) throws Exception {
		if(token.equals(verifyToken)) {
			food.setFoodWastedDate(new SimpleDateFormat("YYYY-MMM-dd").format(new Date()));
			food.setNumberOfPeopleCanFed((int)(food.getFoodWasted()/food.singlePersonConsumption));
			foodRepository.save(food);
			return food;
		}else {
			throw new Exception("Invalid credential");
		}
		
	}

}
