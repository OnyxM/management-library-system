package com.libraymanagementsystem.dao;

import java.util.List;

import com.librarymanagementsystem.beans.Client;
import com.librarymanagementsystem.beans.Emprunt;
import com.librarymanagementsystem.beans.Exemplaire;

public interface EmpruntDao {

	void create(Emprunt emprunt);
	List<Emprunt> findAll();
	Emprunt findOne(Long id);
	boolean deleteOne(Long id);
	boolean updateOne(Long id, Emprunt newEmpruntData);
	Client client(Long id);
	Exemplaire exemplaire(Long id);
}
