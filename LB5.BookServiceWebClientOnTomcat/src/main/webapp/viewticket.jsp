<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>View Ticket</title>
    <link href="css/default.css" rel="stylesheet">
</head>
<body>
<jsp:include page="jspf/head.jspf"></jsp:include>
<div>
    <h1>Ticket Details</h1>
    <c:choose>
        <c:when test="${not empty errorMsg}">
            <h2>${errorMsg}</h2>
        </c:when>
        <c:otherwise>
            <ul>
                <li>Ticket Number: ${ticket.ticketNumber}</li>
                <li>Seat Number: ${ticket.seatNumber}</li>
                <li>Purchase Date: ${ticket.purchaseDate}</li>
            </ul>

            <!-- Passenger Information -->
            <h3>Passenger Details</h3>
            <ul>
                <li>Name: ${ticket.passenger.name}</li>
                <li>Surname: ${ticket.passenger.surname}</li>
            </ul>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
