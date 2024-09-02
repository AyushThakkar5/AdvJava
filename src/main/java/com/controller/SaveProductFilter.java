package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;



@WebFilter("/SaveProductServlet")
public  class SaveProductFilter implements Filter{

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String productName = request.getParameter("productName");
		String  productPrice = request.getParameter("price");
		String productCategory = request.getParameter("category");
		String productQty =  request.getParameter("qty");
		String numberRegEx = "[0-9]+";
		Integer productPriceN = null;
		Integer productQtyN = null;
		

		boolean isError =  false;
		System.out.println("filter");
		if(productName == null || productName.trim().length() == 0)
		{
			request.setAttribute("productNameError", "Enter ProuctName");
			isError = true;
			System.out.println("NameError");
		}//if
		if(productPrice == null || productPrice.trim().length() == 0)
		{
			request.setAttribute("productPriceError", "Enter ProuctName");
			isError = true;
			System.out.println("priceError");
		}//if
		if(productCategory == null || productCategory.trim().length() == 0)
		{
			request.setAttribute("productCategoryError", "Enter ProuctName");
			isError = true;
			System.out.println("CategoryError");
		}//if
		if(productQty == null || productQty.trim().length() == 0)
		{
			request.setAttribute("productQtyError", "Enter ProuctName");
			isError = true;
			System.out.println("QtyError");
		}//if
		
		if(!productPrice.matches(numberRegEx))
		{
			isError = true;
			System.out.println("Price Error Number Error");
			request.setAttribute("productPriceError", "Enter Only Number");
		}
		else
		{
			productPriceN = Integer.parseInt(productPrice);
		}
		if(!productQty.matches(numberRegEx))
		{
			isError = true;
			request.setAttribute("productQtyError", "Enter Only Number");
			
		}
		else
		{
			productQtyN = Integer.parseInt(productQty);
		}
		
		if(isError )
		{
			
			System.out.println("ISError ");
			request.setAttribute("Filter", "false");
			request.getRequestDispatcher("InputProduct.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("Filter", "true");
			chain.doFilter(request, response);
		}			
		
		
		
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	
}
