package com.dr.app.repo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.dr.app.repo.entity.Contacts;
import com.dr.app.repo.entity.Patient;

public class PatientRepositoryImpl {
	
	/*@PersistenceContext
    protected EntityManager entityManager;

	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	public void deleteInBatch(Iterable<Patient> arg0) {
		// TODO Auto-generated method stub
		
	}

	public List<Patient> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Patient> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Patient> findAll(Iterable<Integer> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public void flush() {
		// TODO Auto-generated method stub
		
	}

	public <S extends Patient> List<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Patient saveAndFlush(Patient arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Page<Patient> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void delete(Integer arg0) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Patient arg0) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Iterable<? extends Patient> arg0) {
		// TODO Auto-generated method stub
		
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	public boolean exists(Integer arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public Patient findOne(Integer arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends Patient> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int savePatientDetails(Patient patient){
		System.out.println("Start of savePatientDetails...");
		//patient.setContacts(contacts);
		//contacts.setPatient(patient);
		//entityManager.persist(contacts);
		entityManager.persist(patient);
		System.out.println("Insertion of patient and contact details...");
		return 1;
	}
*/
}
