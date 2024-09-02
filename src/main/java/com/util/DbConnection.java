package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection 
{
	public static void main(String[] args) 
	{
		String dbUrl = "jdbc:mysql://localhost:3306/advjava";
		String dbUserName = "root";
		String dbPassword = "12345678";
		
		try {
			// 1 -> mysql driver class -> memory load
			Class.forName("com.mysql.jdbc.Driver");

			// 2 -> db connection open
			Connection connection = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);

			System.out.println("connection => " + connection);// memory
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
