package com.dr.app.rest.webresourceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.dr.app.repo.entity.Contacts;
import com.dr.app.repo.entity.Insurance;
import com.dr.app.repo.entity.Patient;
import com.dr.app.rest.converters.PatientRequestConverters;
import com.dr.app.rest.requests.PatientEnrollementRequest;
import com.dr.app.rest.responses.DrResponse;
import com.dr.app.rest.responses.PatientResponse;
import com.dr.app.rest.responses.PatientsReponse;
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
		Contacts contacts = null;
		Insurance insurance = null;
		if(patientEnrollementRequest.getPatientContacts() != null){
			contacts = patientRequestConverters.getPatientContacts(patientEnrollementRequest);
		}
		if(patientEnrollementRequest.getInsuranceDetails() != null){
			insurance = patientRequestConverters.getPatientInsuranceDetails(patientEnrollementRequest);
		}
		
		int status = patientService.patientEnrollement(patient,contacts,insurance);
		DrResponse response = new DrResponse();
		if(status > 0){
			response.setStatus(200);
			response.setMessage("Patient Enrollement/Registration is  Succesfull ");
		}else {
			response.setStatus(400);
			response.setMessage("Patient Enrollement/Registration Failed");
		}
		return Response.ok(response).build();
	}

	@Override
	public Response getPatientRecordById(String patientId) {
		
		Patient patientRecord = null;
		PatientResponse patientResponse = new PatientResponse();
		logger.info("Request processing start for patientId : "+patientId);
		Integer patientID = Integer.parseInt(patientId);
		if(patientID != null){
			patientRecord = patientService.getPatientRecordById(patientID);
			if(patientRecord != null ){
				logger.info("recieved record for patient id : "+patientID);
				patientResponse.setStatus(200);
				patientResponse.setMessage("Patient Record fetched successfully");
				patientResponse.setPatientId(patientRecord.getPatientId());
				patientResponse.setPatientName(patientRecord.getPatientName());
				patientResponse.setPatientContact(patientRecord.getContacts());
				patientRecord.getContacts().setPatient(null);
				patientResponse.setPatientInsurance(patientRecord.getInsurance());
				patientRecord.getInsurance().setPatient(null);
			
			}else{
				logger.info("record not available for patient:"+patientID);
				patientResponse.setStatus(401);
				patientResponse.setMessage("Patient Record Not found");
			}
		}else{
			patientResponse.setStatus(400);
			patientResponse.setMessage("Patient Record fetched failed");
		}
		logger.info("Sending Response for patient id : "+patientId);
		return Response.ok(patientResponse).build();
	}

	@Override
	public Response getAllPatients() {
		logger.info("Request processing started for getting all the available patients");
		List<Patient> patientsList = patientService.getAllAvailablePatients();
		List<PatientResponse> patientResposneList = new ArrayList<PatientResponse>();
		PatientsReponse patientsReponse = new PatientsReponse();
		for(Patient patient : patientsList){
			PatientResponse patientResponse = new PatientResponse();
			patientResponse.setPatientId(patient.getPatientId());
			patientResponse.setPatientName(patient.getPatientName());
			patientResponse.setPatientContact(patient.getContacts());
			patient.getContacts().setPatient(null);
			patientResponse.setPatientInsurance(patient.getInsurance());
			patient.getInsurance().setPatient(null);
			patientResposneList.add(patientResponse);
		}
		if(patientResposneList.size() > 0){
			logger.info("One or more Patients Records Recieved");
			patientsReponse.setStatus(200);
			patientsReponse.setMessage("Patients Record Recieved");
			patientsReponse.setPatients(patientResposneList);
		}else{
			logger.info("Patients records are not abailable");
			patientsReponse.setStatus(401);
			patientsReponse.setMessage("Patients records are not abailable");
		}
		logger.info("Sending the Response for available patients");
		return Response.ok(patientsReponse).build();
	}

	@Override
	public Response getPatientRecordByName(String patientName) {
		
		logger.info("Request processing started for getting patient record by name for patient : "+patientName);
		Patient patient = patientService.getPatientDetailsByName(patientName);
		PatientResponse patientResponse = new PatientResponse();
		if(patient != null){
			patientResponse.setStatus(200);
			patientResponse.setMessage("Patient Record Recieved");
			patientResponse.setPatientId(patient.getPatientId());
			patientResponse.setPatientName(patient.getPatientName());
			patientResponse.setPatientContact(patient.getContacts());
			patientResponse.setPatientInsurance(patient.getInsurance());
		}else{
			patientResponse.setStatus(401);
			patientResponse.setMessage("Patient record not available");
		}
		logger.info("Sending patient record response for patient by name service for patient : "+patientName);
		return Response.ok(patientResponse).build();
	}
}
