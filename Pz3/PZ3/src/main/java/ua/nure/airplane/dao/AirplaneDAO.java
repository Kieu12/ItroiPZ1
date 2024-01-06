package ua.nure.airplane.dao;



import ua.nure.airplane.entity.*;

import java.util.Collection;

public interface AirplaneDAO {
    public Collection<Airplane> listAirplanes();
    public void addTicket(int airplaneId, Ticket ticket) ;
    public int addAirplane(Airplane airplane) ;
    public Ticket getTicket(String ticketNumber);
    public void removeAirplane(int airplaneId);
}