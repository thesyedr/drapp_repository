package com.dr.app.clients;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.dr.app.repo.entity.Contacts;
import com.dr.app.repo.entity.Patient;

public class SelectParentContactsInsurance {

	public static void main(String[] args) {

		EntityManagerFactory  emf  = Persistence.createEntityManagerFactory("DrappService");
		System.out.println("Entity manager foactory created");
		EntityManager em = emf.createEntityManager();
		System.out.println("Entity Manager created...");
		
		TypedQuery<Patient> query = em.createQuery("SELECT p FROM Patient p", Patient.class);
		List<Patient> results = query.getResultList();
		System.out.println("-----------------------------");
		for(Patient patient : results){
			
			System.out.println("Patient id : "+patient.getPatientName() +"  , Email : "+patient.getContacts().getEmailId()+"  , Insurance Provider :  "+patient.getInsurance().getInsuranceProvider());
		}
		
		System.out.println("----------------------------");
		
		TypedQuery<Contacts> query2 = em.createQuery("SELECT c FROM Contacts c", Contacts.class);
		List<Contacts> results2 = query2.getResultList();
		for(Contacts contacts : results2){
			System.out.println("Patient Name: "+contacts.getPatient().getPatientName()+"  , Email : "+contacts.getEmailId()+"  , Insurance Provider :  "+contacts.getPatient().getInsurance().getInsuranceProvider());
		}
		
		
		em.close();
		emf.close();

				
		System.out.println("Connection Closed.");
		
	}

}
