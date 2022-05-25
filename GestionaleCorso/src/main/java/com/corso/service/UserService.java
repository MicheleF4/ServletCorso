package com.corso.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.corso.model.User;

public interface UserService {
	public void getInsert(String name, String email, String country, int age, String dateOfBirth);
	public List<User> getUsers();
	public User getUser(int id);
	public void readList();
	public void getUpdate(String nameNew, String emailNew, String countryNew, int ageNew, String dataNew, int idNew) throws ValidationUserExceptions2;
	public void getDelete(int idNew);
	public void printErrorMessage(SQLException ex);
}
