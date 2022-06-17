package com.libraymanagementsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.librarymanagementsystem.beans.Document;
import com.librarymanagementsystem.beans.Exemplaire;

public class DocumentDaoImpl implements DocumentDao{

	private DaoFactory daoFactory;
	
	DocumentDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

	
    @Override
    public void create(Document document) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO documents(titre, sujet, edition, auteurs, date_ajout) VALUES(?, ?, ?, ?, ?);");
            preparedStatement.setString(1, document.getTitre());
            preparedStatement.setString(2, document.getSujet());
            preparedStatement.setString(3, document.getEdition());
            preparedStatement.setString(4, document.getAuteurs());
            preparedStatement.setString(5, document.getDate_ajout());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Document> findAll() {
        List<Document> documents = new ArrayList<Document>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT * FROM documents;");

            while (resultat.next()) {
            	Long id = resultat.getLong("id");
                String titre = resultat.getString("titre");
                String sujet = resultat.getString("sujet");
                String edition = resultat.getString("edition");
                String auteurs = resultat.getString("auteurs");
                String date_ajout = resultat.getString("date_ajout");

                Document document = new Document(id, titre, sujet, edition, auteurs, date_ajout);

                documents.add(document);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return documents;
    }
    
    public boolean deleteOne(Long id) {
    	boolean rowUpdated = false;
    	Connection connexion = null;
    	PreparedStatement preparedStatement = null;

        try {
        	connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("DELETE FROM documents WHERE id = ?;");
            preparedStatement.setLong(1, id);
            
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }
    
    public boolean updateOne(Long id, Document document)
    {
    	boolean rowUpdated = false;
    	Connection connexion = null;
    	PreparedStatement preparedStatement = null;

        try {
        	connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("UPDATE documents SET titre = ?, sujet = ?, edition = ?, auteurs = ?, date_ajout = ? WHERE id = ?;");
            preparedStatement.setString(1, document.getTitre());
            preparedStatement.setString(2, document.getSujet());
            preparedStatement.setString(3, document.getEdition());
            preparedStatement.setString(4, document.getAuteurs());
            preparedStatement.setString(5, document.getDate_ajout());
            preparedStatement.setLong(6, id);
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }
    
    public List<Exemplaire> exemplaires(Long id)
    {
    	List<Exemplaire> exemplaires = new ArrayList<Exemplaire>();
        Connection connexion = null;
        PreparedStatement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.prepareStatement("SELECT * FROM exemplaires where document_id = ?;");
            statement.setLong(1, id);
            resultat = statement.executeQuery();
            		
            while (resultat.next()) {
            	Long document_id = resultat.getLong("id");
                String date_ajout = resultat.getString("date_ajout");

                Exemplaire exemplaire = new Exemplaire(id, document_id, date_ajout);

                exemplaires.add(exemplaire);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exemplaires;
    }


	@Override
	public Document findOne(Long id) {
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
                String date_ajout = resultat.getString("date_ajout");

                document = new Document(id, titre, sujet, edition, auteurs, date_ajout);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return document;
	}

}
