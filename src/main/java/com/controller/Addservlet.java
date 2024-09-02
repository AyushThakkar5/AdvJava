package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Addservlet")
public class Addservlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
//		String number1 = request.getParameter("No1");
//		String number2 = request.getParameter("No2");
		
		int number1 = Integer.parseInt(request.getParameter("number1"));
		int number2 = Integer.parseInt(request.getParameter("number2"));
		
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		out.print("<h2> Login Done </h2>");
		out.print("Sum:"+(number1+number2));
	}
}
