package com.triarq.obuzz.patient.models.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.triarq.obuzz.patient.models.Patients;

@Repository
public interface PatientRepository extends CrudRepository<Patients, String> {

	
}
