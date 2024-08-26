package com.example.awsConnectPostgressRDS.awsConnectPostgressRDS;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App  {
	
	 public static void main(String[] args) {
		 
		 String jdbcUrl = "jdbc:postgresql://db1.cdycm4oeopst.ap-south-1.rds.amazonaws.com:5432/db1";
	        String username = "postgres";
	        String password = "(FXFxv%6542d$CkM>)|r>+e4+Lqg";


	            // Register the PostgreSQL driver

	            try {
			

	            Connection connection =  DBConnector.getInstance().getConnection(jdbcUrl, username, password);
	            
	            Statement statement = connection.createStatement();

	            ResultSet resultSet = statement.executeQuery("SELECT * FROM public.table1");

	            while (resultSet.next())
	            {
	                String columnValue = resultSet.getString("studentName");
	                System.out.println("Column Value: " + columnValue);
	            }

	            // Perform desired database operations

	            // Close the connection
	            connection.close();
	        	} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	        }
		 
		 
	  

}
