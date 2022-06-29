package com.librarymanagementsystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {
    private String url;
    private String username;
    private String password;

    DaoFactory(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public static DaoFactory getInstance() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {

        }

        DaoFactory instance = new DaoFactory(
                "jdbc:mysql://localhost:3306/library_management_system", "root", "");
        return instance;
    }

    public Connection getConnection() throws SQLException {
        Connection connexion = DriverManager.getConnection(url, username, password);
        connexion.setAutoCommit(false);
        return connexion; 
    }

    // R�cup�ration de Dao
    
    public ClientDao getClientDao() {
        return new ClientDaoImpl(this);
    }
    
    public DocumentDao getDocumentDao() {
        return new DocumentDaoImpl(this);
    }
    
    public ExemplaireDao getExemplaireDao() {
        return new ExemplaireDaoImpl(this);
    }
    
    public EmpruntDao getEmpruntDao() {
        return new EmpruntDaoImpl(this);
    }
    
    public GerantDao getGerantDaoImpl() {
        return new GerantDaoImpl(this);
    }
    
    
}
