package com.library_management_system.dao;

import java.util.List;

import com.library_management_system.beans.Document;
import com.library_management_system.beans.Exemplaire;

public interface ExemplaireDao {

	void create(Exemplaire exemplaire);
	List<Exemplaire> findAll();
	Exemplaire findOne(Long id);
	boolean deleteOne(Long id);
	boolean updateOne(Long id, Exemplaire newExemplaireData);
	Document document(Long id);
}
