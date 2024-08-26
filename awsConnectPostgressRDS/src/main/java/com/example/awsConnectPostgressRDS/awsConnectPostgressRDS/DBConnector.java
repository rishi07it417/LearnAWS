package com.example.awsConnectPostgressRDS.awsConnectPostgressRDS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	
	 	private Connection conn = null;
	 	private static DBConnector dbconn;

	    private DBConnector() {
	    }
	    
	    
	    public static DBConnector getInstance() {
	        if (dbconn == null) {
	            dbconn = new DBConnector();
	        }
	        return dbconn;
	    }
	    
	    public Connection getConnection(String jdbcUrl,String username, String password) {
	    	 try {
				Class.forName("org.postgresql.Driver");
	            conn =  DriverManager.getConnection(jdbcUrl, username, password);
	    	 } catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	        return conn;
	    }

	   

}
