<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
	
	  <h1> Welcome : <%= session.getAttribute("name") %> </h1>
	<form action="dashboard" method="post">
		<table>
			<tr>
				<td><label>From : </label></td>
				<td><input type="text" name="source" required="required"></td>
			</tr>
			<tr></tr>
			<tr>
				<td><label>To : </label></td>
				<td><input type="text" name="destination" required="required" ></td>
			</tr>
			<tr></tr>
			<tr>
				<td><label>Date : </label></td>
				<td><input type="date" name="traveldate" required="required"></td>
			</tr>
			<tr></tr>
			<tr>
				<td><label>Number of Passengers : </label></td>
				<td><input type="number" name="passengers" required="required" ></td>
			</tr>
			<tr></tr>
			<tr>
				<td><input type="submit" value="Search"></td>
				<td></td>
			</tr>
			<tr></tr>
			
		</table>
	</form>
</body>
</html>