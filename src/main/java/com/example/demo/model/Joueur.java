package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


/*
 * Entity: 
	-Joueur: id, username string ,password string, force int, vie int, liste de match
	-Match: joueur1,joueur2,date du match, gagnant
 */
@Entity
@Table(name="Users")
@JsonIgnoreProperties("password")
public class Joueur {

	@Id
	private String username;
	
	
	
	private String password;
	private Integer force;
	private Integer vie;
	private boolean enabled;
	@OneToOne
	private Authorities authorities;
	
	  public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public Authorities getAuthorities() {
		return authorities;
	}
	public void setAuthorities(Authorities authorities) {
		this.authorities = authorities;
	}
	@OneToMany(mappedBy = "joueur")
	    private Set<MatchJoueur> matchs;
	 
	  
	@Override
	public String toString() {
		return "Joueur [username=" + username + ", password=" + password + ", force=" + force + ", vie="
				+ vie + ", matchs=" + matchs + "]";
	}
	public Joueur() {
		super();
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getForce() {
		return force;
	}
	public void setForce(Integer force) {
		this.force = force;
	}
	public Integer getVie() {
		return vie;
	}
	public void setVie(Integer vie) {
		this.vie = vie;
	}
	
	public Set<MatchJoueur> getMatchs() {
		return matchs;
	}
	public void setMatchs(Set<MatchJoueur> matchs) {
		this.matchs = matchs;
	}
	public void addMatch(MatchJoueur match) {
		getMatchs().add(match);
		
	}
	public void perdVie(int i) {
		this.vie-=i;
		
	}
	
	
}
