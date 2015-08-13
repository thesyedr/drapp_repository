package com.dr.app.rest.converters;

import com.dr.app.repo.entity.Patient;
import com.dr.app.rest.requests.PatientEnrollementRequest;

public class PatientRequestConverters {
	
	public Patient getPatientFromPatientWebRequest(PatientEnrollementRequest patientEnrollementRequest){
		
		Patient patient = new Patient();
		patient.setPatientName(patientEnrollementRequest.getPatientName());
		return patient;
	}

}
