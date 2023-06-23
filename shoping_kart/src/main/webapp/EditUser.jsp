<%@page import="org.shoping_kart.dto.User" %>
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
			User user=(User)session.getAttribute("user");
		if(user!=null){%>
		
			<form action="edit" method="post">
			ID:<input type="hidden" name="id" value="<%=user.getId()%>"><br>
		   Name:<input type="text" name="name" value="<%=user.getName()%>"><br>
		   Age:<input type="number" name="age" value="<%=user.getAge()%>"><br>
		   Gender:<input type="radio"name="gen" value="male">Male
			 <input type="radio" name="gen"value="female">Female <br>
		    Email:<input type="email"name="email" value="<%=user.getEmail()%>"><br>
			Phone:<input type="tel" name="phone" value="<%=user.getPhone()%>"><br>
		    Password<input type="password" name="pswd" value="<%=user.getPassword()%>"><br>
			 <input type="submit" value="UPDATE">
	<%}else{ 
	    	response.sendRedirect("Login.jsp");
	}
		%>
	</form>	
	</center>	
</body>
</html>