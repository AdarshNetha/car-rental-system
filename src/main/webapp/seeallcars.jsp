<%@page import="assets.Car"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<% List<Car> carlist= (List<Car>)request.getAttribute("carlist"); %>
	
	<table border="1" rules="all">
	<th>cid</th>
	<th>CarName</th>
	<th>CarModel</th>
	<th>CarPrice</th>
	<th>CarNumber</th>
	<th>Owner</th>
	<th>FuelType</th>
	<th>Status</th>
	<%for(Car c:carlist){
		%>
		<tr>
			<td><%=c.getId() %>
			<td><%=c.getName() %></td>
			<td><%=c.getModel() %></td>
			<td><%=c.getPrice() %></td>
			<td><%=c.getNumber() %></td>
			<td><%=c.getOwner() %></td>
			<td><%=c.getFuelType() %></td>
			<td><%=c.getStatus() %></td>
			
		</tr>
		
		
	<%} %>
	</table>

</body>
</html>