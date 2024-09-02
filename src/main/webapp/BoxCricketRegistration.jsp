<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String studentNameError = (String)request.getAttribute("studentNameError");
		String playerTypeError = (String)request.getAttribute("playerTypeError");
		
		String studentNameValue = (String) request.getAttribute("studentNameValue");
		String playerTypeValue = (String) request.getAttribute("playerTypeValue");
	%>
	<h2>Box Cricket Registration</h2>
	
	<form action="BoxCricketRegistationServlet" method="post">
		StudentName : <input type="text" name="studentname" value="<%=studentNameValue==null?"":studentNameValue %>" />
		<%=studentNameError == null ? "" : studentNameError %>
		<br><br>
		PlayerType : <select name="playertype">
			<option value="">Please select the field </option>
			<option value="Batsman" <%=playerTypeValue!=null&&playerTypeValue.contains("batsman")?"selected":""%>>Batsman</option>
			<option value="Bolwer" <%=playerTypeValue!=null&&playerTypeValue.contains("bowler")?"selected":""%>>Bolwer</option>
			<option value="allrounder" <%=playerTypeValue!=null&&playerTypeValue.contains("allrounder")?"selected":""%>>Allrounder</option>
		</select>
		<%=playerTypeError == null ? "" :playerTypeError %>
		<br><br>
		<input type="submit" value="Register">
	</form>
</body>
</html>