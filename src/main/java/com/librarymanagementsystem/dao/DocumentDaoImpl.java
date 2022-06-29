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
            preparedStatement = connexion.prepareStatement("INSERT INTO documents(titre, sujet, edition, auteurs, date_ajout, image) VALUES(?, ?, ?, ?, ?, ?);");
            preparedStatement.setString(1, document.getTitre());
            preparedStatement.setString(2, document.getSujet());
            preparedStatement.setString(3, document.getEdition());
            preparedStatement.setString(4, document.getAuteurs());
            preparedStatement.setLong(5, document.getDate_ajout());
            preparedStatement.setString(6, document.getImage());

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
                Long date_ajout = resultat.getLong("date_ajout");
                String image = resultat.getString("image");

                Document document = new Document(id, titre, sujet, edition, auteurs, date_ajout, image);

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
            preparedStatement = connexion.prepareStatement("UPDATE documents SET titre = ?, sujet = ?, edition = ?, auteurs = ?, date_ajout = ?, image = ? WHERE id = ?;");
            preparedStatement.setString(1, document.getTitre());
            preparedStatement.setString(2, document.getSujet());
            preparedStatement.setString(3, document.getEdition());
            preparedStatement.setString(4, document.getAuteurs());
            preparedStatement.setLong(5, document.getDate_ajout());
            preparedStatement.setString(6, document.getImage());
            preparedStatement.setLong(7, id);
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
                Long date_ajout = resultat.getLong("date_ajout");
                String code = resultat.getString("code");

                Exemplaire exemplaire = new Exemplaire(id, document_id, code, date_ajout);

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
