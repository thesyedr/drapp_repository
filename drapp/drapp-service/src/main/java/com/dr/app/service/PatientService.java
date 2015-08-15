package com.dr.app.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dr.app.repo.entity.Contacts;
import com.dr.app.repo.entity.Insurance;
import com.dr.app.repo.entity.Patient;
import com.dr.app.repo.repository.PatientRepo;
import com.dr.app.repo.repository.PatientRepositoryImpl;
import com.dr.app.repo.repository.PatientRepository;


@Service("patientService")
@Transactional
public class PatientService {
	
	private static final Logger logger = Logger.getLogger(PatientService.class);
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private PatientRepo patientRepo;
	
	@Transactional(readOnly = false)
	public int patientEnrollement(Patient patient,Contacts contacts,Insurance insurance){
		
		logger.info("start of patient enrollement with patient name:"+patient.getPatientName());
		patient.setContacts(contacts);
		patient.setInsurance(insurance);
		contacts.setPatient(patient);
		insurance.setPatient(patient);
		Patient patientResponse = patientRepository.save(patient);
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

}
