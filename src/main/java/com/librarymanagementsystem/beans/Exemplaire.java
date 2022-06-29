package com.librarymanagementsystem.beans;

public class Exemplaire {

	private Long id;
	private Long document_id;
	private String code;
	private Long date_ajout;
	
	public Exemplaire() {}
	
	public Exemplaire(Long id, Long document_id, String code, Long date_ajout) {
		this.id = id;
		this.document_id = document_id;
		this.code = code;
		this.date_ajout = date_ajout;
	}
	public Exemplaire(Long document_id, String code, Long date_ajout) {
		this.document_id = document_id;
		this.code = code;
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Long getDate_ajout() {
		return date_ajout;
	}
	public void setDate_ajout(Long date_ajout) {
		this.date_ajout = date_ajout;
	}
}
