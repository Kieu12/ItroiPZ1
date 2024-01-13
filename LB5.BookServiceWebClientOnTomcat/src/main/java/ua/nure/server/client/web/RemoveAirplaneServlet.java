package ua.nure.server.client.web;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.nure.service.AirplaneService;

import java.io.IOException;

/**
 * Servlet implementation class RemoveAirplane
 */
public class RemoveAirplaneServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final transient Logger log = LoggerFactory.getLogger(RemoveAirplaneServlet.class);

    private AirplaneService service;

    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext ctx = getServletContext();
        service = (AirplaneService) ctx.getAttribute("AirplaneService");
        log.trace("Get attribute AirplaneService : {}", service);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int airplaneId = Integer.parseInt(request.getParameter("airplaneId"));
        log.debug("Received airplaneId to remove: {}", airplaneId);

        try {
            service.removeAirplane(airplaneId);
            log.info("Airplane with ID {} removed successfully", airplaneId);

            var airplanes = service.listAirplanes();
            request.getSession().setAttribute("airplanes", airplanes);
            // Redirect to a success page or list of airplanes
            response.sendRedirect("list.jsp"); // Example redirect
        } catch (Exception e) {
            log.error("Error removing airplane: {}", e.getMessage());
            // Handle the error gracefully, e.g., display an error message
            request.setAttribute("error", "Failed to remove airplane");
            request.getRequestDispatcher("error.jsp").forward(request, response); // Example error handling
        }
    }
}