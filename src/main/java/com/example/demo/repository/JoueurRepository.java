package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Joueur;

public interface JoueurRepository extends CrudRepository<Joueur, Long> {

	

	List<Joueur> findByVieGreaterThanAndUsernameNot(int i,String username);

}
