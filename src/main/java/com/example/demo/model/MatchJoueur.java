package com.example.demo.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@IdClass(MatchJoueurId.class)
public class MatchJoueur {
 
    @Id
    @ManyToOne
    private Match match;
 
    @Id
    @Temporal(TemporalType.DATE)
    private Date date;
 
    @Id
    @ManyToOne
    private Joueur joueur;
 
 

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
		this.joueur.addMatch(this);
	}

	
 
}
