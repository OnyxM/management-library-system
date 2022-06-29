package com.librarymanagementsystem.beans;

public class Gerant {

	private Long id;
	private String noms;
	private String email;
	private String mot_de_passe;
	
	public Gerant() {}
	
	public Gerant(Long id, String noms, String email, String mot_de_passe) {
		this.id = id;
		this.noms = noms;
		this.email = email;
		this.mot_de_passe = mot_de_passe;
	}
	public Gerant(String noms, String email, String mot_de_passe) {
		this.noms = noms;
		this.email = email;
		this.mot_de_passe = mot_de_passe;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNoms() {
		return noms;
	}
	public void setNoms(String noms) {
		this.noms = noms;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMot_de_passe() {
		return mot_de_passe;
	}
	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}
	
	
}
