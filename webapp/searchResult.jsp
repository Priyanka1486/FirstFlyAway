<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Result</title>
</head>
<body>
  <h1>	Welcome : <%= session.getAttribute("name") %></h1> 
	<form action="checkoutPage" method="post"> 
		<table>
			<c:forEach var="flight" items="${flights}" >				
				<tr>
					<td>Flight Number</td>
					<td>:</td>	
					<td>${flight.flight_no}</td>
					<td></td>
				</tr>
				<tr>   
					<td>Airline</td>
					<td>:</td>
					<td>${flight.airline}</td>
					<td></td>
				</tr>
				<tr>
					<td>Cost per Person</td>
					<td>:</td>			
					<td>${flight.price}</td>
					<td></td> 					
				</tr>
				<tr>
					<td>Duration</td>
					<td>:</td>			
					<td>${flight.duration}</td>
					<td></td> 					
				</tr>

				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td><input type="submit"  name="${flight.flight_no}" value="Book" ></td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>