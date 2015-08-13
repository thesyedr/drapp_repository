package com.dr.app.rest.requests;

public class PatientEnrollementRequest {
	
	private String patientName;
	private Integer patientId;
	private PatientContactRequest patientContacts;
	private InsuranceWebRequest insuranceDetails;
	
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
	public PatientContactRequest getPatientContacts() {
		return patientContacts;
	}
	public void setPatientContacts(PatientContactRequest patientContacts) {
		this.patientContacts = patientContacts;
	}
	public InsuranceWebRequest getInsuranceDetails() {
		return insuranceDetails;
	}
	public void setInsuranceDetails(InsuranceWebRequest insuranceDetails) {
		this.insuranceDetails = insuranceDetails;
	}
	
	
}
