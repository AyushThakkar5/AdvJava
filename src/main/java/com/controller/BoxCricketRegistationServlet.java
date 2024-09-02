package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/BoxCricketRegistationServlet")
public class BoxCricketRegistationServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String studentname = request.getParameter("studentname");
		String playertype = request.getParameter("playertype");
		
		request.setAttribute("studentNameValue", studentname);
		request.setAttribute("playerTypeValue", playertype);
		
		boolean isError = false;
		
		if(studentname == null || studentname.trim().length() == 0)
		{
			request.setAttribute("studentNameError", "Please Enter Student name");
			isError = true;
		}
		else
		{
			String alphaRegex = "[a-zA-Z]{2,}";
			if(studentname.matches(alphaRegex) == false)
				isError = true;
				request.setAttribute("studentNameError","Please Enter valid Student name " );
				
		}
		if(playertype == null || playertype.trim().length() == 0)
		{
			isError = true;
			request.setAttribute("playerTypeError", "Please Select Player Type");
		}
		if(isError==true)
		{
			RequestDispatcher rd = request.getRequestDispatcher("BoxCricketRegistration.jsp");
			rd.forward(request,response);
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("BoxCricketRegistrationSuccess.jsp");
			rd.forward(request,response);
			
		}
	}
}
