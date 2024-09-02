<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="ListProductServlet" method="post">
           <input type="text" name="searchProduct" placeholder="Enter product name" required>
           <input type="submit" value="Search">
    </form>
</body>
</html>