package com.librarymanagementsystem.dao;

import java.util.List;

import com.librarymanagementsystem.beans.Gerant;

public interface GerantDao {

	void create(Gerant gerant);
	List<Gerant> findAll();
	Gerant findOne(Long id);
	boolean deleteOne(Long id);
	boolean updateOne(Long id, Gerant newGerantData);
	
}
