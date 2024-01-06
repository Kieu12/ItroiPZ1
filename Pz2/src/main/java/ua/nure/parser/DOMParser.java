package ua.nure.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;
import ua.nure.entity.Airplane;
import ua.nure.entity.Passenger;
import ua.nure.entity.Ticket;

public class DOMParser {
    private static boolean logEnabled = true;

    private static void log(Object o) {
        if (logEnabled) {
            System.out.println(o);
        }
    }

    private Airplane parseAirplane(Node node) {
        Airplane airplane = new Airplane();
        Integer attrId = this.GetAttributeIdFromNode(node);
        if (attrId != null) {
            airplane.setId(attrId);
        }
        NodeList nodes = node.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node item = nodes.item(i);
            String localName = item.getLocalName();
            String textContent = item.getTextContent();
            log(localName);
            if (Const.TAG_TICKET.equals(localName)) {
                airplane.getTicket().add(parseTicket(item));
                log("add ticket" + item);
            } else if (Const.TAG_AIRPLANETITLE.equals(localName)) {
                airplane.setAirplaneTitle(textContent);
                log("add airplanetitle" + textContent);
            } else if (Const.TAG_DURATION.equals(localName)) {
                airplane.setDuration(textContent);
                log("add airplane duration" + textContent);
            } else if (Const.TAG_DESTINATION.equals(localName)) {
                airplane.setDestination(textContent);
                log("add airplane destination" + textContent);
            }
        }

        return airplane;
    }

    private Ticket parseTicket(Node node)  {
        Ticket ticket = new Ticket();
        Integer attrId = this.GetAttributeIdFromNode(node);
        if (attrId != null) {
            ticket.setId(attrId);
        }
        NodeList nodes = node.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node item = nodes.item(i);
            String localName = item.getLocalName();
            String textContent = item.getTextContent();
            log(localName);
            if (Const.TAG_TICKETNUMBER.equals(localName)) {
                ticket.setTicketNumber(textContent);
                log("add ticket number" + textContent);
            } else if (Const.TAG_SEATNUMBER.equals(localName)) {
                ticket.setSeatNumber(textContent);
                log("add ticket seat number" + textContent);
            } else if (Const.TAG_PURCHASEDATE.equals(localName)) {
                ticket.setPurchaseDate(textContent);
                log("add ticket purchase date");
            }
            else if (Const.TAG_PASSENGER.equals(localName)) {
                ticket.setPassenger(parsePassenger(item));
                log("add passenger" + item);
            }
        }

        return ticket;
    }

    private Passenger parsePassenger(Node node) {
        Passenger passenger = new Passenger();
        Integer attrId = this.GetAttributeIdFromNode(node);
        if (attrId != null) {
            passenger.setId(attrId);
        }

        NodeList nodes = node.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node item = nodes.item(i);
            String localName = item.getLocalName();
            String textContent = item.getTextContent();
            log(localName);

            if (Const.TAG_NAME.equals(localName)) {
                passenger.setName(textContent);
                log("add passenger name" + textContent);
            } else if (Const.TAG_SURNAME.equals(localName)) {
                passenger.setSurname(localName);
                log("add passenger surname" + textContent);
            }
        }

        return passenger;
    }

    private Integer GetAttributeIdFromNode(Node node) {
        if (node.hasAttributes()) {
            NamedNodeMap attrs = node.getAttributes();
            Node item = attrs.getNamedItem(Const.ATTRIBUTE_ID);
            String textContent = item.getTextContent();
            log(item.getLocalName() + "=" + textContent);
            return Integer.parseInt(textContent);
        }

        return null;
    }

    public List<Airplane> parse(InputStream in, Schema schema)
            throws ParserConfigurationException, SAXException, IOException {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);

        // to be compliant, completely disable DOCTYPE declaration:
        dbf.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        // or completely disable external entities declarations:
//		dbf.setFeature("http://xml.org/sax/features/external-general-entities", false);
//		dbf.setFeature("http://xml.org/sax/features/external-parameter-entities", false);

        // make parser validating against XSD, which internally referenced in XML doc
        // !!! OLD VULNERABLE FEATURE !!!
//		dbf.setFeature(Const.FEATURE__TURN_VALIDATION_ON, true);
//		dbf.setFeature(Const.FEATURE__TURN_SCHEMA_VALIDATION_ON, true);

        // set the validation against schema
        dbf.setSchema(schema);

        DocumentBuilder db = dbf.newDocumentBuilder();

        // setup validation error handler
        // the preferred way is the throwing an exception
        db.setErrorHandler(new DefaultHandler() {
            @Override
            public void error(SAXParseException e) throws SAXException {
                System.err.println(e.getMessage()); // log error
//				throw e;
            }
        });

        // get the top of the xml tree
        Document root = db.parse(in);

        List<Airplane> airplanes = new ArrayList<>();

        // get the root element of the xml document
        Element e = root.getDocumentElement();
        NodeList xmlArticles = e.getElementsByTagNameNS(Const.AIRPLANES_NAMESPACE_URI, Const.TAG_AIRPLANE);
        for (int i = 0; i < xmlArticles.getLength(); i++) {
            airplanes.add(parseAirplane(xmlArticles.item(i)));
        }

        return airplanes;
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        // Create against validation schema
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = sf.newSchema(new File("xml/Airplanes.xsd"));

        System.out.println("--== DOM Parser ==--");
        DOMParser domParser = new DOMParser();
        InputStream in = new FileInputStream("xml/Airplanes.xml");
        List<Airplane> airplanes = domParser.parse(in, schema);

        System.out.println("====================================");
        System.out.println("Here is the airplanes: \n" + airplanes);
        System.out.println("====================================");

        in = new FileInputStream("xml/Invalid_airplanes.xml");
        airplanes = domParser.parse(in, schema);
        System.out.println("====================================");
        System.out.println("Here is the airplanes from invalid xml: \n" + airplanes);
        System.out.println("====================================");
    }
}
