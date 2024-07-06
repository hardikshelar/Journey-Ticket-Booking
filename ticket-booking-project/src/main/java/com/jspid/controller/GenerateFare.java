package com.jspid.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value = "/fare")
public class GenerateFare extends HttpServlet {

	public int getFare(int fare, String journeyType, String passengers) {
		int Fare = fare;
		int TotalFare = Fare * Integer.parseInt(passengers);
		if (journeyType.equals("Return")) {
			return TotalFare * 2;
		}
		return TotalFare;
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String from = req.getParameter("from");
		String to = req.getParameter("to");
		String passengers = req.getParameter("passengers");
		String journeyType = req.getParameter("journeyType");
		
		HttpSession session = req.getSession();
		session.setAttribute("from", from);
		session.setAttribute("to", to);
		session.setAttribute("passengers", passengers);
		session.setAttribute("journeyType", journeyType);
		
		
		int fare = 0, totalFare = 0;
		if (from.equals("Borivali")) {
			if (to.equals("Virar")) {
				fare = 20;
				totalFare = getFare(20, journeyType, passengers);
			} else if (to.equals("Nalasopara")) {
				fare = 15;
				totalFare = getFare(15, journeyType, passengers);
			} else if (to.equals("Bhayandar")) {
				fare = 10;
				totalFare = getFare(10, journeyType, passengers);
			} else {
				fare = 12;
				totalFare = getFare(12, journeyType, passengers);
			}
		}
		session.setAttribute("Fare", totalFare);

		PrintWriter writer = resp.getWriter();
		writer.println("<html><body>");
		writer.println("<script>"
			    + "alert('Generated Fare From ' + '" + from + "' + ' To ' + '" + to + "' + ' is Of ' + '" + totalFare + "' + ' Rs. !');"
			    + "</script>");
		writer.println("</body></html>");
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("home.html");
		requestDispatcher.include(req, resp);
		
	}
	

}
