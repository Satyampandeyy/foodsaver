package com.food.saver.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.saver.models.User;
import com.food.saver.repo.UserRepository;
import com.food.saver.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public String authenticateUser(User userinput) throws Exception {
		log.info("Trying to authenticate user");
		User user = userRepository.findByEmail(userinput.getEmail());		
		if(user!=null && user.getPassword().equals(userinput.getPassword())) {
			log.info("Trying to authenticate"+user.getPassword());
			return "Login Successful";
		} else {
			throw new Exception("Invalid Credentials");
		}
	}
	

}
