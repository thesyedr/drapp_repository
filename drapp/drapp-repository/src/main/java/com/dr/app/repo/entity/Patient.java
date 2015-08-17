package com.dr.app.repo.entity;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.NotEmpty;

@Cacheable(true)
@Entity
public class Patient implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue
	private Integer patientId;
	
	@NotEmpty
	private String patientName;
	
	/*@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="contactId", unique=true, nullable=false, updatable=false)*/
	@OneToOne(mappedBy="patient",optional=false,cascade=CascadeType.ALL,targetEntity=Contacts.class)
	private Contacts contacts;
	
	/*@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="insuranceId", unique=true, nullable=false, updatable=false)*/
	@OneToOne(mappedBy="patient",optional=false,cascade=CascadeType.ALL,targetEntity=Insurance.class)
	private Insurance insurance;
	
	public Insurance getInsurance() {
		return insurance;
	}
	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}
	public Contacts getContacts() {
		return contacts;
	}
	public void setContacts(Contacts contacts) {
		this.contacts = contacts;
	}
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
	
	
}
