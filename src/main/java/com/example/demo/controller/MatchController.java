package com.example.demo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Joueur;
import com.example.demo.model.Match;
import com.example.demo.model.MatchJoueur;
import com.example.demo.repository.JoueurRepository;
import com.example.demo.repository.MatchRepository;

@RestController
public class MatchController {
	
	@Autowired
	private JoueurRepository joueurRepository;
	
	@Autowired
	private MatchRepository matchRepository;
	
	@GetMapping("/{idJoueur1}/defier/{idJoueur2}")
	private Joueur matchBegin(@PathVariable("idJoueur1") Long idJoueur1,@PathVariable("idJoueur2") Long idJoueur2) {
		Joueur gagnant=null;
		Joueur joueur1=joueurRepository.findById(idJoueur1).get();
		Joueur joueur2=joueurRepository.findById(idJoueur2).get();
		Match m=new Match();
		m.setDate(new Date());
		MatchJoueur matchJoueur1=new MatchJoueur();
		matchJoueur1.setDate(m.getDate());
		matchJoueur1.setJoueur(joueur1);
		
		MatchJoueur matchJoueur2=new MatchJoueur();
		matchJoueur2.setDate(m.getDate());
		matchJoueur2.setJoueur(joueur2);
		
		
		matchJoueur1.setMatch(m);
		matchJoueur2.setMatch(m);
		
	
	
		
		if(joueur1.getForce()>joueur2.getForce()) {
			gagnant=joueur1;
			joueur2.perdVie(1);
		}
		else {
			gagnant=joueur2;
			joueur1.perdVie(1);
		}
		m.setGagnant(gagnant);
		m.getJoueur().add(matchJoueur1);
		m.getJoueur().add(matchJoueur2);
		matchRepository.save(m);
		
	
		return gagnant;
	}
	
	

}
