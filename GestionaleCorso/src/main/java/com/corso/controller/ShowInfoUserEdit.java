
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

@WebServlet("/user-form")
public class ShowInfoUserEdit extends HttpServlet {
	UserServiceImpl methods = new UserServiceImpl();

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//DA RIVEDERE
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		
		//Prendo id da request
	    int id = Integer.parseInt(request.getParameter("id"));
	    
	        //Creo istanza di User
	  	    User user = methods.getUser(id);
	  		request.setAttribute("user", user);

		dispatcher.forward(request, response);

	}

	

}
