package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

public class MatchJoueurId implements Serializable {

   private Match match;

   private Date date;

   private String joueur;


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

public String getJoueur() {
	return joueur;
}

public void setJoueur(String joueur) {
	this.joueur = joueur;
}





}