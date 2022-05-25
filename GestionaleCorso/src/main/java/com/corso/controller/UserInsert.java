package com.corso.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.corso.model.User;
import com.corso.service.UserServiceImpl;
import com.corso.service.ValidationUserExceptions2;

@WebServlet("/user-insert")
public class UserInsert extends HttpServlet {
	UserServiceImpl methods = new UserServiceImpl();

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("user-insert-form.jsp");

		// Prendo i dati dal form
		String name = request.getParameter("name");
		if(name==null || name=="") {
			request.setAttribute("errorName", "Il nome non può essere null");
			}
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		int age = Integer.parseInt(request.getParameter("age"));
		String dateOfBirth = request.getParameter("dateOfBirth");

		methods.getInsert(name, email, country, age, dateOfBirth);
		//response.sendRedirect("user-list.jsp");
		dispatcher.forward(request, response);

	}

}
