package com.libraymanagementsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.librarymanagementsystem.beans.Gerant;

public class GerantDaoImpl implements GerantDao{

	private DaoFactory daoFactory;
	
	GerantDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

	
    @Override
    public void create(Gerant gerant) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO gerants(noms, email, mot_de_passe) VALUES(?, ?, ?);");
            preparedStatement.setString(1, gerant.getNoms());
            preparedStatement.setString(2, gerant.getEmail());
            preparedStatement.setString(3, gerant.getMot_de_passe());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Gerant> findAll() {
        List<Gerant> gerants = new ArrayList<Gerant>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT * FROM gerants;");

            while (resultat.next()) {
            	Long id = resultat.getLong("id");
                String noms = resultat.getString("noms");
                String email = resultat.getString("email");
                String mot_de_passe = resultat.getString("mot_de_passe");

                Gerant gerant = new Gerant(id, noms, email, mot_de_passe);

                gerants.add(gerant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gerants;
    }
    
    public boolean deleteOne(Long id) {
    	boolean rowUpdated = false;
    	Connection connexion = null;
    	PreparedStatement preparedStatement = null;

        try {
        	connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("DELETE FROM gerants WHERE id = ?;");
            preparedStatement.setLong(1, id);
            
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }
    
    public boolean updateOne(Long id, Gerant gerant)
    {
    	boolean rowUpdated = false;
    	Connection connexion = null;
    	PreparedStatement preparedStatement = null;

        try {
        	connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("UPDATE gerants SET noms = ?, email = ?, mot_de_passe = ? WHERE id = ?;");
            preparedStatement.setString(1, gerant.getNoms());
            preparedStatement.setString(2, gerant.getEmail());
            preparedStatement.setString(3, gerant.getMot_de_passe());
            preparedStatement.setLong(4, id);
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }

	@Override
	public Gerant findOne(Long id) {
		Gerant gerant = null;
	
		Connection connexion = null;
    	PreparedStatement preparedStatement = null;
        ResultSet resultat = null;
    	
    	try {
            connexion = daoFactory.getConnection();
            preparedStatement= connexion.prepareStatement("SELECT * FROM gerants where id = ?;");
            preparedStatement.setLong(1, id);
            
            resultat = preparedStatement.executeQuery();
            while (resultat.next()) {
                String noms = resultat.getString("noms");
                String email = resultat.getString("email");
                String mot_de_passe = resultat.getString("mot_de_passe");

                gerant = new Gerant(id, noms, email, mot_de_passe);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return gerant;
	}
}
