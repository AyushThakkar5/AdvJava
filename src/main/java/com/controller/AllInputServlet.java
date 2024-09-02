package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/AllInputServlet")
public class AllInputServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
	String FirstName = request.getParameter("FirstName");
	String BirthYear = request.getParameter("BirthName");
	String Email = request.getParameter("Email");
	String Password = request.getParameter("Password");
	String Gender = request.getParameter("Gender");
	String City = request.getParameter("City");
	String Address = request.getParameter("Address");
	
	String Hobby[] = request.getParameterValues("hobby");
	
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	
	out.print("FirstName: "+FirstName+"<br><br>");
	out.print("BirthtName: "+BirthYear+"<br><br>");
	out.print("Email: "+Email+"<br><br>");
	out.print("Password: "+Password+"<br><br>");
	out.print("Gender: "+Gender+"<br><br>");
	out.print("City: "+City+"<br><br>");
	out.print("Address: "+Address+"<br><br>");
	out.print("Hobby: ");
	
	Boolean iserror = false;
	String message = "";
	
	if(FirstName == null || FirstName.trim().length() == 0)
	{
		iserror = true;
		message = "<br>Please Enter First Name.";
	}
	if(BirthYear == null || BirthYear.trim().length() == 0)
	{
		iserror = true;
		message += "<br>Please Enter Birthday Year.";
	}
	if(Email == null || Email.trim().length() == 0)
	{
		iserror = true;
		message += "<br>Please Enter email.";
	}
	if(Password == null || Password.trim().length() == 0)
	{
		iserror = true;
		message += "<br>Please Enter Password.";
	}
	if(Gender == null || Gender.trim().length() == 0)
	{
		iserror = true;
		message += "<br>Please Select Gender";
	}
	if(City == null || City.trim().length() == 0)
	{
		iserror = true;
		message += "<br>Please Select city";
	}
	if(Address == null || Address.trim().length() == 0)
	{
		iserror = true;
		message += "<br>Please Enter Address";
	}
	if(Hobby == null)
	{
		iserror = true;
		message += "<br>Please Select Hobby";
	}
	
	if(iserror)
	{
		
		out.print(message);
	}
	else
	{
	 	out.print("FirstName : "+FirstName+"<br><br>");
		out.print("Birthyear : "+BirthYear+"<br><br>");
		out.print("Email : "+Email+"<br><br>");
		out.print("Password : "+Password +"<br><br>");
		out.print("Gender : "+Gender +"<br><br>");
		out.print("City : "+City +"<br><br>");
		out.print("Address : "+Address +"<br><br>");
		
		out.print("Hobby: ");
		for(int i=0;i<Hobby.length;i++)
		{
			response.setContentType("text/html");
			PrintWriter oo = response.getWriter();
			oo.print(Hobby[i]+" ");
		}
}
}
}
