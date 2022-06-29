package com.librarymanagementsystem.beans;

public class Emprunt {

	private Long id;
	private Long client_id;
	private Long exemplaire_id;
	private Long date_emprunt;
	private Long date_prevue_restitution;
	private Long date_restitution;
	private int etat; // 0 Non restitut�, 1 restitu�;
	private String noms_proche;
	private String cni_proche;
	private String telephone_proche;
	
	public Emprunt() {}
	
	public Emprunt(Long id, Long client_id, Long exemplaire_id, Long date_emprunt, Long date_prevue_restitution,
			Long date_restitution, int etat, String nom_proche, String cni_proche, String telephone_proche) {
		this.id = id;
		this.client_id = client_id;
		this.exemplaire_id = exemplaire_id;
		this.date_emprunt = date_emprunt;
		this.date_prevue_restitution = date_prevue_restitution;
		this.date_restitution = date_restitution;
		this.etat = etat;
		this.noms_proche = nom_proche;
		this.cni_proche = cni_proche;
		this.telephone_proche = telephone_proche;
	}
	
	public Emprunt(Long client_id, Long exemplaire_id, Long date_emprunt, Long date_prevue_restitution,
			Long date_restitution, int etat, String nom_proche, String cni_proche, String telephone_proche) {
		this.client_id = client_id;
		this.exemplaire_id = exemplaire_id;
		this.date_emprunt = date_emprunt;
		this.date_prevue_restitution = date_prevue_restitution;
		this.date_restitution = date_restitution;
		this.etat = etat;
		this.noms_proche = nom_proche;
		this.cni_proche = cni_proche;
		this.telephone_proche = telephone_proche;
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
	public Long getDate_emprunt() {
		return date_emprunt;
	}
	public void setDate_emprunt(Long date_emprunt) {
		this.date_emprunt = date_emprunt;
	}
	public Long getDate_prevue_restitution() {
		return date_prevue_restitution;
	}
	public void setDate_prevue_restitution(Long date_prevue_restitution) {
		this.date_prevue_restitution = date_prevue_restitution;
	}
	public Long getDate_restitution() {
		return date_restitution;
	}
	public void setDate_restitution(Long date_restitution) {
		this.date_restitution = date_restitution;
	}
	public int getEtat() {
		return etat;
	}
	public void setEtat(int etat) {
		this.etat = etat;
	}

	public String getNoms_proche() {
		return this.noms_proche;
	}

	public void setNoms_proche(String nom_proche) {
		this.noms_proche = nom_proche;
	}

	public String getCni_proche() {
		return this.cni_proche;
	}

	public void setCni_proche(String cni_proche) {
		this.cni_proche = cni_proche;
	}

	public String getTelephone_proche() {
		return this.telephone_proche;
	}

	public void setTelephone_proche(String telephone_proche) {
		this.telephone_proche = telephone_proche;
	}
	
	
}
