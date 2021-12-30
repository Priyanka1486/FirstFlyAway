<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirmation Page</title>
</head>
<body>
	 <h1>	Welcome : <%= session.getAttribute("name") %></h1>
	 <h2> Ticket Confirmation </h2>
	 <a href="homePage.html"> Home</a>
</body>
</html>