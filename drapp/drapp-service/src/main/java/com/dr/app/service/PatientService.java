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
	
	@Transactional(readOnly = false)
	public int patientEnrollement(Patient patient,Contacts contacts,Insurance insurance){
		
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
			patientResponse = patientRepository.save(patient);
		}else{
			patientResponse = patientRepository.save(patient);
		}
		
		if(patientResponse != null){
			logger.info("Patient enrollement success for patient name : "+patient.getPatientName());
			return 200;
		}
		logger.info("Patient enrollement failed for patient name : "+patient.getPatientName());
		return 0;
	}
	
	@Transactional(readOnly=true)
	public Patient getPatientRecordById(Integer patientId){
		logger.info("getPatientRecordById : "+patientId);
		Patient patient = patientRepository.findOne(patientId);
		logger.info("Patient object returned from getPatientRecordById : "+patient.toString());
		return patient;
	}
	
	@Transactional(readOnly=true)
	public List<Patient> getAllAvailablePatients(){
		logger.info("Fetching the available patient from the database");
		List<Patient> patientsList = patientRepository.findAll();
		logger.info("Returning patient records : "+patientsList.size());
		return patientsList;
	}
	
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
