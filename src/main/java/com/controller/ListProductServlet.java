package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/ListProductServlet")
public class ListProductServlet extends HttpServlet 
{
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException 
    {
        System.out.println("DbConnection");
        String dbUrl = "jdbc:mysql://localhost:3306/advjava";
        String username = "root";
        String password = "12345678";
        String searchQuery = request.getParameter("searchProduct");

        try 
        {
           
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(dbUrl, username, password);

            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM products");
            ResultSet rs = pstmt.executeQuery();
            
            ResultSet r = null;
            if (searchQuery != null && !searchQuery.isEmpty()) 
            {
                PreparedStatement sqll = conn.prepareStatement("SELECT productname,price,category,qty FROM products WHERE LOWER(productname) LIKE ?");
                sqll.setString(1, "%" + searchQuery.toLowerCase() + "%");
                r = sqll.executeQuery();
            } 
            else 
            {
                r = rs;
            }
            request.setAttribute("r", r);
            request.getRequestDispatcher("InputSerach.jsp").forward(request, response);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
