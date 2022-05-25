package com.corso.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.corso.service.UserServiceImpl;
import com.corso.service.ValidationUserExceptions2;

@WebServlet("/update-form")
public class UserUpdate extends HttpServlet {
	
	UserServiceImpl methods = new UserServiceImpl();

	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		
		//Prendo id da request
	    int id = Integer.parseInt(request.getParameter("id"));
	    
	    //Prendo i dati dal form
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		int age = Integer.parseInt(request.getParameter("age"));
		String dateOfBirth = request.getParameter("dateOfBirth");

		//Una volta presi dal form invio all'update()
		try {
			methods.getUpdate(name, email, country, age, dateOfBirth, id);
		} catch (ValidationUserExceptions2 e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("user-list");

		//dispatcher.forward(request, response);
		
		
	}
	
	
}
