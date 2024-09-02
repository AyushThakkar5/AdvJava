package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ClacServlet")
public class ClacServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String n1 = request.getParameter("no1");
		String n2 = request.getParameter("no2");
		
		boolean isError = false;
		String operations = request.getParameter("Operations");
		String error = "";
		
		if(n1 == null || n1.trim().length() == 0)
		{
			isError = true;
			error = "Please select number1 <br>";
		}
		if(n2 == null || n2.trim().length() == 0)
		{
			isError = true;
			error += "Please select number2 <br>";
		}
		if(operations == null)
		{
			isError = true;
			error += "Please select operations";
			
		}
		
		if(isError)
		{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.print(error);
		}
		else
		{
			Integer x = Integer.parseInt(n1);
			Integer y = Integer.parseInt(n2);
			int ans=0;
			
			if(operations.equals("+"))
			{
				ans=x+y;
			}
			else if(operations.equals("-"))
			{
				ans=x-y;
			}
			else if(operations.equals("*"))
			{
				ans=x*y;
			}
			else if(operations.equals("/"))
			{
				ans=x/y;
			}
			
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.print("ans: "+ans);
			
		
		}
	}
}
