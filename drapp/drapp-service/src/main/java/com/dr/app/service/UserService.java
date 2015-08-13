package com.dr.app.service;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dr.app.repo.entity.User;
import com.dr.app.repo.repository.UserRepository;

@Service("userService")
@Transactional(readOnly = true)
public class UserService {
	
	public static Logger logger = Logger.getLogger(UserService.class);
	@Autowired
	private UserRepository userRepository;
	
	@Transactional(readOnly=false)
	public int register(User user){
		
		int status = 0;
		logger.info("Start of register methodd userId : "+user.getUserName());
		logger.info("checking the user existsing the database or not "+user.getUserName());
		String userName = userRepository.checkUserExists(user.getUserName());
		if(userName == null){
			user = userRepository.save(user);
			logger.info("After user Repository call userId  :"+user.getUserId());
			status = user.getUserId();

		}else{
			status = 0;
			logger.info("User Already exists with the username : "+user.getUserName());
		}
		return status;
		
	}
}
