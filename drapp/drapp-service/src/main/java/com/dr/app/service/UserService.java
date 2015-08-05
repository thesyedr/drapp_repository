package com.dr.app.service;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.dr.app.repo.entity.User;
import com.dr.app.repo.repository.UserRepository;


public class UserService {
	
	public static Logger logger = Logger.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	public int register(User user){
		
		int status = 0;
		logger.info("Start of register methodd userId : "+user.getUserId());
		user = userRepository.save(user);
		logger.info("After user Repository call userId  :"+user.getUserId());
		status = user.getUserId();
		return status;
		
	}

}
