package com.librarymanagementsystem.beans;

public class Document {

	private Long id;
	private String titre;
	private String sujet;
	private String edition;
	private String auteurs;
	private Long date_ajout;
	private String image;
	
	public Document() {}
	
	public Document(Long id, String titre, String sujet, String edition, String auteurs, Long date_ajout, String image) {
		this.id = id;
		this.titre = titre;
		this.sujet = sujet;
		this.edition = edition;
		this.auteurs = auteurs;
		this.date_ajout = date_ajout;
		this.image = image;
	}
	
	public Document(String titre, String sujet, String edition, String auteurs, Long date_ajout, String image) {
		this.titre = titre;
		this.sujet = sujet;
		this.edition = edition;
		this.auteurs = auteurs;
		this.date_ajout = date_ajout;
		this.image = image;
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
	public Long getDate_ajout() {
		return date_ajout;
	}
	public void setDate_ajout(Long date_ajout) {
		this.date_ajout = date_ajout;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
}
