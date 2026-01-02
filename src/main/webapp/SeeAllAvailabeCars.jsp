<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" %>
<%@ page import="java.util.List" %>
<%@ page import="assets.Car" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Available Cars</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="SeeAllAvailabeCars.css">
</head>

<body>

<%
    List<Car> availableCarList =
        (List<Car>) request.getAttribute("AvailabeCarList");
%>

<div class="container">

    <% if (availableCarList != null && !availableCarList.isEmpty()) { %>

        <% for (Car car : availableCarList) { %>

            <div class="car-card">
                <h2><%= car.getName() %></h2>

                <p><strong>Model:</strong> <%= car.getModel() %></p>
                <p><strong>Price:</strong> ₹<%= car.getPrice() %></p>
                <p><strong>Fuel Type:</strong> <%= car.getFuelType() %></p>

                <hr>

                <form action="bookcar" method="post">
                    <input type="hidden" name="id" value="<%= car.getId() %>">

                    <label>Your Name</label>
                    <input type="text" name="username" required>

                    <label>Contact Number</label>
                    <input type="tel"
                           name="contactno"
                           maxlength="10"
                           pattern="[0-9]{10}"
                           placeholder="10-digit mobile number"
                           required>

                    <label>From Date</label>
                    <input type="date" name="from" required>

                    <label>To Date</label>
                    <input type="date" name="to" required>

                    <button type="submit">Book Now</button>
                </form>
            </div>

        <% } %>

    <% } else { %>

        <div class="no-data">
            <h2>No Cars Available</h2>
        </div>

    <% } %>

</div>

</body>
</html>
