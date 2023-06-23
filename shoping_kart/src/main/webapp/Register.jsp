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
	<form action="register" method="post">
		Name:<input type="text" name="name"><br> Age:<input
			type="number" name="age"><br> Gender:<input type="radio"
			name="gen" value="male">Male <input type="radio" name="gen"
			value="female">Female <br> Email:<input type="email"
			name="email"><br> Phone:<input type="tel" name="phone"><br>
		Password<input type="password" name="pswd"><br> <input
			type="submit" value="register">

	</form>
	</center>
</body>
</html>