package com.dr.app.rest.webresource;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dr.app.rest.requests.PatientEnrollementRequest;

@Path("/")
@WebService(name="patientService")
public interface PatientResource {
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	@Path("/enroll")
	public Response patientEnrollement(PatientEnrollementRequest patientEnrollementRequest);

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/patient/id/{patientId}")
	public Response getPatientRecordById(@PathParam("patientId") String patientId);
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/patients")
	public Response getAllPatients();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/patient/name/{patientName}")
	public Response getPatientRecordByName(@PathParam("patientName") String patientName);
}
