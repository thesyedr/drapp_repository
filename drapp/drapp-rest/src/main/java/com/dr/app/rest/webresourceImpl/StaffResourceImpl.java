package com.dr.app.rest.webresourceImpl;

import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.dr.app.exceptions.DrException;
import com.dr.app.exceptions.InvalidStaffException;
import com.dr.app.exceptions.StaffEnrollementException;
import com.dr.app.repo.entity.Staff;
import com.dr.app.repo.entity.User;
import com.dr.app.rest.converters.SignupConverters;
import com.dr.app.rest.requests.SignInRequest;
import com.dr.app.rest.requests.SignupRequest;
import com.dr.app.rest.responses.DrResponse;
import com.dr.app.rest.webresource.StaffResource;
import com.dr.app.service.StaffService;
import com.dr.app.service.UserService;

public class StaffResourceImpl implements StaffResource {
	
	@Autowired
	private StaffService staffService;
	private static Logger logger = Logger.getLogger(StaffResourceImpl.class);

	@Override
	public Response staffEnrollement(SignupRequest signupRequest) {
		
		DrResponse response = new DrResponse();
		logger.info("Start of doEnrollement Service");
		logger.info("checking the user exists with the given id or not for username : "+signupRequest.getUserName());
		Staff staff = SignupConverters.convertSignupRequestToStaffEntity(signupRequest);
		logger.debug("SignupRequest converted to User entity");
		logger.info("calling user registration service");
		try {
			staff = staffService.staffEnrollement(staff);
			logger.info("Resposne recieved for user registartion service : ");
			
			if(staff != null){
				response.setMessage("success");
				response.setStatus(200);
				logger.info("sending success resposne back to client");
			}else{
				response.setMessage("failed");
				response.setStatus(400);
				logger.info("sending failed response back to client");
			}
		
		} catch (StaffEnrollementException e) {
			response.setMessage("failed");
			response.setStatus(400);
			logger.info("sending failed response back to client");
		} catch(DrException de){
			response.setMessage("failed");
			response.setStatus(400);
			logger.info("Dr Exception occured");
		}
		return Response.ok(response).build();
	}

	@Override
	public Response staffAuthentication(SignInRequest signInRequest) {
		
		DrResponse response = new DrResponse();
		try {
			Staff staff = staffService.authenticateStaff(signInRequest.getUserName(), signInRequest.getPassword());
			response.setMessage("success");
			response.setStatus(200);
			logger.info("sending success resposne back to client");
			
		} catch (InvalidStaffException e) {
			response.setMessage("failed");
			response.setStatus(400);
			logger.info("sending failed response back to client");
		}
		return Response.ok(response).build();
	}

}
