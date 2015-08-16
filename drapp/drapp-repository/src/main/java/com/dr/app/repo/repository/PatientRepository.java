package com.dr.app.repo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dr.app.repo.entity.Patient;

@Repository("patientRepository")
public interface PatientRepository extends JpaRepository<Patient, Integer> {
	
	public Patient patientName(String patientName);
}
