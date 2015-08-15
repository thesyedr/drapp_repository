package com.dr.app.rest.responses;

import com.dr.app.repo.entity.Contacts;
import com.dr.app.repo.entity.Insurance;

public class PatientResponse extends DrResponse{

	private Integer patientId;
	private String patientName;
	private Contacts patientContact;
	private Insurance patientInsurance;
	
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public Contacts getPatientContact() {
		return patientContact;
	}
	public void setPatientContact(Contacts patientContact) {
		this.patientContact = patientContact;
	}
	public Insurance getPatientInsurance() {
		return patientInsurance;
	}
	public void setPatientInsurance(Insurance patientInsurance) {
		this.patientInsurance = patientInsurance;
	}
	
	
}
