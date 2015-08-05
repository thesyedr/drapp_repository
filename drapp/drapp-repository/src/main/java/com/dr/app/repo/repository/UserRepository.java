package com.dr.app.repo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dr.app.repo.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{

}
