<%@page import="assets.Booking"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body{
	display: flex;
	flex-wrap: wrap;
	
}
	div{
	height: 300px;
	width: 200px		
	}
	form{
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items:  center;
	}
		
</style>
</head>
<body>
	
	<% List<Booking> bookedcars =(List<Booking>)request.getAttribute("bookinglist"); %>
	
	
	<% for(Booking b: bookedcars){
	%><div>
		<form action="delete-booking" method="post">
		<input name="cid" value="<%= b.getCarid() %>" readonly>
		BookingId:<input name="bid" value="<%=b.getId() %>" readonly >
		CoustmerName:<%= b.getCname() %>
		CoustmerPhone:<%=b.getPhno() %>
		FromDate:<%=b.getFromDate() %>
		ToDate:<%=b.getToDate() %>
		<button type="submit" >Returned</button>
	</form> 
	</div>
	<%} %>
	
</body>
</html>