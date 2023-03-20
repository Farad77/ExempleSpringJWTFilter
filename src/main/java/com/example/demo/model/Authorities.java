package com.example.demo.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
@IdClass(CleCompose.class)
public class Authorities {
	
	@Id
	@OneToOne
	@JoinColumn(name="username")
	private Joueur joueur;
	
	@Id
	private String authority;

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	

}
class CleCompose  implements Serializable{
private Joueur joueur;
	
	private String authority;
}
