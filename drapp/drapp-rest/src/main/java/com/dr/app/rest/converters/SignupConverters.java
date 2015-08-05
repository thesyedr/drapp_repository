package com.dr.app.rest.converters;

import com.dr.app.repo.entity.User;
import com.dr.app.rest.requests.SignupRequest;

public class SignupConverters {
	
	
	public static User convertSignupRequestToUserEntity(SignupRequest signupRequest){
		
		User user = new User();
		user.setUserName(signupRequest.getUsername());
		user.setPassword(signupRequest.getPassword());
		return user;
		
	}

}
