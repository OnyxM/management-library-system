package com.library_management_system.dao;

import java.util.List;

import com.library_management_system.beans.Document;
import com.library_management_system.beans.Exemplaire;

public interface DocumentDao {

	void create(Document document);
	List<Document> findAll();
	Document findOne(Long id);
	boolean deleteOne(Long id);
	boolean updateOne(Long id, Document newDocumentData);
	List<Exemplaire> exemplaires(Long id);
}
