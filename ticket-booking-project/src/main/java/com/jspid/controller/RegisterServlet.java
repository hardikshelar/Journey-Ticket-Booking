package com.jspid.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspid.model.Registered_Users;
import com.jspid.utility.Hibernate_Utility;

@WebServlet(value = "/register")
public class RegisterServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");

		Registered_Users alreadyUser = Hibernate_Utility.entityManager.find(Registered_Users.class, username);
		PrintWriter writer = resp.getWriter();
		
		if (alreadyUser != null && username.equals(alreadyUser.getUsername())) {
			
			writer.println("<html><body>");
			writer.println("<script>"
					+ "alert('Username Already Registered !! Please Registered With Another Username');" 
					+ "</script>");
			writer.println("</body></html>");
			
		} else {
			Hibernate_Utility.transaction.begin();
			Registered_Users user = new Registered_Users(username, password, email, phone);

			Hibernate_Utility.entityManager.persist(user);
			Hibernate_Utility.transaction.commit();
			
			
			writer.println("<html><body>");
			writer.println("<script>"
					+ "alert('Sucessfully Registered !! Please Login!');" 
					+ "</script>");
			writer.println("</body></html>");

		}
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("register.html");
		requestDispatcher.include(req, resp);

	}

}
