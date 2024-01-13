<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add Ticket</title>
    <link href="css/default.css" rel="stylesheet">
</head>
<body>
<jsp:include page="jspf/head.jspf"></jsp:include>
<div>
    <h1>Add Ticket</h1>
    <form action="addTicket" method="post">
        <label for="airplaneId">Airplane ID:</label>
        <input type="number" name="airplaneId" id="airplaneId" required />
        <br/>
        <label for="ticketNumber">Ticket Number:</label>
        <input type="text" name="ticketNumber" id="ticketNumber" required />
        <br/>
        <label for="seatNumber">Seat Number:</label>
        <input type="text" name="seatNumber" id="seatNumber" required />
        <br/>
        <label for="purchaseDate">Purchase Date:</label>
        <input type="text" name="purchaseDate" id="purchaseDate" required />
        <br/>
        <!-- Passenger Name -->
        <label for="passengerName">Passenger Name:</label>
        <input type="text" name="passengerName" id="passengerName" required />
        <br/>
        <!-- Passenger Surname -->
        <label for="passengerSurname">Passenger Surname:</label>
        <input type="text" name="passengerSurname" id="passengerSurname" required />
        <br/>
        <input type="submit" value="Add" />
    </form>
</div>
</body>
</html>
