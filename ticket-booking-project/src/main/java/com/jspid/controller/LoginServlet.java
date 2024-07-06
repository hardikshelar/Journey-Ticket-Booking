package com.jspid.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspid.model.Registered_Users;
import com.jspid.utility.Hibernate_Utility;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {
	public static EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("pgadmin");

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		
		Registered_Users registeredUser = Hibernate_Utility.entityManager.find(Registered_Users.class, username);
		PrintWriter writer = resp.getWriter();
		if (registeredUser != null && registeredUser.getUsername() != null) {
			if (registeredUser.getUsername().equals(username) && registeredUser.getPassword().equals(password)) {

				session.setAttribute("username", username);
//				session.setAttribute("password", password);
				
				session.setMaxInactiveInterval(10);

				RequestDispatcher requestDispatcher = req.getRequestDispatcher("ticketFare.jsp");
				requestDispatcher.forward(req, resp);

			} else if (registeredUser.getUsername().equals(username)
					&& !registeredUser.getPassword().equals(password)) {
				
				writer.println("<html><body>");
				writer.println("<script>" + "alert('Incorrect Password!');" + "</script>");
				writer.println("</body></html>");
			}
		} else {
			
			writer.println("<html><body>");
			writer.println("<script>" + "alert('No User Is Registered With This Credentials! Please Register First');" + "</script>");
			writer.println("</body></html>");
		}
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.html");
		requestDispatcher.include(req, resp);
		
	}

}
