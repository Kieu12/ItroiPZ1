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

public class AddTicketServlet extends HttpServlet {
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
            int airplaneId = Integer.parseInt(request.getParameter("airplaneId"));
            String seatNumber = request.getParameter("seatNumber");
            String purchaseDate = request.getParameter("purchaseDate");
            String passengerName = request.getParameter("passengerName"); // Added for passenger's name
            String passengerSurname = request.getParameter("passengerSurname"); // Added for passenger's surname
            String ticketNumber = request.getParameter("ticketNumber"); // Added for passenger's surname

            // Create a Ticket object and set its properties
            Ticket ticket = new Ticket();
            ticket.setTicketNumber(ticketNumber);
            ticket.setSeatNumber(seatNumber);
            ticket.setPurchaseDate(purchaseDate);

            // Create a Passenger object and set its properties
            Passenger passenger = new Passenger();
            passenger.setName(passengerName);
            passenger.setSurname(passengerSurname);

            // Set the Passenger for the Ticket
            ticket.setPassenger(passenger);

            log.debug("Get ticket from request : {}", ticket);

            // ----------------------------
            // TO DO: Validate ticket and passenger
            // ----------------------------

            // Send the request to the web-service to add the ticket
            service.addTicket(airplaneId, ticket);
            log.debug("Ticket added for airplane with ID: {}", airplaneId);
            Airplane airplane1;
            var airplanes = service.listAirplanes();
            for (var airplane : airplanes) {
                if (airplane.getId() == airplaneId) {
                    airplane1 = airplane;
                    session.setAttribute("airplane", airplane1);
                    break;
                }
            }
            // Redirect to viewairplane.jsp after adding the ticket
            response.sendRedirect("viewairplane.jsp");
            log.debug("Redirect to viewairplane.jsp");
            return; // Exit the method
        } catch (NumberFormatException e) {
            errMsg = "Error: Invalid input for Airplane ID";
            log.debug(DEBUG_ERROR_MSG, e);
        } catch (Exception e) {
            // Any other exceptions
            errMsg = "Error: Cannot communicate with the airplane service";
            log.debug(DEBUG_ERROR_MSG, e);
        }

        // If an error occurred, set the error message and redirect back to addTicket.jsp
        session.setAttribute("errorMsg", errMsg);
        response.sendRedirect("addTicket.jsp");
        log.debug("Redirect to addTicket.jsp");
    }
}
