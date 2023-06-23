<%@page import="org.shoping_kart.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
	<%
		User user = (User) session.getAttribute("user");
		if (user != null) {
	%>
	<h1>
		ID:<%=user.getId()%></h1>
	<h1>
		Name:<%=user.getName()%></h1>
	<h1>
		Email:<%=user.getEmail()%></h1>
	<h1>
		PhoneNo:<%=user.getPhone()%></h1>
	<h1>
		Gender:<%=user.getGender()%></h1>
	<h1>
		Age:<%=user.getAge()%></h1>

	<%
		} else {
			response.sendRedirect("Login.jsp");

		}
	%>
	</center>
</body>
</html>