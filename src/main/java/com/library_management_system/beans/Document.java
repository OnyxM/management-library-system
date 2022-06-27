package com.library_management_system.beans;

public class Document {

	private Long id;
	private String titre;
	private String sujet;
	private String edition;
	private String auteurs;
	private String date_ajout;
	
	
	public Document(Long id, String titre, String sujet, String edition, String auteurs, String date_ajout) {
		super();
		this.id = id;
		this.titre = titre;
		this.sujet = sujet;
		this.edition = edition;
		this.auteurs = auteurs;
		this.date_ajout = date_ajout;
	}
	
	public Document(String titre, String sujet, String edition, String auteurs, String date_ajout) {
		super();
		this.titre = titre;
		this.sujet = sujet;
		this.edition = edition;
		this.auteurs = auteurs;
		this.date_ajout = date_ajout;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getSujet() {
		return sujet;
	}
	public void setSujet(String sujet) {
		this.sujet = sujet;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public String getAuteurs() {
		return auteurs;
	}
	public void setAuteurs(String auteurs) {
		this.auteurs = auteurs;
	}
	public String getDate_ajout() {
		return date_ajout;
	}
	public void setDate_ajout(String date_ajout) {
		this.date_ajout = date_ajout;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
}
