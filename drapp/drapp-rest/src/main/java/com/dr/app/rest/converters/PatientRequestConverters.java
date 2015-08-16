package com.dr.app.rest.converters;

import org.jboss.logging.Logger;

import com.dr.app.repo.entity.Contacts;
import com.dr.app.repo.entity.Insurance;
import com.dr.app.repo.entity.Patient;
import com.dr.app.rest.requests.PatientEnrollementRequest;

public class PatientRequestConverters {
	
	private final static Logger logger = Logger.getLogger(PatientRequestConverters.class);
	
	/**
	 * constructs the Patient from request
	 * @param patientEnrollementRequest
	 * @return
	 */
	public Patient getPatientFromPatientWebRequest(PatientEnrollementRequest patientEnrollementRequest){
		logger.info("Constructing the Patient Object from PatientEnrollementRequest");
		Patient patient = new Patient();
		if(patientEnrollementRequest.getPatientId() != null){
			patient.setPatientId(patientEnrollementRequest.getPatientId());
		}
		patient.setPatientName(patientEnrollementRequest.getPatientName());
		logger.info("Patient Object constructed from PatientEnrollementRequest ");
		return patient;
	}
	
	/**
	 * Constructs Contacts from PatientEnrollementRequest
	 * @param patientEnrollementRequest
	 * @return
	 */
	public Contacts getPatientContacts(PatientEnrollementRequest patientEnrollementRequest){
		
		logger.info("Building the Contacts Object from PatientEnrollementRequest");
		Contacts contacts = new Contacts();
		if(patientEnrollementRequest.getPatientContacts().getContactId() != null){
			contacts.setContactId(patientEnrollementRequest.getPatientContacts().getContactId());
		}
		contacts.setEmailId(patientEnrollementRequest.getPatientContacts().getEmailId());
		contacts.setHomePhone(patientEnrollementRequest.getPatientContacts().getHomePhone());
		contacts.setMobilePhone(patientEnrollementRequest.getPatientContacts().getMobilePhone());
		contacts.setStreet(patientEnrollementRequest.getPatientContacts().getStreet());
		contacts.setCity(patientEnrollementRequest.getPatientContacts().getCity());
		contacts.setState(patientEnrollementRequest.getPatientContacts().getState());
		contacts.setPatientCaregiver(patientEnrollementRequest.getPatientContacts().getPatientCaregiver());
		contacts.setContactType(patientEnrollementRequest.getPatientContacts().getContactType());
		logger.info("Contacts Object Constructed from PatientEnrollementRequest");
		return contacts;
	}
	
	/**
	 * Constructs Insurance from PatientEnrollementRequest
	 * @param patientEnrollementRequest
	 * @return
	 */
	public Insurance getPatientInsuranceDetails(PatientEnrollementRequest patientEnrollementRequest){
		logger.info("Building the Insurance Object from PatientEnrollementRequest");
		Insurance insurance = new Insurance();
		if(patientEnrollementRequest.getInsuranceDetails().getInsuranceId() != null){
			insurance.setInsuranceId(patientEnrollementRequest.getInsuranceDetails().getInsuranceId());
		}
		insurance.setDateofBirth(patientEnrollementRequest.getInsuranceDetails().getDateofBirth());
		insurance.setInsuranceNumber(patientEnrollementRequest.getInsuranceDetails().getInsuranceNumber());
		insurance.setInsuranceGroup(patientEnrollementRequest.getInsuranceDetails().getInsuranceGroup());
		insurance.setInsuranceProvider(patientEnrollementRequest.getInsuranceDetails().getInsuranceProvider());
		insurance.setEmployerName(patientEnrollementRequest.getInsuranceDetails().getEmployerName());
		insurance.setEmployerAddress(patientEnrollementRequest.getInsuranceDetails().getEmployerAddress());
		logger.info("Contacts Object Constructed from PatientEnrollementRequest");
		return insurance;
	}

}
