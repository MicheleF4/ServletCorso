package com.corso.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.corso.service.UserServiceImpl;

@WebServlet("/user-delete")
public class UserDelete extends HttpServlet {
	UserServiceImpl methods = new UserServiceImpl();

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//RequestDispatcher dispatcher = request.getRequestDispatcher("user-insert-form.jsp");

		//Mi serve l'id
		int id = Integer.parseInt(request.getParameter("id"));

		methods.getDelete(id);
		response.sendRedirect("user-list");

	}
}
