package com.dr.app.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.dr.app.repo.entity.Patient;
import com.dr.app.repo.repository.PatientRepository;

public class PatientService {
	
	private static final Logger logger = Logger.getLogger(PatientService.class);
	@Autowired
	private PatientRepository patientRepository;
	
	
	public int patientEnrollement(Patient patient){
		
		logger.info("start of patient enrollement with patient name:"+patient.getPatientName());
		Patient patientResponse = patientRepository.save(patient);
		if(patientResponse != null){
			logger.info("Patient enrollement success for patient name : "+patient.getPatientName());
			return 200;
		}
		logger.info("Patient enrollement failed for patient name : "+patient.getPatientName());
		return 0;
	}

}
