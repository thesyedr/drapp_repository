package com.dr.app.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dr.app.repo.entity.Contacts;
import com.dr.app.repo.entity.Insurance;
import com.dr.app.repo.entity.Patient;
import com.dr.app.repo.repository.PatientRepository;


@Service("patientService")
@Transactional(readOnly = true)
public class PatientService {
	
	private static final Logger logger = Logger.getLogger(PatientService.class);
	@Autowired
	private PatientRepository patientRepository;
	
	/**
	 * 
	 * @param patient
	 * @param contacts
	 * @param insurance
	 * @return
	 */
	@Transactional(readOnly = false)
	public Patient patientEnrollement(Patient patient,Contacts contacts,Insurance insurance){
		
		logger.info("start of patient enrollement with patient name:"+patient.getPatientName());
		patient.setContacts(contacts);
		patient.setInsurance(insurance);
		if(contacts != null){
			contacts.setPatient(patient);
		}
		if(insurance != null){
			insurance.setPatient(patient);
		}
		Patient patientResponse = null;
		if(patient.getPatientId() != null){
			logger.info("Updating the patient record for patient id : "+patient.getPatientId());
			patientResponse = patientRepository.save(patient);
			logger.info("Updated patient record for patient id : "+patient.getPatientId());
		}else{
			logger.info("Enrolling the new patient record....");
			patientResponse = patientRepository.save(patient);
			logger.info("Enrollement success for new patient record and generated patientId : "+patientResponse.getPatientId());
		}
		
		if(patientResponse != null){
			logger.info("Patient enrollement success for patient name : "+patient.getPatientName());
			return patientResponse;
		}
		logger.info("Patient enrollement failed for patient name : "+patient.getPatientName());
		return patientResponse;
	}
	
	/**
	 * 
	 * @param patientId
	 * @return
	 */
	@Transactional(readOnly=true)
	public Patient getPatientRecordById(Integer patientId){
		logger.info("getPatientRecordById : "+patientId);
		Patient patient = patientRepository.findOne(patientId);
		logger.info("Patient object returned from getPatientRecordById : "+patient.toString());
		return patient;
	}
	
	/**
	 * 
	 * @return
	 */
	@Transactional(readOnly=true)
	public List<Patient> getAllAvailablePatients(){
		logger.info("Fetching the available patient from the database");
		List<Patient> patientsList = patientRepository.findAll();
		logger.info("Returning patient records : "+patientsList.size());
		return patientsList;
	}
	
	/**
	 * 
	 * @param patientName
	 * @return
	 */
	@Transactional(readOnly=true)
	public Patient getPatientDetailsByName(String patientName){
		
		logger.info("Fetching the patient details by patientName for patient : "+patientName);
		Patient patient = patientRepository.patientName(patientName);
		logger.info("Patient object retrieved for patient : "+patientName);
		patient.getContacts().setPatient(null);
		patient.getInsurance().setPatient(null);
		return patient;
		
	}

}
