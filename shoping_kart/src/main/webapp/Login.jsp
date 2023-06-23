<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>	<%
		String message = (String) request.getAttribute("msg");
		if (message != null) {
	%>
	<h1><%=message%></h1>
	<%
		}
	%>
	<form action="login" method="post">
		<input type="tel" name="ph" placeholder="Enter phone Number"><br>
		<input type="password" name="pw" placeholder="Enter your Password"><br>
		<input type="submit" value="LOGIN">
	</form>
	<h1>
		<a href="Register.jsp">register here</a>
	</h1>
	</center>
	
</body>
</html>