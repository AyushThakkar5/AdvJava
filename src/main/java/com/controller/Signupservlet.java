package com.controller;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Signupservlet")
public class Signupservlet extends HttpServlet
{
	public void service(HttpServletRequest request,HttpServletResponse response)
	{
		System.out.println("SignupServlet:service()");
	}
}
