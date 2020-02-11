package com.triarq.obuzz.patient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.triarq.obuzz.patient.models.Patients;
import com.triarq.obuzz.patient.models.repository.PatientRepository;

@RestController
public class PatientController {

	@Autowired
	PatientRepository repo;

	@PostMapping("/patients")
	@PreAuthorize("hasAuthority('create_profile')")
	public Patients savePatient(@RequestBody Patients patient) {
		patient.setId("123456854316");
		return patient;
	}

	@GetMapping("/patients")
	@PreAuthorize("hasRole('ROLE_operator')")
	public List<Patients> getpatient() {
		return (List<Patients>) repo.findAll();
	}

	@GetMapping("/patients/{id}")
	@PreAuthorize("hasAuthority('read_profile')")
	public Patients getpatientBYID(@PathVariable("id") String id) {
		return repo.findByid(id);
	}

	@PutMapping("/patient/edit")
	@PreAuthorize("hasRole('ROLE_operator')")
	// @PreAuthorize("hasAuthority('update_profile')")
	public Patients editPatient(@RequestBody Patients patient) {
		return patient;
	}

	@DeleteMapping("/patient/{id})")
	// @PreAuthorize("hasAuthority('delete_profile')")
	@PreAuthorize("hasRole('ROLE_admin')")
	public String deletePatient(@PathVariable("id") String id) {
		return "delete patent"+id;
	}
}
