package com.cimpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cimpa.model.Evenement;
import com.cimpa.model.repository.EvenementRepository;

@Service
@Transactional
public class EvenementController {
	@Autowired
	private EvenementRepository evRepo;

	// Create /update
	public void save(Evenement ev) {
		evRepo.save(ev);
	}

	// Read
	public List<Evenement> listerEv() {
		return (List<Evenement>) evRepo.findAll();
	}

	// find byID
	public Evenement get(int id) {
		return evRepo.findById(id).get();
	}

	// delete ByID
	public void delete(int id) {
		evRepo.deleteById(id);
	}

}
