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
@WebServlet("/DelproServlet")
public class DelproServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String dbUrl = "jdbc:mysql://localhost:3306/advjava";
        String username = "root";
        String password = "12345678";
        String delQuery = request.getParameter("searchProduct");
        try 
        {
        	Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(dbUrl, username, password);
            
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM products WHERE LOWER(productname) = ?");
            pstmt.setString(1, delQuery.toLowerCase());
            int rowsAffected = pstmt.executeUpdate();
            
            request.setAttribute("message", "Product deleted successfully.");
            request.getRequestDispatcher("ListProductServlet").forward(request, response);

        }
        catch (Exception e)
        {
        	e.printStackTrace();
        }
	}
}
