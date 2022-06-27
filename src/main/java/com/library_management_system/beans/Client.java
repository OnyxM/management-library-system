package com.library_management_system.beans;

public class Client {
	private Long id;
	private String noms;
	private String matricule;
	private String cni;
	private String adresse;
	private String date_adhesion;
	
	
	
	public Client(Long id, String noms, String matricule, String cni, String adresse, String date_adhesion) {
		super();
		this.id = id;
		this.noms = noms;
		this.matricule = matricule;
		this.cni = cni;
		this.adresse = adresse;
		this.date_adhesion = date_adhesion;
	}
	
	public Client(String noms, String matricule, String cni, String adresse, String date_adhesion) {
		super();
		this.noms = noms;
		this.matricule = matricule;
		this.cni = cni;
		this.adresse = adresse;
		this.date_adhesion = date_adhesion;
	}


	public String getNoms() {
		return noms;
	}
	public void setNoms(String noms) {
		this.noms = noms;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getDate_adhesion() {
		return date_adhesion;
	}
	public void setDate_adhesion(String date_adhesion) {
		this.date_adhesion = date_adhesion;
	}
	public String getCni() {
		return cni;
	}
	public void setCni(String cni) {
		this.cni = cni;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
