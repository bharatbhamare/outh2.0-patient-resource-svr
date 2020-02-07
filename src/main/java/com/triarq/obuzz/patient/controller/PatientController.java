package com.triarq.obuzz.patient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.triarq.obuzz.patient.models.Patients;
import com.triarq.obuzz.patient.models.repository.PatientRepository;

@RestController
public class PatientController {

	@Autowired
	PatientRepository repo;

	@GetMapping("/patient" )	
	@PreAuthorize("hasAuthority('read_profile')")
	public List<Patients> getpatient() {
		return (List<Patients>) repo.findAll();
	}

	@GetMapping("/patient/save")
	@PreAuthorize("hasAuthority('create_profile')")
	public String savePatient() {
		return "save patient";
	}

	@GetMapping("/patient/edit")
	@PreAuthorize("hasAuthority('update_profile')")
	public String  editPatient() {
		return "edit patient";
	}
	
	
	@GetMapping("/patient/delete")
	@PreAuthorize("hasAuthority('delete_profile')")
	public String deletePatient() {
		return "delete patent";
	}
}
