package ua.nure.server.client.web;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.nure.entity.Airplane;
import ua.nure.entity.Ticket;
import ua.nure.entity.Passenger;
import ua.nure.service.AirplaneService;

import java.io.IOException;

public class AddAirplaneServlet extends HttpServlet {
    private static final String DEBUG_ERROR_MSG = "Set errorMsg to the session";
    private static final long serialVersionUID = 1L;
    private final transient Logger log = LoggerFactory.getLogger(AddAirplaneServlet.class);

    private transient AirplaneService service;

    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext ctx = getServletContext();
        service = (AirplaneService) ctx.getAttribute("AirplaneService");
        log.trace("Get attribute AirplaneService : {}",service);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String errMsg = null;

        try {
            Airplane airplane = new Airplane();
            airplane.setAirplaneTitle(request.getParameter("airplaneTitle"));
            airplane.setDuration(request.getParameter("durationAirplane"));
            airplane.setDestination(request.getParameter("destinationAirplane"));

            int numTickets = Integer.parseInt(request.getParameter("numTickets"));

            for (int i = 1; i <= numTickets; i++) {
                Ticket ticket = new Ticket();
                ticket.setTicketNumber(request.getParameter("ticketNumber" + i)); // Assuming you have a "ticketNumber" field
                ticket.setSeatNumber(request.getParameter("seatNumber" + i)); // Assuming you have a "seatNumber" field
                ticket.setPurchaseDate(request.getParameter("purchaseDate" + i)); // Assuming you have a "purchaseDate" field

                Passenger passenger = new Passenger();
                passenger.setName(request.getParameter("passengerName" + i));
                passenger.setSurname(request.getParameter("passengerSurname" + i));

                ticket.setPassenger(passenger);

                airplane.getTicket().add(ticket);
            }

            // Perform any necessary validation on the airplane object here.

            // Send the airplane object to your service to add it.
            int id = service.addAirplane(airplane);

            // Set the airplane object into the session attribute.
            session.setAttribute("airplane", airplane);

            // Redirect to a success page or display a success message.
            response.sendRedirect("viewairplane.jsp");
        } catch (Exception e) {
            // Handle any exceptions, such as validation errors or communication errors.
            errMsg = "Error: " + e.getMessage();
            log.error("Error processing airplane data: " + e.getMessage(), e);
        }

        if (errMsg != null) {
            session.setAttribute("errorMsg", errMsg);
            response.sendRedirect("addairplane.jsp"); // Redirect back to the form with an error message.
        }
    }

}
