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

public class ClientDaoImpl implements ClientDao{

	private DaoFactory daoFactory;
	
	ClientDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

	
    @Override
    public void create(Client client) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO clients(noms, matricule, cni, adresse, date_adhesion) VALUES(?, ?, ?, ?, ?);");
            preparedStatement.setString(1, client.getNoms());
            preparedStatement.setString(2, client.getMatricule());
            preparedStatement.setString(3, client.getCni());
            preparedStatement.setString(4, client.getAdresse());
            preparedStatement.setString(5, client.getDate_adhesion());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Client> findAll() {
        List<Client> clients = new ArrayList<Client>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT * FROM clients;");

            while (resultat.next()) {
            	Long id = resultat.getLong("id");
                String noms = resultat.getString("noms");
                String matricule = resultat.getString("matricule");
                String cni = resultat.getString("cni");
                String adresse = resultat.getString("adresse");
                String date_adhesion = resultat.getString("date_adhesion");

                Client client = new Client(id, noms, matricule, cni, adresse, date_adhesion);

                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }
    
    public boolean deleteOne(Long id) {
    	boolean rowUpdated = false;
    	Connection connexion = null;
    	PreparedStatement preparedStatement = null;

        try {
        	connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("DELETE FROM clients WHERE id = ?;");
            preparedStatement.setLong(1, id);
            
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }
    
    public boolean updateOne(Long id, Client client)
    {
    	boolean rowUpdated = false;
    	Connection connexion = null;
    	PreparedStatement preparedStatement = null;

        try {
        	connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("UPDATE clients SET noms = ?, matricule = ?, cni = ?, adresse = ?, date_adhesion = ? WHERE id = ?;");
            preparedStatement.setString(1, client.getNoms());
            preparedStatement.setString(2, client.getMatricule());
            preparedStatement.setString(3, client.getCni());
            preparedStatement.setString(4, client.getAdresse());
            preparedStatement.setString(5, client.getDate_adhesion());
            preparedStatement.setLong(6, id);
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
            statement = connexion.prepareStatement("SELECT * FROM emprunts where client_id = ?;");
            statement.setLong(1, id);
            resultat = statement.executeQuery();
            		
            while (resultat.next()) {
            	Long client_id = resultat.getLong("id");
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
	public Client findOne(Long id) {
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
}
