package com.dr.app.repo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.dr.app.repo.entity.Contacts;

public interface ContactsRepository extends JpaRepository<Contacts, Integer>{
	
	/**
	 * 
	 * @param homePhone
	 * @param mobilePhone
	 * @return
	 */
	@Modifying
	@Query("update Contacts c set c.homePhone = ?1, c.mobilePhone = ?2 where c.contactId = ?3")
	public Integer updatePhoneNumbers(Integer homePhone,Integer mobilePhone,Integer contactId);
}
