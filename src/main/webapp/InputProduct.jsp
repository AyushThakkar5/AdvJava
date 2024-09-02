<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Add New Product</h2>
	<form action="SaveProductServlet" method="post">
		ProductName : <input type="text" name="productName" /><br>
		<br> Price:<input type="text" name="price" /><br>
		<br> Category:<input type="text" name="category" /><br>
		<br> Qty: <input type="text" name="qty" /><br>
		<br>
		<input type="submit" value="Save Product"/>
	</form>
</body>
</html>