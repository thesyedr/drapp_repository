package com.dr.app.rest.webresource;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dr.app.rest.requests.SignupRequest;

@Path("/")
@WebService(name="signupService")
public interface SignupResource {
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	@Path("/enroll")
	public Response doEnrollement(SignupRequest signupRequest);
}
