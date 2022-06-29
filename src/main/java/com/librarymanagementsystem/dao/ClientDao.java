package com.librarymanagementsystem.dao;

import java.util.List;

import com.librarymanagementsystem.beans.Client;
import com.librarymanagementsystem.beans.Emprunt;

public interface ClientDao {

	void create(Client client);
	List<Client> findAll();
	Client findOne(Long id);
	boolean deleteOne(Long id);
	boolean updateOne(Long id, Client newClientData);
	List<Emprunt> emprunts(Long id);
}
