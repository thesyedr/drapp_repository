package com.dr.app.repo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Staff implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer staffId;
	
	@Size(min = 1, message = "Name must not be empty!")
	private String userName;
	@Size(min = 1, message = "Password must not be empty!")
	private String password;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getStaffId() {
		return staffId;
	}
	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}
	
}
