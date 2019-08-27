package com.triarq.obuzz.patient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.triarq.obuzz.patient.models.Patients;
import com.triarq.obuzz.patient.models.repository.PatientRepository;

@RestController
public class PatientController {

	@Autowired
	PatientRepository repo;

	
	@GetMapping("/patient")
	public List<Patients> getpatient()
	{
		return (List<Patients>) repo.findAll();
	}
}
