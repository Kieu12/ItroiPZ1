package ua.nure.airplane.service;

import jakarta.jws.WebService;
import ua.nure.airplane.dao.AirplaneDAO;
import ua.nure.airplane.dao.AirplaneDAOInMemoryImpl;
import ua.nure.airplane.entity.Airplane;
import ua.nure.airplane.entity.Ticket;

import java.util.Collection;

@WebService(serviceName="Airplane",
        portName="AirplanePort",
        endpointInterface="ua.nure.airplane.service.AirplaneService",
        targetNamespace="http://nure.ua/service")
public class AirplaneServiceImpl implements AirplaneService {

    private static AirplaneDAO airplaneDAO = AirplaneDAOInMemoryImpl.instance();

    @Override
    public int addAirplane(Airplane airplane) {
        return airplaneDAO.addAirplane(airplane);
    }

    @Override
    public void addTicket(int airplaneId, Ticket ticket) {
        airplaneDAO.addTicket(airplaneId, ticket);
    }

    @Override
    public Collection<Airplane> listAirplanes() {
        return airplaneDAO.listAirplanes();
    }

    @Override
    public Ticket getTicket(String ticketNumber) {
        return airplaneDAO.getTicket(ticketNumber);
    }

    @Override
    public void removeAirplane(int airplaneId) {
        airplaneDAO.removeAirplane(airplaneId);
    }

}
