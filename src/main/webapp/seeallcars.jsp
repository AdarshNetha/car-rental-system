<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" %>
<%@ page import="java.util.List" %>
<%@ page import="assets.Car" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Car List</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<style>
    * {
        box-sizing: border-box;
    }

    body {
        margin: 0;
        padding: 20px;
        background-color: #000000;
        font-family: 'Segoe UI', Arial, sans-serif;
        color: #ffffff;
    }

    h1 {
        text-align: center;
        margin-bottom: 25px;
        color: #FFD700;
        letter-spacing: 1px;
        text-shadow:
            0 0 8px rgba(255, 215, 0, 0.6),
            0 0 15px rgba(10, 88, 255, 0.6);
    }

    /* Table container for mobile scroll */
    .table-container {
        width: 100%;
        overflow-x: auto;
    }

    table {
        width: 100%;
        min-width: 900px; /* IMPORTANT */
        border-collapse: collapse;
        background-color: #000000;
        border: 2px solid #0A58FF;
        box-shadow: 0 0 25px rgba(10, 88, 255, 0.4);
    }

    th {
        padding: 14px;
        color: #FFD700;
        font-size: 14px;
        border: 1.5px solid #0A58FF;
        text-transform: uppercase;
        letter-spacing: 0.5px;
        white-space: nowrap;
    }

    td {
        padding: 12px;
        text-align: center;
        border: 1px solid #0A58FF;
        color: #ffffff;
        font-size: 14px;
        white-space: nowrap;
    }

    tr:nth-child(even) {
        background-color: #020617;
    }

    tr:hover {
        background-color: #0A58FF;
        color: #ffffff;
        transition: 0.3s ease;
    }

    tr:hover td {
        color: #ffffff;
    }

    .no-data {
        text-align: center;
        margin-top: 40px;
        font-size: 20px;
        color: #FFD700;
    }

    /* 📱 Mobile */
    @media (max-width: 480px) {
        body {
            padding: 12px;
        }

        h1 {
            font-size: 24px;
        }
    }
</style>
</head>

<body>

<h1>Available Cars</h1>

<%
    List<Car> carlist = (List<Car>) request.getAttribute("carlist");

    if (carlist != null && !carlist.isEmpty()) {
%>

<div class="table-container">
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
</div>

<%
    } else {
%>

<div class="no-data">No Cars Available</div>

<%
    }
%>

</body>
</html>
