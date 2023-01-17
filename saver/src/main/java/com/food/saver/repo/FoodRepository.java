package com.food.saver.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.food.saver.models.Food;

@Repository
public interface FoodRepository extends MongoRepository<Food, String>{

}
