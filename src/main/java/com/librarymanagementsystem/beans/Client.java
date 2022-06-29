package com.librarymanagementsystem.beans;

public class Client {
	private Long id;
	private String noms;
	private String matricule;
	private String cni;
	private String telephone;
	private String adresse;
	private Long date_adhesion;
	private String noms_proche;
	private String cni_proche;
	private String telephone_proche;	
	
	public Client()
	{
		
	}

	public Client(Long id, String noms, String matricule, String cni, String telephone, String adresse, Long date_adhesion, String nom_proche, String cni_proche, String telephone_proche) {
		this.id = id;
		this.noms = noms;
		this.matricule = matricule;
		this.cni = cni;
		this.telephone = telephone;
		this.adresse = adresse;
		this.date_adhesion = date_adhesion;
		this.noms_proche = nom_proche;
		this.cni_proche = cni_proche;
		this.telephone_proche = telephone_proche;
	}

	public Client(String noms, String matricule, String cni, String telephone, String adresse, Long date_adhesion, String nom_proche, String cni_proche, String telephone_proche) {
		this.noms = noms;
		this.matricule = matricule;
		this.cni = cni;
		this.telephone = telephone;
		this.adresse = adresse;
		this.date_adhesion = date_adhesion;
		this.noms_proche = nom_proche;
		this.cni_proche = cni_proche;
		this.telephone_proche = telephone_proche;
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
	public Long getDate_adhesion() {
		return date_adhesion;
	}
	public void setDate_adhesion(Long date_adhesion) {
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
	
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
