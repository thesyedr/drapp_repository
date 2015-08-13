package com.dr.app.rest.requests;

public class PatientEnrollementRequest {
	
	private String patientName;
	private String emailId;
	private Integer homePhone;
	private Integer cellPhone;
	
	
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
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
	public Integer getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(Integer cellPhone) {
		this.cellPhone = cellPhone;
	}

	
}
