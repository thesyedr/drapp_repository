package com.dr.app.repo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dr.app.repo.entity.Patient;

@Repository("patientRepository")
public interface PatientRepository extends JpaRepository<Patient, Integer> {
	
	/**
	 * fetches the Patient based on patientName
	 * @param patientName
	 * @return
	 */
	public Patient patientName(String patientName);
}
