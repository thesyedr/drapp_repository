package com.dr.app.repo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class GenericRepository<T> {
	
	@PersistenceContext
    protected EntityManager entityManager;
	
	public T merge(T t){
		return entityManager.merge(t);
	}
	
	public void remove(T t){
		entityManager.remove(t);
	}

}
