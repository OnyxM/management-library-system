package com.librarymanagementsystem.beans;

public class Exemplaire {

	private Long id;
	private Long document_id;
	private String date_ajout;
	
	public Exemplaire(Long id, Long document_id, String date_ajout) {
		super();
		this.id = id;
		this.document_id = document_id;
		this.date_ajout = date_ajout;
	}
	public Exemplaire(Long document_id, String date_ajout) {
		super();
		this.document_id = document_id;
		this.date_ajout = date_ajout;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getDocument_id() {
		return document_id;
	}
	public void setDocument_id(Long document_id) {
		this.document_id = document_id;
	}
	public String getDate_ajout() {
		return date_ajout;
	}
	public void setDate_ajout(String date_ajout) {
		this.date_ajout = date_ajout;
	}
}
