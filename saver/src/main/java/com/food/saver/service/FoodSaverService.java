package com.food.saver.service;


import com.food.saver.models.Food;

public interface FoodSaverService {

	Food saveFoodWastageData(Food food, String token) throws Exception;
}
