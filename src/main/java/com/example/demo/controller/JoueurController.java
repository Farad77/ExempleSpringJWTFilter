package com.example.demo.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Joueur;
import com.example.demo.repository.JoueurRepository;

@RestController
public class JoueurController {

	
	@Autowired
	private JoueurRepository joueurRepository;
	
	@PostMapping("/joueurs")
	private Joueur create(@RequestBody Joueur j) {
		j.setForce(new Random().nextInt(1000));
		j.setVie(new Random().nextInt(10000));
		joueurRepository.save(j);
		return j;
	}
	
	@GetMapping("/{username}/matchDispo")
	private List<Joueur> listeAllDispo(@PathVariable("username") String username) {
		
		return (List<Joueur>) joueurRepository.findByVieGreaterThanAndUsernameNot(0,username) ;
		
	}
	
	@GetMapping("/joueurs")
	private List<Joueur> listeAll() {
		
		return (List<Joueur>) joueurRepository.findAll() ;
		
	}
}
