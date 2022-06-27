package com.library_management_system.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.library_management_system.beans.Client;
import com.library_management_system.beans.Emprunt;
import com.library_management_system.beans.Exemplaire;

public class EmpruntDaoImpl implements EmpruntDao{

	private DaoFactory daoFactory;
	
	EmpruntDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

	
    @Override
    public void create(Emprunt emprunt) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO emprunts(client_id, exemplaire_id, date_emprunt, date_prevue_restitution, date_restitution, etat) VALUES(?, ?, ?, ?, ?, ?);");
            preparedStatement.setLong(1, emprunt.getClient_id());
            preparedStatement.setLong(2, emprunt.getExemplaire_id());
            preparedStatement.setString(3, emprunt.getDate_emprunt());
            preparedStatement.setString(4, emprunt.getDate_prevue_restitution());
            preparedStatement.setString(5, emprunt.getDate_restitution());
            preparedStatement.setInt(6, emprunt.getEtat());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Emprunt> findAll() {
        List<Emprunt> emprunts = new ArrayList<Emprunt>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT * FROM emprunts;");

            while (resultat.next()) {
            	Long id = resultat.getLong("id");
                Long client_id = resultat.getLong("client_id");
                Long exemplaire_id = resultat.getLong("exemplaire_id");
                String date_emprunt = resultat.getString("date_emprunt");
                String date_prevue_restitution = resultat.getString("date_prevue_restitution");
                String date_restitution = resultat.getString("date_restitution");
                int etat = resultat.getInt("etat");

                Emprunt emprunt = new Emprunt(id, client_id, exemplaire_id, date_emprunt, date_prevue_restitution, date_restitution, etat);

                emprunts.add(emprunt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emprunts;
    }
    
    public boolean deleteOne(Long id) {
    	boolean rowUpdated = false;
    	Connection connexion = null;
    	PreparedStatement preparedStatement = null;

        try {
        	connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("DELETE FROM emprunts WHERE id = ?;");
            preparedStatement.setLong(1, id);
            
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }
    
    public boolean updateOne(Long id, Emprunt emprunt)
    {
    	boolean rowUpdated = false;
    	Connection connexion = null;
    	PreparedStatement preparedStatement = null;

        try {
        	connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("UPDATE emprunts SET client_id = ?, exemplaire_id = ?, date_emprunt = ?, date_prevue_restitution = ?, date_restitution = ?, etat = ? WHERE id = ?;");
            preparedStatement.setLong(1, emprunt.getClient_id());
            preparedStatement.setLong(2, emprunt.getExemplaire_id());
            preparedStatement.setString(3, emprunt.getDate_emprunt());
            preparedStatement.setString(4, emprunt.getDate_prevue_restitution());
            preparedStatement.setString(5, emprunt.getDate_restitution());
            preparedStatement.setInt(6, emprunt.getEtat());
            preparedStatement.setLong(7, id);
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }
    
    public List<Emprunt> emprunts(Long id)
    {
    	List<Emprunt> emprunts = new ArrayList<Emprunt>();
        Connection connexion = null;
        PreparedStatement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.prepareStatement("SELECT * FROM emprunts where emprunt_id = ?;");
            statement.setLong(1, id);
            resultat = statement.executeQuery();
            		
            while (resultat.next()) {
            	Long client_id = resultat.getLong("client_id");
            	Long exemplaire_id = resultat.getLong("exemplaire_id");
                String date_emprunt = resultat.getString("date_emprunt");
                String date_prevue_restitution = resultat.getString("date_prevue_restitution");
                String date_restitution = resultat.getString("date_restitution");
                int etat = resultat.getInt("etat");

                Emprunt emprunt = new Emprunt(id, client_id, exemplaire_id, date_emprunt, date_prevue_restitution, date_restitution, etat);

                emprunts.add(emprunt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emprunts;
    }


	@Override
	public Emprunt findOne(Long id) {
		Emprunt emprunt = null;
	
		Connection connexion = null;
    	PreparedStatement preparedStatement = null;
        ResultSet resultat = null;
    	
    	try {
            connexion = daoFactory.getConnection();
            preparedStatement= connexion.prepareStatement("SELECT * FROM emprunts where id = ?;");
            preparedStatement.setLong(1, id);
            
            resultat = preparedStatement.executeQuery();
            while (resultat.next()) {
                Long client_id = resultat.getLong("client_id");
                Long exemplaire_id = resultat.getLong("exemplaire_id");
                String date_emprunt = resultat.getString("date_emprunt");
                String date_prevue_restitution = resultat.getString("date_prevue_restitution");
                String date_restitution = resultat.getString("date_restitution");
                int etat = resultat.getInt("etat");
                emprunt = new Emprunt(id, client_id, exemplaire_id, date_emprunt, date_prevue_restitution, date_restitution, etat);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return emprunt;
	}


	@Override
	public Client client(Long id) {
		Client client = null;
		
		Connection connexion = null;
    	PreparedStatement preparedStatement = null;
        ResultSet resultat = null;
    	
    	try {
            connexion = daoFactory.getConnection();
            preparedStatement= connexion.prepareStatement("SELECT * FROM clients where id = ?;");
            preparedStatement.setLong(1, id);
            
            resultat = preparedStatement.executeQuery();
            while (resultat.next()) {
                String noms = resultat.getString("noms");
                String matricule = resultat.getString("matricule");
                String cni = resultat.getString("cni");
                String adresse = resultat.getString("adresse");
                String date_adhesion = resultat.getString("date_adhesion");

                client = new Client(id, noms, matricule, cni, adresse, date_adhesion);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return client;
	}


	@Override
	public Exemplaire exemplaire(Long id) {
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
                String date_ajout = resultat.getString("date_ajout");

                exemplaire = new Exemplaire(id, document_id, date_ajout);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return exemplaire;
	}
}
