package airplane.dao;



import airplane.entity.Airplane;
import airplane.entity.Ticket;

import java.util.Collection;

public interface AirplaneDAO {
    public Collection<Airplane> listAirplanes();
    public void addTicket(Ticket ticket) ;
    public int addAirplane(Airplane airplane) ;
    public Ticket getTicket(String ticketNumber);
    public void removeAirplane(int airplaneId);

}