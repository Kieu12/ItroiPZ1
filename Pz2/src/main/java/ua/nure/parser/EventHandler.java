package ua.nure.parser;


import ua.nure.entity.Airplane;
import ua.nure.entity.Passenger;
import ua.nure.entity.Ticket;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import javax.xml.stream.events.*;
import java.util.ArrayList;
import java.util.List;

public class EventHandler {
    private static final boolean LOG_ENABLED = true;

    private String current;
    private Ticket ticket;
    private Airplane airplane;
    private Passenger passenger;
    private List<Airplane> airplanes;

    private static void log(Object o) {
        if (LOG_ENABLED) {
            System.out.println(o);
        }
    }

    public void endElement(XMLEvent event) {
        EndElement endElement = event.asEndElement();
        String localName = endElement.getName().getLocalPart();
        if (Const.TAG_AIRPLANE.equals(localName)) {
            this.airplanes.add(this.airplane);
            log("airplane add");
        } else if (Const.TAG_TICKET.equals(localName)) {
            this.airplane.getTicket().add(this.ticket);
            log("ticket add" + this.ticket.getTicketNumber());
        } else if (Const.TAG_PASSENGER.equals(localName)) {
            this.ticket.setPassenger(this.passenger);
            log("passenger add" + this.passenger.getName());
        }
    }

    public void characters(XMLEvent event) {
        Characters characters = event.asCharacters();
        String value = characters.getData();
        log("Characters: " + this.current);
        if (Const.TAG_AIRPLANETITLE.equals(this.current)) {
            this.airplane.setAirplaneTitle(value);
            log("airplane-title add: " + this.airplane.getAirplaneTitle());
        } else if (Const.TAG_DURATION.equals(this.current)) {
            this.airplane.setDuration(value);
            log("airplane-duration add: " + this.airplane.getDuration());
        } else if (Const.TAG_DESTINATION.equals(this.current)) {
            this.airplane.setDestination(value);
            log("airplane-destination add: " + this.airplane.getDestination());
        } else if (Const.TAG_TICKETNUMBER.equals(this.current)) {
            this.ticket.setTicketNumber(value);
            log("ticket-number add: " + this.ticket.getTicketNumber());
        } else if (Const.TAG_SEATNUMBER.equals(this.current)) {
            this.ticket.setSeatNumber(value);
            log("ticket-seatnumber add: " + this.ticket.getSeatNumber());
        } else if (Const.TAG_PURCHASEDATE.equals(this.current)) {
            this.ticket.setPurchaseDate(value);
            log("ticket-seatnumber add: " + this.ticket.getPurchaseDate());
        } else if (Const.TAG_NAME.equals(this.current)) {
            this.passenger.setName(value);
            log("passenger-name add: " + this.passenger.getName());
        } else if (Const.TAG_SURNAME.equals(this.current)) {
            this.passenger.setSurname(value);
            log("passenger-surname add: " + this.passenger.getSurname());
        }
    }

    public void startElement(XMLEvent event) {
        StartElement startElement = event.asStartElement();
        this.current = startElement.getName().getLocalPart();
        log("StartElement: " + startElement.getName());
        Attribute attr = startElement.getAttributeByName(new QName(Const.ATTRIBUTE_ID));

        if (Const.TAG_AIRPLANES.equals(this.current)) {
            this.airplanes = new ArrayList<>();
        } else if (Const.TAG_AIRPLANE.equals(this.current)) {
            this.airplane = new Airplane();
            if (attr != null) {
                this.airplane.setId(Integer.parseInt(attr.getValue()));
            }
        } else if (Const.TAG_TICKET.equals(this.current)) {
            this.ticket = new Ticket();
            if (attr != null) {
                this.ticket.setId(Integer.parseInt(attr.getValue()));
            }
        } else if (Const.TAG_PASSENGER.equals(this.current)) {
            this.passenger = new Passenger();
            if (attr != null) {
                this.passenger.setId(Integer.parseInt(attr.getValue()));
            }
        }
    }

    public List<Airplane> getAirplanes() {
        return airplanes;
    }
}
