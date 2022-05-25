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

@WebServlet("/user-list")
public class UserList extends HttpServlet {
	UserServiceImpl methods = new UserServiceImpl();

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//Definisce un obj che riceve richieste dal client e le manda alla servlet specificata
		//La servlet prende la request dalla pagina specificata
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		
        List<User> listUser = methods.getUsers();
		
		//Tramite Java assegno la lista listUser come attributo della request
		request.setAttribute("listUser", listUser);
		/*try {
			listUser(request);
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}*/
		
		//Passo la request per creare la response da inviare alla pagine
		dispatcher.forward(request, response);

	}

	/*private void listUser(HttpServletRequest request)
			throws SQLException, IOException, ServletException {

		List<User> listUser = methods.getUsers();
		
		//Tramite Java assegno la lista listUser come attributo della request
		request.setAttribute("listUser", listUser);
				

	}*/

}
