<%@page import="org.shoping_kart.dto.Product"%>
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
		User u = (User) session.getAttribute("user");
		if (u != null) {
	
		Product p=	(Product)request.getAttribute("products");
	%>

		   <form action="editProduct" method="post">
		   		pId:<input type="hidden" name="pid" value="<%= p.getPid()%>"><br>
			   Name:<input type="text" name="name" value="<%= p.getName()%>"><br>
			   Description:<input type="text" name="desc" value="<%= p.getDescription()%>"><br>
			   Brand:<input type="text" name="brand" value="<%= p.getBrand()%>"><br>
			   Category:<input type="text" name="cat" value="<%= p.getCatagory()%>"><br>
			   Image:<input type="text" name="image" value="<%= p.getImage()%>"><br>
			   Price:<input type="number" name="price" value="<%= p.getPrice()%>"><br>
			   <input type="submit" value="UpdateProduct">
			   
			   </form>
		   <%}else{
			   response.sendRedirect("Login.jsp");
		   }
			   %>
		   
	
	
	
	
	
	  </center>
</body>
</html>