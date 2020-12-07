package com.cimpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cimpa.model.Employe;
import com.cimpa.model.repository.EmployeRepository;

@Service
@Transactional
public class EmployeController {
	@Autowired
	private EmployeRepository empRepo;
	
	//Create /update
	public void save(Employe emp) {
		empRepo.save(emp);
	}
	//Read
		public List<Employe> listerEmp() {
			return (List<Employe>) empRepo.findAll();
		}
	//find byID
	public Employe get(int id) {
		return empRepo.findById(id).get();
	}
	//delete ByID
	public void delete(int id) {
		empRepo.deleteById(id);
	}

}
