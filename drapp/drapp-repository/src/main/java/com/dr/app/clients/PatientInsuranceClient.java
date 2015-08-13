package com.dr.app.clients;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.dr.app.repo.entity.Insurance;
import com.dr.app.repo.entity.Patient;

public class PatientInsuranceClient {

	public static void main(String[] args) {

		EntityManagerFactory  emf  = Persistence.createEntityManagerFactory("DrappService");
		System.out.println("Entity manager foactory created");
		EntityManager em = emf.createEntityManager();
		System.out.println("Entity Manager created...");
		
		Insurance insurance = new Insurance();
		insurance.setInsuranceNumber(1023);
		insurance.setInsuranceProvider("ICICI");
		insurance.setInsuranceGroup("General");
		insurance.setEmployerName("Innominds");
		insurance.setEmployerAddress("Hyderabad");
		insurance.setDateofBirth("10/09/2000");
		
		Patient patient = new Patient();
		patient.setPatientName("Hero3");
		
		//patient.setInsurance(insurance);
		//insurance.setPatient(patient);
		
		em.getTransaction().begin();
		System.out.println("Transaction Begined");
		em.persist(insurance);
		em.persist(patient);
		em.getTransaction().commit();
		System.out.println("Transaction Commited");

		em.close();
		emf.close();

		
		System.out.println("Connection Closed.");

		
	}

}
