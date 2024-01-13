package airplane.service;

import airplane.dao.AirplaneDAO;
import airplane.dao.AirplaneDAOInMemoryImpl;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

public class AirplaneSearcher {
    private AirplaneDAO store = AirplaneDAOInMemoryImpl.instance();
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void search(@QueryParam("pattern") String pattern) {
        System.out.println("search for Airplanes: " + pattern);
    }
}
