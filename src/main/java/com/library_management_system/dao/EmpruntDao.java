package com.library_management_system.dao;

import java.util.List;

import com.library_management_system.beans.Client;
import com.library_management_system.beans.Emprunt;
import com.library_management_system.beans.Exemplaire;

public interface EmpruntDao {

	void create(Emprunt emprunt);
	List<Emprunt> findAll();
	Emprunt findOne(Long id);
	boolean deleteOne(Long id);
	boolean updateOne(Long id, Emprunt newEmpruntData);
	Client client(Long id);
	Exemplaire exemplaire(Long id);
}
