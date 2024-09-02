<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	int a; 
	
	System.out.println("hi");
	
	<%
		int k=10;
	%>
	<br><br>
	Print 1 => <%=k %>
	<br> 
	
	Print 2 => <%out.print(k); %>
	<br>
	
</body>
</html>