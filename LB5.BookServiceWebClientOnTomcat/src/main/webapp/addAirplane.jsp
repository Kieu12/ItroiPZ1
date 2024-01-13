<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Add Airplane</title>
	<link href="css/default.css" rel="stylesheet">
</head>
<body>
<jsp:include page="jspf/head.jspf"></jsp:include>
<div>
	<form action="add" method="post">
		<h1>Add Airplane</h1>
		<label for="airplaneTitle">Airplane Title:</label>
		<input type="text" name="airplaneTitle" id="airplaneTitle" required/><br/>

		<label for="durationAirplane">Airplane Duration:</label>
		<input type="text" name="durationAirplane" id="durationAirplane" required/><br/>

		<label for="destinationAirplane">Airplane Show Type:</label>
		<input type="text" name="destinationAirplane" id="destinationAirplane" required/><br/>

		<!-- Input field for specifying the number of tickets -->
		<label for="numTickets">Number of Tickets:</label>
		<input type="number" name="numTickets" id="numTickets" min="1" required/><br/>

		<!-- Dynamic generation of ticket input forms based on the number specified above -->
		<div id="ticketForms"></div>

		<!-- JavaScript to generate ticket input forms based on the number specified -->
		<script>
			function generateTicketForms() {
				var numTickets = parseInt(document.getElementById('numTickets').value);
				var ticketForms = document.getElementById('ticketForms');
				ticketForms.innerHTML = ''; // Clear previous forms

				for (var i = 1; i <= numTickets; i++) {
					ticketForms.innerHTML += '<h2>Ticket ' + i + '</h2>' +
							'<label for="ticketNumber' + i + '">Ticket Number ' + i + ':</label>' +
							'<input type="text" name="ticketNumber' + i + '" id="ticketNumber' + i + '" required/><br/>' +
							'<label for="seatNumber' + i + '">Seat Number ' + i + ':</label>' +
							'<input type="text" name="seatNumber' + i + '" id="seatNumber' + i + '" required/><br/>' +
							'<label for="purchaseDate' + i + '">Purchase Date ' + i + ':</label>' +
							'<input type="text" name="purchaseDate' + i + '" id="purchaseDate' + i + '" required/><br/>' +
							'<label for="passengerName' + i + '">Passenger Name ' + i + ':</label>' +
							'<input type="text" name="passengerName' + i + '" id="passengerName' + i + '" required/><br/>' +
							'<label for="passengerSurname' + i + '">Passenger Surname ' + i + ':</label>' +
							'<input type="text" name="passengerSurname' + i + '" id="passengerSurname' + i + '" required/><br/>';
				}
			}

			// Trigger the function on page load
			generateTicketForms();

			// Add an event listener to the "Number of Tickets" input
			document.getElementById('numTickets').addEventListener('input', generateTicketForms);
		</script>

		<br/>
		<input type="submit" value="Submit"/>
	</form>
</div>
</body>
</html>
