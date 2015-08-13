package com.dr.app.repo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Contacts {
	
	@Id
	@GeneratedValue
	private Integer contactId;
	private String emailId;
	private Integer homePhone;
	private Integer mobilePhone;
	//private Integer patientId;
	private String patientCaregiver;
	private String street;
	private String state;
	private String city;
	private String zip;
	private String contactType;
	
	//@OneToOne(mappedBy="contacts",optional=false,cascade=CascadeType.ALL,targetEntity=Patient.class)
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="patientId", unique=true, nullable=false, updatable=false)
	private Patient patient;
	
		
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
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
	/*public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}*/
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
