package com.food.saver.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.food.saver.models.User;

public interface UserRepository extends MongoRepository<User, String>{

	User findByEmail(String email);
}
