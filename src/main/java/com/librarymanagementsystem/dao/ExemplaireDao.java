package com.librarymanagementsystem.dao;

import java.util.List;

import com.librarymanagementsystem.beans.Document;
import com.librarymanagementsystem.beans.Exemplaire;

public interface ExemplaireDao {

	void create(Exemplaire exemplaire);
	List<Exemplaire> findAll();
	Exemplaire findOne(Long id);
	boolean deleteOne(Long id);
	boolean updateOne(Long id, Exemplaire newExemplaireData);
	Document document(Long id);
}
