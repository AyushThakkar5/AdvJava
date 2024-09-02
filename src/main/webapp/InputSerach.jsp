<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product List</title>
</head>
<body>
<%
	ResultSet r =(ResultSet) request.getAttribute("r");
%>
	<h2>List Products</h2>

		<table border="1">
		<tr>  
			<th>Name</th>
			<th>Category</th>
			<th>Price</th>
		</tr>
<% 
		 while(r.next())
			 {
			 String pName = r.getString("productname");
				String category = r.getString("category");
				Integer price = r.getInt("price");
				out.println("<tr>");
				out.print("<td>" + pName + "</td>");
				out.print("<td>" + category + "</td>");
				out.print("<td>" + price + "</td>");
			 }
%>
</body>
</html>
