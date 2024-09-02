package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/SaveProductServlet")
public class SaveProductServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String ProductName = request.getParameter("productName");
		Integer Price = Integer.parseInt(request.getParameter("price"));
		String Category = request.getParameter("category");
		Integer Qty = Integer.parseInt(request.getParameter("qty"));

		// validation {filter##,servlet}

		// db insert
		try {

			// driver load - memory
			Class.forName("com.mysql.cj.jdbc.Driver");

			// open conection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava","root","12345678");
			// query -> run -> PreparedStatement

			// insert into products (productName,proce,category,qty) values ();
			PreparedStatement pstmt = con.prepareStatement("insert into products (productname,price,category,qty) values (?,?,?,?)");
			pstmt.setString(1, ProductName);
			pstmt.setInt(2, Price);
			pstmt.setString(3, Category);
			pstmt.setInt(4, Qty);

			// run -> executeUpdate()
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("49");
		request.getRequestDispatcher("ListProductServlet").forward(request, response);
	}
}
