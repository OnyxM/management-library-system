package com.library_management_system.dao;

import java.util.List;

import com.library_management_system.beans.Client;
import com.library_management_system.beans.Emprunt;

public interface ClientDao {

	void create(Client client);
	List<Client> findAll();
	Client findOne(Long id);
	boolean deleteOne(Long id);
	boolean updateOne(Long id, Client newClientData);
	List<Emprunt> emprunts(Long id);
}
