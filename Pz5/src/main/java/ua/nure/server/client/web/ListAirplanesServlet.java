package ua.nure.server.client.web;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.nure.entity.Airplane;
import ua.nure.service.AirplaneService;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class ListArticles
 */
public class ListAirplanesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final transient Logger log = LoggerFactory.getLogger(ListAirplanesServlet.class);

	private AirplaneService service;

	@Override
	public void init() throws ServletException {
		super.init();
		ServletContext ctx = getServletContext();
		service = (AirplaneService) ctx.getAttribute("AirplaneService");
		log.trace("Get attribute AirplaneService : {}",service);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Airplane> airplanes = service.listAirplanes();
		log.debug("Get airplane from AirplaneService : {}", airplanes);
		request.setAttribute("airplanes", airplanes);
		log.trace("Set airplanes to the session : {}", airplanes);
		request.getRequestDispatcher("list.jsp").forward(request, response);
		log.trace("Redirect to list.jsp");
	}

}
