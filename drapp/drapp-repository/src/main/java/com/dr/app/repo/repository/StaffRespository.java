package com.dr.app.repo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dr.app.repo.entity.Staff;

public interface StaffRespository extends JpaRepository<Staff, Integer>{

	public Staff userNameAndPassword(String userName,String password);
}
