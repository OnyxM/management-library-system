package com.librarymanagementsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.librarymanagementsystem.beans.Document;
import com.librarymanagementsystem.beans.Exemplaire;

public class ExemplaireDaoImpl implements ExemplaireDao{

	private DaoFactory daoFactory;
	
	ExemplaireDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

	
    @Override
    public void create(Exemplaire exemplaire) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO exemplaires(document_id, code, date_ajout) VALUES(?, ?, ?);");
            preparedStatement.setLong(1, exemplaire.getDocument_id());
            preparedStatement.setString(2, exemplaire.getCode());
            preparedStatement.setLong(3, exemplaire.getDate_ajout());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Exemplaire> findAll() {
        List<Exemplaire> exemplaires = new ArrayList<Exemplaire>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT * FROM exemplaires;");

            while (resultat.next()) {
            	Long id = resultat.getLong("id");
            	Long document_id = resultat.getLong("document_id");
                String code = resultat.getString("code");
                Long date_ajout = resultat.getLong("date_ajout");

                Exemplaire exemplaire = new Exemplaire(id, document_id, code, date_ajout);

                exemplaires.add(exemplaire);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exemplaires;
    }
    
    public boolean deleteOne(Long id) {
    	boolean rowUpdated = false;
    	Connection connexion = null;
    	PreparedStatement preparedStatement = null;

        try {
        	connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("DELETE FROM exemplaires WHERE id = ?;");
            preparedStatement.setLong(1, id);
            
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }
    
    public boolean updateOne(Long id, Exemplaire exemplaire)
    {
    	boolean rowUpdated = false;
    	Connection connexion = null;
    	PreparedStatement preparedStatement = null;

        try {
        	connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("UPDATE exemplaires SET document_id = ?, code = ?, date_ajout = ? WHERE id = ?;");
            preparedStatement.setLong(1, exemplaire.getDocument_id());
            preparedStatement.setString(2, exemplaire.getCode());
            preparedStatement.setLong(3, exemplaire.getDate_ajout());
            preparedStatement.setLong(4, id);
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }

	@Override
	public Exemplaire findOne(Long id) {
		Exemplaire exemplaire = null;
	
		Connection connexion = null;
    	PreparedStatement preparedStatement = null;
        ResultSet resultat = null;
    	
    	try {
            connexion = daoFactory.getConnection();
            preparedStatement= connexion.prepareStatement("SELECT * FROM exemplaires where id = ?;");
            preparedStatement.setLong(1, id);
            
            resultat = preparedStatement.executeQuery();
            while (resultat.next()) {
            	Long document_id = resultat.getLong("document_id");
                String code = resultat.getString("code");
                Long date_ajout = resultat.getLong("date_ajout");

                exemplaire = new Exemplaire(id, document_id, code, date_ajout);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return exemplaire;
	}


	@Override
	public Document document(Long id) {
		Document document = null;
		
		Connection connexion = null;
    	PreparedStatement preparedStatement = null;
        ResultSet resultat = null;
    	
    	try {
            connexion = daoFactory.getConnection();
            preparedStatement= connexion.prepareStatement("SELECT * FROM documents where id = ?;");
            preparedStatement.setLong(1, id);
            
            resultat = preparedStatement.executeQuery();
            while (resultat.next()) {
                String titre = resultat.getString("titre");
                String sujet = resultat.getString("sujet");
                String edition = resultat.getString("edition");
                String auteurs = resultat.getString("auteurs");
                Long date_ajout = resultat.getLong("date_ajout");
                String image = resultat.getString("image");

                document = new Document(id, titre, sujet, edition, auteurs, date_ajout, image);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return document;
	}
}
