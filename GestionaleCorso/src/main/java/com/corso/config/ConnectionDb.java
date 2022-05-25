package com.corso.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.corso.model.User;
import com.corso.service.UserServiceImpl;

public class ConnectionDb {
	private String dbURL = "jdbc:mysql://localhost:3306/corso?useSSL=false&serverTimezone=UTC";
	private String username = "root";
	private String password = "a/T19@ip0R5E23";
	
	
	 public Connection getConnection() {
		Connection conn=null;
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn= DriverManager.getConnection(dbURL, username, password);
			if (conn!= null) {
				System.out.println("Connesso al DB");
			}
			
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		} 
		return conn;
	}
	
	 
	 
	//TEST PURPOSE
	/*public static void main(String[] Args) {
				
		UserServiceImpl implMethods = new UserServiceImpl();
		
		//Ordine: name, email, country, age, dateOfBirth
		//implMethods.getInsert("Giovanni", "giovanni@gmail.com", "Italy", 32, "1983-06-08");
		//implMethods.getDelete(17);
		//System.out.println(implMethods.getUser());
		implMethods.readList();
		
		
	}*/
	
	
}
