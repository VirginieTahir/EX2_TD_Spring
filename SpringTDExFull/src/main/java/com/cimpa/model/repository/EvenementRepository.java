package com.cimpa.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.cimpa.model.Evenement;

public interface EvenementRepository extends CrudRepository<Evenement, Integer> {

}
