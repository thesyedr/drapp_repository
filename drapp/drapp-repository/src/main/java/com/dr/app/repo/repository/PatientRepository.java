package com.dr.app.repo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dr.app.repo.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
