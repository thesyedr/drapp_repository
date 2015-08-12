package com.dr.app.rest.webresourceImpl;

import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.dr.app.repo.entity.User;
import com.dr.app.rest.converters.SignupConverters;
import com.dr.app.rest.requests.SignupRequest;
import com.dr.app.rest.responses.DrResponse;
import com.dr.app.rest.webresource.SignupResource;
import com.dr.app.service.UserService;

public class SignupResourceImpl implements SignupResource{

	@Autowired
	private UserService userService;
	
	private static Logger logger = Logger.getLogger(SignupResourceImpl.class);
	
	public Response doEnrollement(SignupRequest signupRequest) {

		logger.info("Start of doEnrollement Service");
		logger.info("checking the user exists with the given id or not for username : "+signupRequest.getUsername());
		User user = SignupConverters.convertSignupRequestToUserEntity(signupRequest);
		logger.debug("SignupRequest converted to User entity");
		logger.info("calling user registration service");
		int status = userService.register(user);
		logger.info("Resposne recieved for user registartion service : "+status);
		DrResponse response = new DrResponse();
		if(status > 0){
			response.setMessage("success");
			response.setStatus(200);
			logger.info("sending success resposne back to client");
		}else{
			response.setMessage("failed");
			response.setStatus(400);
			logger.info("sending failed response back to client");
		}
		return Response.ok(response).build();
	}

}
