package com.dr.app.rest.webresourceImpl;

import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.dr.app.repo.entity.Patient;
import com.dr.app.rest.converters.PatientRequestConverters;
import com.dr.app.rest.requests.PatientEnrollementRequest;
import com.dr.app.rest.responses.DrResponse;
import com.dr.app.rest.webresource.PatientResource;
import com.dr.app.service.PatientService;

public class PatientEnrollementResourceImpl implements PatientResource{

	@Autowired
	private PatientService patientService;
	
	@Autowired
	private PatientRequestConverters patientRequestConverters;
	
	private static Logger logger = Logger.getLogger(PatientEnrollementResourceImpl.class);
	@Override
	public Response patientEnrollement(PatientEnrollementRequest patientEnrollementRequest) {
		
		logger.info("Start of PatientEnrollement service");
		Patient patient = patientRequestConverters.getPatientFromPatientWebRequest(patientEnrollementRequest);
		int status = patientService.patientEnrollement(patient);
		DrResponse response = new DrResponse();
		if(status > 0){
			response.setStatus(200);
			response.setMessage("Patient Enrollement Succesfull");
		}else {
			response.setStatus(400);
			response.setMessage("Patient Enrollement Failed");
		}
		return Response.ok(response).build();
	}

}
