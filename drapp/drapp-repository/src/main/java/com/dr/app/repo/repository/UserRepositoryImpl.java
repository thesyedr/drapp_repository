package com.dr.app.repo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.dr.app.repo.entity.User;

public class UserRepositoryImpl implements UserRepository{
	
	@PersistenceContext
    protected EntityManager entityManager;

	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	public void deleteInBatch(Iterable<User> arg0) {
		// TODO Auto-generated method stub
		
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> findAll(Iterable<Integer> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public void flush() {
		// TODO Auto-generated method stub
		
	}

	public <S extends User> List<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public User saveAndFlush(User arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Page<User> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void delete(Integer arg0) {
		// TODO Auto-generated method stub
		
	}

	public void delete(User arg0) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Iterable<? extends User> arg0) {
		// TODO Auto-generated method stub
		
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	public boolean exists(Integer arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public User findOne(Integer arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends User> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public String checkUserExists(String userName) {
		Query query = entityManager.createQuery("SELECT u.userName FROM User AS u WHERE u.userName=:userName");
		query.setParameter("userName", userName);
		String result = (String) query.getSingleResult();
		System.out.println("result of checkUserExists : "+result);
		return result;
	}
	
	

}
