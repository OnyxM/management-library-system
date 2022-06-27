package com.library_management_system.dao;

import java.util.List;

import com.library_management_system.beans.Gerant;

public interface GerantDao {

	void create(Gerant gerant);
	List<Gerant> findAll();
	Gerant findOne(Long id);
	boolean deleteOne(Long id);
	boolean updateOne(Long id, Gerant newGerantData);
	
}
