package com.example.demo.model;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@JsonIgnoreProperties({"joueur1","joueur2","gagnant"})
public class Match {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	 @OneToMany(mappedBy = "match")
	    private Set<MatchJoueur> joueur;
	
	
	public Set<MatchJoueur> getJoueur() {
		return joueur;
	}
	public void setJoueur(Set<MatchJoueur> joueur) {
		this.joueur = joueur;
	}
	@ManyToOne
	private Joueur gagnant;
	private Date date;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Joueur getGagnant() {
		return gagnant;
	}
	public void setGagnant(Joueur gagnant) {
		this.gagnant = gagnant;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	

}
