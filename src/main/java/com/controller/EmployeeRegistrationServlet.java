package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EmployeeRegistrationServlet")
public class EmployeeRegistrationServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String FirstName = request.getParameter("FirstName");
		String Email = request.getParameter("Email");
		String Password = request.getParameter("Password");
		String BirthYear = request.getParameter("BirthYear");

	}
}
