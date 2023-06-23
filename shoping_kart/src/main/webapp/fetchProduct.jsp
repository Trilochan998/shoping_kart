<%@page import="org.shoping_kart.dto.User"%>
<%@page import="java.util.List"%>
<%@page import="org.shoping_kart.dto.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <style media="screen">
        table {
            margin: 0 auto;
          border-collapse: collapse;
        }
        table td {
            padding: 0.5rem;
            border: 5px solid ;
        }
        table th {
            padding: 0.5rem;
            border: 5px solid ;
        }
         
    </style>
</head>
<body>
<center>
	<%
		User u = (User) session.getAttribute("user");
		if (u != null) {
	%>
	<%
		List<Product> products = (List<Product>) request.getAttribute("products");
	%>

	<table >
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Description</th>
			<th>Brand</th>
			<th>Category</th>
			<th>Image</th>
			<th>Price</th>
			<th>EditProduct</th>
			<th>DeleteProduct</th>
		</tr>
		<%
			for (Product p : products) {
		%>
		<tr>
			<td>
				<%
					out.println(p.getPid());
				%>
			</td>
			<td>
				<%
					out.println(p.getName());
				%>
			</td>
			<td>
				<%
					out.println(p.getDescription());
				%>
			</td>
			<td>
				<%
					out.println(p.getBrand());
				%>
			</td>
			<td>
				<%
					out.println(p.getCatagory());
				%>
			</td>
			<td>
				<%
					out.println(p.getImage());
				%>
			</td>
			<td>
				<%
					out.println(p.getPrice());
				%>
			</td>
			<td>
			<a href="find?pid=<%= p.getPid()%>">
				<%
					out.println("edit");
				%>
			</a>
			</td>
			<td>
			<a href="deleteproduct?pid=<%=p.getPid()%>">
				<%
					out.println("delete-product");
				%>
			</a>
			</td>

		</tr>
		<%
			}
		%>

	</table>

	<%
		} else {
			response.sendRedirect("Login.jsp");
		}
	%>
	</center>
</body>
</html>