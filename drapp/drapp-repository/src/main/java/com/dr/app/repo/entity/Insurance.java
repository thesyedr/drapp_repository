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

@Cacheable(true)
@Entity
public class Insurance implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer insuranceId;
	private String dateofBirth;
	private String insuranceProvider;
	private Integer insuranceNumber;
	private String insuranceGroup;
	private String employerName;
	private String employerAddress;
	
	//@OneToOne(mappedBy="insurance",optional=false,cascade=CascadeType.ALL,targetEntity=Patient.class)
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="patientId", unique=true, nullable=false, updatable=false)
	private Patient patient;
	
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Integer getInsuranceId() {
		return insuranceId;
	}
	public void setInsuranceId(Integer insuranceId) {
		this.insuranceId = insuranceId;
	}
	public String getDateofBirth() {
		return dateofBirth;
	}
	public void setDateofBirth(String dateofBirth) {
		this.dateofBirth = dateofBirth;
	}
	public String getInsuranceProvider() {
		return insuranceProvider;
	}
	public void setInsuranceProvider(String insuranceProvider) {
		this.insuranceProvider = insuranceProvider;
	}
	public Integer getInsuranceNumber() {
		return insuranceNumber;
	}
	public void setInsuranceNumber(Integer insuranceNumber) {
		this.insuranceNumber = insuranceNumber;
	}
	public String getInsuranceGroup() {
		return insuranceGroup;
	}
	public void setInsuranceGroup(String insuranceGroup) {
		this.insuranceGroup = insuranceGroup;
	}
	public String getEmployerName() {
		return employerName;
	}
	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}
	public String getEmployerAddress() {
		return employerAddress;
	}
	public void setEmployerAddress(String employerAddress) {
		this.employerAddress = employerAddress;
	}

}
