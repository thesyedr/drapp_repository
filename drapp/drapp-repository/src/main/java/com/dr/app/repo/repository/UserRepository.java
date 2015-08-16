package com.dr.app.repo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dr.app.repo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	
	public String checkUserExists(String userName);

}
