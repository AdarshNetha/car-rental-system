<%@page import="assets.Car"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Car List</title>

<style>
    body {
        margin: 0;
        padding: 40px;
        background-color: #000000;
        font-family: 'Segoe UI', Arial, sans-serif;
        color: #ffffff;
    }

    h1 {
        text-align: center;
        margin-bottom: 30px;
        color: #FFD700;
        letter-spacing: 1px;
        text-shadow:
            0 0 8px rgba(255, 215, 0, 0.6),
            0 0 15px rgba(10, 88, 255, 0.6);
    }

    table {
        width: 100%;
        border-collapse: collapse;
        background-color: #000000;
        border: 2px solid #0A58FF; /* neon blue */
        box-shadow: 0 0 25px rgba(10, 88, 255, 0.4);
    }

    th {
        padding: 14px;
        color: #FFD700;
        font-size: 15px;
        border: 1.5px solid #0A58FF;
        text-transform: uppercase;
        letter-spacing: 0.5px;
    }

    td {
        padding: 12px;
        text-align: center;
        border: 1px solid #0A58FF;
        color: #ffffff;
        font-size: 14px;
    }

    tr:nth-child(even) {
        background-color: #020617; /* subtle dark row */
    }

    tr:hover {
        background-color: #0A58FF;
        color: #ffffff;
        transition: 0.3s ease;
    }

    tr:hover td {
        color: #ffffff;
    }
</style>
</head>

<body>

<h1>Available Cars</h1>

<%
    List<Car> carlist = (List<Car>) request.getAttribute("carlist");
%>

<table>
    <tr>
        <th>Car ID</th>
        <th>Car Name</th>
        <th>Model</th>
        <th>Price</th>
        <th>Car Number</th>
        <th>Owner</th>
        <th>Fuel Type</th>
        <th>Status</th>
    </tr>

<%
    for (Car c : carlist) {
%>
    <tr>
        <td><%= c.getId() %></td>
        <td><%= c.getName() %></td>
        <td><%= c.getModel() %></td>
        <td><%= c.getPrice() %></td>
        <td><%= c.getNumber() %></td>
        <td><%= c.getOwner() %></td>
        <td><%= c.getFuelType() %></td>
        <td><%= c.getStatus() %></td>
    </tr>
<%
    }
%>

</table>

</body>
</html>
