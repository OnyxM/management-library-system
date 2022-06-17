package com.libraymanagementsystem.dao;

import java.util.List;

import com.librarymanagementsystem.beans.Document;
import com.librarymanagementsystem.beans.Exemplaire;

public interface DocumentDao {

	void create(Document document);
	List<Document> findAll();
	Document findOne(Long id);
	boolean deleteOne(Long id);
	boolean updateOne(Long id, Document newDocumentData);
	List<Exemplaire> exemplaires(Long id);
}
