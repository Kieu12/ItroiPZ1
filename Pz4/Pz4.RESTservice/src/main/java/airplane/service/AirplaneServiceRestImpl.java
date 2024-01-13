package airplane.service;

import com.sun.research.ws.wadl.Application;
import airplane.additions.ReturnsAtomic;
import airplane.dao.DAOException;
import airplane.dao.AirplaneDAO;
import airplane.dao.AirplaneDAOInMemoryImpl;
import airplane.entity.Airplane;
import airplane.entity.Ticket;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Path(Constants.AIRPLANES_SERVICE_PATH)
public class AirplaneServiceRestImpl extends Application {

    private static final long LONG_WORK_WAIT_TIMEOUT = 1000;

    private static final int DEFAULT_THREAD_POOL_SIZE = 10;

    private AirplaneDAO store;

    ExecutorService executor = Executors.newFixedThreadPool(DEFAULT_THREAD_POOL_SIZE);

    private void log(String msg) {
        System.out.println(this.getClass().getSimpleName() + ": " + msg);
    }

    @PostConstruct
    public void init() {
        log("init");
        store = AirplaneDAOInMemoryImpl.instance();
    }

    @PreDestroy
    public void destroy() {
        log("destroy");
        store = null;
        executor.shutdown();
    }

    @Path("listAirplanes")
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response listAirplanes() {
        log("all");
        var airplanes = this.store.listAirplanes();
        System.out.println("getting all");
        return Response.ok(airplanes).build();
    }

    @Path("addAirplane")
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public ReturnsAtomic<Integer> addArticle(Airplane airplane) throws DAOException {
        log("add airplane");
        var id = store.addAirplane(airplane);
        return new ReturnsAtomic<Integer>(id);
    }

    @Path("addTicket")
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void addTicket(Ticket ticket) throws DAOException {
        log("add ticket");
        store.addTicket(ticket);
    }

    @Path("getTicket")
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Ticket getTicket(String ticketNumber) throws DAOException {
        log("get ticket");
        return store.getTicket(ticketNumber);
    }

    @Path("removeAirplane")
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void removeAirplane(int airplaneId) throws DAOException {
        log("delete ticket");
        store.removeAirplane(airplaneId);
    }
}
