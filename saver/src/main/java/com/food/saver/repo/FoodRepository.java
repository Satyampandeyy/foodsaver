package com.food.saver.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.food.saver.models.Food;


public interface FoodRepository extends MongoRepository<Food, String>{

}
