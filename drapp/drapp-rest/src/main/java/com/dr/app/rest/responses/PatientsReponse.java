package com.dr.app.rest.responses;

import java.util.ArrayList;
import java.util.List;

public class PatientsReponse extends DrResponse{
	
	List<PatientResponse> patients = new ArrayList<PatientResponse>();

	public List<PatientResponse> getPatients() {
		return patients;
	}

	public void setPatients(List<PatientResponse> patients) {
		this.patients = patients;
	}
	
	

}
