package ua.nure.parser;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import ua.nure.entity.Airplane;
import ua.nure.entity.Passenger;
import ua.nure.entity.Ticket;


import javax.xml.XMLConstants;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class SAXParser extends DefaultHandler {
    private static final boolean LOG_ENABLED = false;

    public static void log(Object o) {
        if (LOG_ENABLED) {
            System.out.println(o);
        }
    }

    private String current;
    private List<Airplane> airplanes;
    private Ticket ticket;
    private Passenger passenger;
    private Airplane airplane;

    public List<Airplane> getAirplanes() {
        return airplanes;
    }

    @Override
    public void error(org.xml.sax.SAXParseException e) throws SAXException {
//		throw e; // throw exception if xml not valid
        System.err.println(e.getMessage());
    }

    public List<Airplane> parse(InputStream in, Schema schema) throws ParserConfigurationException, SAXException, IOException {

        /**
         * SAXParserFactory factory = SAXParserFactory.newInstance();
         *
         * // to be compliant, completely disable DOCTYPE declaration:
         * factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
         *
         * // or completely disable external entities declarations:
         * factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
         * factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
         *
         * // or prohibit the use of all protocols by external entities:
         * SAXParser parser = factory.newSAXParser(); // Noncompliant
         * parser.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "");
         * parser.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
         *
         */
        // XML parsers should not be vulnerable to XXE attacks
        // Fix by yourself
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setNamespaceAware(true);

        // make parser validating
//		factory.setFeature(Const.FEATURE__TURN_VALIDATION_ON, true);
//		factory.setFeature(Const.FEATURE__TURN_SCHEMA_VALIDATION_ON, true);

        factory.setSchema(schema);
        javax.xml.parsers.SAXParser parser = factory.newSAXParser();
        parser.parse(in, this);

        return this.airplanes;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {

        this.current = localName;

        if (Const.TAG_AIRPLANES.equals(this.current)) {
            this.airplanes = new ArrayList<>();
        } else if (Const.TAG_AIRPLANE.equals(this.current)) {
            this.airplane = new Airplane();
            if (attributes.getLength() > 0) {
                this.airplane.setId(Integer.parseInt(attributes.getValue("Id")));
            }
        } else if (Const.TAG_TICKET.equals(this.current)) {
            this.ticket = new Ticket();
            if (attributes.getLength() > 0) {
                this.ticket.setId(Integer.parseInt(attributes.getValue("Id")));
            }
        } else if (Const.TAG_PASSENGER.equals(this.current)) {
            this.passenger = new Passenger();
            if (attributes.getLength() > 0) {
                this.passenger.setId(Integer.parseInt(attributes.getValue("Id")));
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String value = new String(ch, start, length);
        if (value.isBlank()) {
            return;
        }
        if (Const.TAG_AIRPLANETITLE.equals(this.current)) {
            this.airplane.setAirplaneTitle(value);
        } else if (Const.TAG_DURATION.equals(this.current)) {
            this.airplane.setDuration(value);
        } else if (Const.TAG_DESTINATION.equals(this.current)) {
            this.airplane.setDestination(value);
        } else if (Const.TAG_TICKETNUMBER.equals(this.current)) {
            this.ticket.setTicketNumber(value);
        } else if (Const.TAG_SEATNUMBER.equals(this.current)) {
            this.ticket.setSeatNumber(value);
        } else if (Const.TAG_PURCHASEDATE.equals(this.current)) {
            this.ticket.setPurchaseDate(value);
        } else if (Const.TAG_NAME.equals(this.current)) {
            this.passenger.setName(value);
        } else if (Const.TAG_SURNAME.equals(this.current)) {
            this.passenger.setSurname(value);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (Const.TAG_AIRPLANE.equals(localName)) {
            this.airplanes.add(this.airplane);
            log(this.current + " " + this.airplane);
        } else if (Const.TAG_TICKET.equals(localName)) {
            this.airplane.getTicket().add(this.ticket);
            log(this.current + " " + this.ticket);
        } else if (Const.TAG_PASSENGER.equals(localName)) {
            this.ticket.setPassenger(this.passenger);
            log(this.current + " " + this.passenger);
        }
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        // Create against validation schema
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = sf.newSchema(new File(Const.XSD_FILE));

        System.out.println("--== SAX Parser ==--");
        SAXParser parser = new SAXParser();
        parser.parse(new FileInputStream("xml/airplanes.xml"), schema);
        List<Airplane> airplanes = parser.getAirplanes();
        System.out.println("====================================");
        System.out.println("Here is the airplanes: \n" + airplanes);
        System.out.println("====================================");
        parser.parse(new FileInputStream(Const.INVALID_XML_FILE), schema);
        airplanes = parser.getAirplanes();
        System.out.println("====================================");
        System.out.println("Here is the invalid airplanes: \n" + airplanes);
        System.out.println("====================================");
    }
}


