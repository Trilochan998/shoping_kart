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
		<% User u=(User)session.getAttribute("user"); 
		   if(u!=null){%>
		   <form action="addProduct" method="post">
			   Name:<input type="text" name="name"><br>
			   Description:<input type="text" name="desc"><br>
			   Brand:<input type="text" name="brand"><br>
			   Category:<input type="text" name="cat"><br>
			   Image:<input type="text" name="image"><br>
			   Price:<input type="number" name="price"><br>
			   <input type="submit" value="AddProduct">
			   
			   </form>
		   <%}else{
					response.sendRedirect("Login.jsp");
		   }
		   %>
		   </center>
</body>
</html>