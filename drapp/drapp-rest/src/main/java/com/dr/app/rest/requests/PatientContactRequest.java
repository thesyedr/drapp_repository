package com.dr.app.rest.requests;

public class PatientContactRequest {
	
	private Integer contactId;
	private String emailId;
	private Integer homePhone;
	private Integer mobilePhone;
	private Integer patientId;
	private String patientCaregiver;
	private String street;
	private String state;
	private String city;
	private String zip;
	private String contactType;
	
	
	
	public Integer getContactId() {
		return contactId;
	}
	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Integer getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(Integer homePhone) {
		this.homePhone = homePhone;
	}
	public Integer getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(Integer mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	public String getPatientCaregiver() {
		return patientCaregiver;
	}
	public void setPatientCaregiver(String patientCaregiver) {
		this.patientCaregiver = patientCaregiver;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getContactType() {
		return contactType;
	}
	public void setContactType(String contactType) {
		this.contactType = contactType;
	}
	
	
	

}
