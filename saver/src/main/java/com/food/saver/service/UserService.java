package com.food.saver.service;

import com.food.saver.models.User;

public interface UserService {

	String authenticateUser(User user) throws Exception;

}
