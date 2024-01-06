package ua.nure.airplane.dao;

import ua.nure.dbtable.DBTable;
import ua.nure.dbtable.DBTableFactory;
import ua.nure.dbtable.Filter;
import ua.nure.airplane.entity.*;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;

public class AirplaneDAOInMemoryImpl implements AirplaneDAO {
    DBTable<Airplane> airplanes = DBTableFactory.instance();

    private static AirplaneDAOInMemoryImpl instance;


    private AirplaneDAOInMemoryImpl() {
        initAirplanes();
    }

    public static synchronized AirplaneDAOInMemoryImpl instance() {
        if (instance == null) {
            instance = new AirplaneDAOInMemoryImpl();
        }
        return instance;
    }

    private Airplane newAirplane(String airplaneTitle, String duration, String destination, Collection<Ticket> tickets) {
        var airplane = new Airplane();
        airplane.setAirplaneTitle(airplaneTitle);
        airplane.setDuration(duration);
        airplane.setDestination(destination);
        airplane.getTicket().addAll(tickets);

        return airplane;
    }

    private Ticket newTicket(int id, String ticketNumber, String purchaseDate, String seatNumber, Passenger passenger) {
        Ticket ticket = new Ticket();
        ticket.setId(id);
        ticket.setTicketNumber(ticketNumber);
        ticket.setPurchaseDate(purchaseDate);
        ticket.setSeatNumber(seatNumber);
        ticket.setPassenger(passenger);
        return ticket;
    }

    private Passenger newPassenger(int id, String name, String surName) {
        var passenger = new Passenger();
        passenger.setName(name);
        passenger.setSurname(surName);
        passenger.setId(id);

        return passenger;
    }

    private void initAirplanes() {
        Airplane[] airplanes = new Airplane[] {
                newAirplane("SuperHero",
                        "02:00:00",
                        "3d",
                        Arrays.asList(newTicket(1, "dfg", "dfg", "dfg", newPassenger(1, "sdf", "sdf")))
                        ),
                newAirplane("sdfg",
                        "asdf",
                        "asdfasdf",
                        Arrays.asList(newTicket(1, "dfg", "dfg", "dfg", newPassenger(1, "sdf", "sdf")))
                ),
                newAirplane("sdfg",
                        "asdf",
                        "asdfasdf",
                        Arrays.asList(newTicket(1, "dfg", "dfg", "dfg", newPassenger(1, "sdf", "sdf")))
                ),
                newAirplane("sdfg",
                        "asdf",
                        "asdfasdf",
                        Arrays.asList(newTicket(1, "dfg", "dfg", "dfg", newPassenger(1, "sdf", "sdf")))
                ),
        };
        for (int i = 0; i < airplanes.length; i++) {
            addAirplane(airplanes[i]);
        }
    }

    @Override
    public Collection<Airplane> listAirplanes() { return this.airplanes.selectAll(); }

    @Override
    public void addTicket(int airplaneId, Ticket ticket) {
        Airplane airplane = null;
        try {
            airplane = this.airplanes.get(airplaneId);
            airplane.getTicket().add(ticket);
            this.airplanes.update(airplaneId, airplane);
        } catch (SQLException e) {
            //
        }
    }

    @Override
    public int addAirplane(Airplane airplane)  {
        int id = this.airplanes.insert(airplane);
        airplane.setId(id);
        try {
            this.airplanes.update(id, airplane);
        } catch (SQLException e) {

        }
        return id;
    }

    @Override
    public Ticket getTicket(String ticketNumber) {
        for (var airplane : this.airplanes.selectAll()) {
            for(var ticket : airplane.getTicket()) {
                if(ticket.getTicketNumber().equals(ticketNumber)) {
                    return ticket;
                }
            }
        }

        return null;
    }

    Filter<Airplane> airplaneById = new Filter<>() {
        @Override
        public boolean accept(Airplane item, Object pattern) {
            int p = (int) pattern;
            if(item.getId() == p) {
                return true;
            }

            return false;
        }
    };
    @Override
    public void removeAirplane(int airplaneId) {
        for (Airplane airplane : this.airplanes.selectAll()) {
            if (airplane.getId() == airplaneId) {
                try {
                    this.airplanes.delete(airplaneId);
                } catch (SQLException e) {
                    //
                }
                return;
            }
        }
    }
}
