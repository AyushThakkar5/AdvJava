package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Loginservlet")
public class Loginservlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException , ServletException
	{
		System.out.println("Hi...from..LoginServlet");
		
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		out.print("<h2> Login Done </h2>");
	}
	
	
}
