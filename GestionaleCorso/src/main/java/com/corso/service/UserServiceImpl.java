package com.corso.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.corso.config.ConnectionDb;
import com.corso.model.User;

public class UserServiceImpl implements UserService {

	ConnectionDb conn;

	public UserServiceImpl() {
		conn = new ConnectionDb();
	}

	String sql = "INSERT INTO user (name, email, country, age, dateOfBirth) VALUES (?, ?, ?, ?, ?)";
	String sql2 = "SELECT * FROM user";

	@Override
	public void getInsert(String name, String email, String country, int age, String dateOfBirth) {
		Connection connessione = null;
		PreparedStatement statement = null;

		// per aprire: connessione->statement->resultSet
		// per chiudere al contrario

		try {

			connessione = conn.getConnection();

			// Creo la connessione al server tramite DriverManager (e il suo metodo)
			// Connection conn = DriverManager.getConnection(dbURL, username, password);
			if (connessione != null) {

				System.out.println("Connected");

				statement = connessione.prepareStatement(sql);

				statement.setString(1, name);
				statement.setString(2, email);
				statement.setString(3, country);
				statement.setInt(4, age);
				statement.setDate(5, java.sql.Date.valueOf(dateOfBirth));

				int rowsInserted = statement.executeUpdate();

				if (rowsInserted > 0) {
					System.out.println("Ho aggiunto una tupla");
				}
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				statement.close();
				// connessione.close();
			} catch (SQLException e) {
				//e.printStackTrace();
				printErrorMessage(e);
			}
		}

	}

	@Override
	public List<User> getUsers() {
		Connection connessione = null;
		PreparedStatement statement = null;
		ResultSet result = null;

		List<User> userList = new ArrayList<>();

		try {

			// Riassegno a connessione la connessione
			connessione = conn.getConnection();

			if (conn != null) {

				Statement statement2 = conn.getConnection().createStatement();
				result = statement2.executeQuery(sql2);

				while (result.next()) {
					Integer id = result.getInt(1);
					String name = result.getString(2);
					String email = result.getString(3);
					String country = result.getString(4);
					Integer age = result.getInt(5);
					Date dateOfBirth = result.getDate(6);

					// Creo istanza di User
					User user = new User();

					user.setId(id);
					user.setName(name);
					user.setEmail(email);
					user.setCountry(country);
					user.setAge(age);
					user.setDateOfBirth(dateOfBirth);
					userList.add(user);

				}

			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return userList;
	}

	@Override
	public void readList() {

		List<User> userList2 = getUsers();

		for (int i = 0; i < userList2.size(); i++) {
			System.out.println(userList2.get(i));
		}

	}

	@Override
	public void getUpdate(String nameNew, String emailNew, String countryNew, int ageNew, String dataNew, int idNew)
			throws ValidationUserExceptions2 {
		Connection connessione = null;
		PreparedStatement statement3 = null;

		try {
			connessione = conn.getConnection();
			if (conn != null) {

				if (emailNew == null) {
					throw new ValidationUserExceptions2("Errore: Il valore di emailNew NON deve essere NULL!");
				}

				String sql3 = "UPDATE user SET name=?, email=?, country=?, age=?, dateOfBirth=? WHERE id=?";
				statement3 = connessione.prepareStatement(sql3);

				statement3.setString(1, nameNew);
				statement3.setString(2, emailNew);
				statement3.setString(3, countryNew);
				statement3.setInt(4, ageNew);
				statement3.setDate(5, java.sql.Date.valueOf(dataNew));
				statement3.setInt(6, idNew);

				int rowsInserted = statement3.executeUpdate();
				System.out.println("Un utente è stato aggiornato.");
			}

		} catch (SQLException ex) {
			//ex.printStackTrace();
			printErrorMessage(ex);
		}

	}

	@Override
	public void getDelete(int idNew) {
		Connection connessione = null;
		PreparedStatement statement4 = null;

		try {
			connessione = conn.getConnection();

			if (conn != null) {

				String sql4 = "DELETE FROM user WHERE id=?";
				statement4 = connessione.prepareStatement(sql4);

				statement4.setInt(1, idNew);

				int rowsDeleted = statement4.executeUpdate();
				System.out.println("Un utente con id: " + idNew + " è stato cancellato.");
			}

		} catch (SQLException ex) {
			//ex.printStackTrace();
			printErrorMessage(ex);

		}

	}

	@Override
	public User getUser(int id) {

		Connection connessione = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		User user = new User();

		try {

			// Riassegno a connessione la connessione
			connessione = conn.getConnection();

			if (conn != null) {

				

				String sql3 = "SELECT * FROM user WHERE id=?";
				statement = conn.getConnection().prepareStatement(sql3);
				statement.setInt(1, id);

				result = statement.executeQuery();
				
				
				if (result.next()) {

					user.setId(result.getInt(1));
					user.setName(result.getString(2));
					user.setEmail(result.getString(3));
					user.setCountry(result.getString(4));
					user.setAge(result.getInt(5));
					user.setDateOfBirth(result.getDate(6));
					
					
				}

			}

		} catch (SQLException ex) {
			//ex.printStackTrace();
			printErrorMessage(ex);
		}

		return user;
	}

	@Override
	public void printErrorMessage(SQLException ex) {
	     for (Throwable e: ex) {
	            if (e instanceof SQLException) {
	                e.printStackTrace(System.err);
	                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
	                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
	                System.err.println("Message: " + e.getMessage());
	                Throwable t = ex.getCause();
	                while (t != null) {
	                    System.out.println("Cause: " + t);
	                    t = t.getCause();
	                }
	            }
	        }
		
	}

}
