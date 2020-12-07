package com.cimpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cimpa.model.DemandeConge;
import com.cimpa.model.repository.DemandeCongeRepository;


@Service
@Transactional
public class DemandeCongeController {
	@Autowired
	private DemandeCongeRepository demRepo;

	// Create /update
	public void save(DemandeConge dem) {
		demRepo.save(dem);
	}

	// Read
	public List<DemandeConge> listerDemC() {
		return (List<DemandeConge>) demRepo.findAll();
	}

	// find byID
	public DemandeConge get(int id) {
		return demRepo.findById(id).get();
	}

	// delete ByID
	public void delete(int id) {
		demRepo.deleteById(id);
	}
}
