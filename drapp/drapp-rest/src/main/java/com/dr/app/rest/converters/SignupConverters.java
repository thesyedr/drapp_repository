package com.dr.app.rest.converters;

import com.dr.app.repo.entity.Staff;
import com.dr.app.repo.entity.User;
import com.dr.app.rest.requests.SignupRequest;

public class SignupConverters {
	
	
	public static User convertSignupRequestToUserEntity(SignupRequest signupRequest){
		
		User user = new User();
		user.setUserName(signupRequest.getUserName());
		user.setPassword(signupRequest.getPassword());
		return user;
		
	}
	
	public static Staff convertSignupRequestToStaffEntity(SignupRequest signupRequest){
		
		Staff staff = new Staff();
		staff.setUserName(signupRequest.getUserName());
		staff.setPassword(signupRequest.getPassword());
		staff.setStaffId(signupRequest.getStaffId());
		return staff;
		
	}

}
