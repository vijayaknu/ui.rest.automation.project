package com.practice.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtils {

	//jdbc:postgresql://<database_host>:<port>/<database_name>
	private final String url = "jdbc:postgresql://localhost/dvdrental";
	private final String user = "postgres";
	private final String password = "<add your password>";
	private PreparedStatement preparedStatement;
	Connection conn = null;
	
	public Connection connect() {
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connected to the PostgreSQL server successfully.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return conn;
	}
	
	
    public static void main(String[] args) {
    	DBUtils app = new DBUtils();
        app.connect();
    }
    
    
    public ResultSet executeQuery(String sqlQuery) {
	    try {
			preparedStatement = conn.prepareStatement(sqlQuery);
			ResultSet resultSet = preparedStatement.executeQuery();
			return resultSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }
    
    
     
}
