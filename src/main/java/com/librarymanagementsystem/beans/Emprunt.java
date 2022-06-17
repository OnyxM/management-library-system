package com.librarymanagementsystem.beans;

public class Emprunt {

	private Long id;
	private Long client_id;
	private Long exemplaire_id;
	private String date_emprunt;
	private String date_prevue_restitution;
	private String date_restitution;
	private int etat; // 0 Non restituté, 1 restitué;
	
	public Emprunt(Long id, Long client_id, Long exemplaire_id, String date_emprunt, String date_prevue_restitution,
			String date_restitution, int etat) {
		super();
		this.id = id;
		this.client_id = client_id;
		this.exemplaire_id = exemplaire_id;
		this.date_emprunt = date_emprunt;
		this.date_prevue_restitution = date_prevue_restitution;
		this.date_restitution = date_restitution;
		this.etat = etat;
	}
	
	public Emprunt(Long client_id, Long exemplaire_id, String date_emprunt, String date_prevue_restitution,
			String date_restitution, int etat) {
		super();
		this.client_id = client_id;
		this.exemplaire_id = exemplaire_id;
		this.date_emprunt = date_emprunt;
		this.date_prevue_restitution = date_prevue_restitution;
		this.date_restitution = date_restitution;
		this.etat = etat;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getClient_id() {
		return client_id;
	}
	public void setClient_id(Long client_id) {
		this.client_id = client_id;
	}
	public Long getExemplaire_id() {
		return exemplaire_id;
	}
	public void setExemplaire_id(Long exemplaire_id) {
		this.exemplaire_id = exemplaire_id;
	}
	public String getDate_emprunt() {
		return date_emprunt;
	}
	public void setDate_emprunt(String date_emprunt) {
		this.date_emprunt = date_emprunt;
	}
	public String getDate_prevue_restitution() {
		return date_prevue_restitution;
	}
	public void setDate_prevue_restitution(String date_prevue_restitution) {
		this.date_prevue_restitution = date_prevue_restitution;
	}
	public String getDate_restitution() {
		return date_restitution;
	}
	public void setDate_restitution(String date_restitution) {
		this.date_restitution = date_restitution;
	}
	public int getEtat() {
		return etat;
	}
	public void setEtat(int etat) {
		this.etat = etat;
	}
	
	
}
