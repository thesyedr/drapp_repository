package com.dr.app.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dr.app.repo.entity.Contacts;
import com.dr.app.repo.entity.Insurance;
import com.dr.app.repo.entity.Patient;
import com.dr.app.repo.repository.PatientRepositoryImpl;
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
		contacts.setPatient(patient);
		insurance.setPatient(patient);
		//Patient patientResponse = patientRepository.save(patient);
		int status = patientRepository.savePatientDetails(patient);
		if(status > 0){
		//if(patientResponse != null){
			logger.info("Patient enrollement success for patient name : "+patient.getPatientName());
			return 200;
		}
		logger.info("Patient enrollement failed for patient name : "+patient.getPatientName());
		return 0;
	}

}
