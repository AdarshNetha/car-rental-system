<%@page import="assets.Car"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Available Cars</title>
<link rel="stylesheet" href="SeeAllAvailabeCars.css">
</head>
<body>

<% List<Car> availableCarList = (List<Car>) request.getAttribute("AvailabeCarList"); %>

<div class="container">

<% for(Car car : availableCarList){ %>

    <div class="car-card">
        <h2><%= car.getName() %></h2>
        <p><strong>Model:</strong> <%= car.getModel() %></p>
        <p><strong>Price:</strong> ₹<%= car.getPrice() %></p>
        <p><strong>Fuel Type:</strong> <%= car.getFuelType() %></p>

        <form action="bookcar" method="post">
            <input type="hidden" name="id" value="<%= car.getId() %>">

            <label>Your Name</label>
            <input name="username" required>

            <label>Contact Number</label>
            <input name="contactno" type="tel" maxlength="10" required>

            <label>From Date</label>
            <input type="date" name="from" required>

            <label>To Date</label>
            <input type="date" name="to" required>

            <button type="submit">Book Now</button>
        </form>
    </div>

<% } %>

</div>

</body>
</html>
