package ua.nure.parser;

import ua.nure.entity.Airplane;
import ua.nure.entity.Airplanes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.XMLConstants;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.ValidationEvent;
import jakarta.xml.bind.ValidationEventHandler;
import ua.nure.entity.Passenger;
import ua.nure.entity.Ticket;

/**
 * Controller for JAXB.
 *
 * @author D.Kolesnikov, I. Mishcheriakov
 */
public class JAXBParser {

    /**
     * XML --> Java (with validation against XSD). Throws no exception if XML is
     * well-formed, but NOT valid (just prints validation warning message).
     *
     * @param xmlFileName   Input XML file name (not null, required).
     * @param xsdFileName   External XSD for validation. If equals to "", validation will
     *                      be against XSD indicated in XML document. If equals to null,
     *                      there is no validation during Articles object loading.
     * @param objectFactory ObjectFactory class
     * @return Articles object, container with info from the input XML document.
     */
    public static Airplanes loadAirplanes(final String xmlFileName,
                                       final String xsdFileName, Class<?> objectFactory) throws JAXBException, SAXException {
        JAXBContext jc = JAXBContext.newInstance(objectFactory);
        Unmarshaller unmarshaller = jc.createUnmarshaller();

        // obtain schema
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

        if (xsdFileName != null) { // <-- setup validation on
            Schema schema = null;
            if ("".equals(xsdFileName)) {
                // setup validation against XSD pointed in XML
                schema = sf.newSchema();
            } else {
                // setup validation against external XSD
                schema = sf.newSchema(new File(xsdFileName));
            }

            unmarshaller.setSchema(schema); // <-- set XML schema for validation

            // set up handler
            unmarshaller.setEventHandler(new ValidationEventHandler() {
                // this method will be invoked if XML is NOT valid
                @Override
                public boolean handleEvent(ValidationEvent event) {
                    // at this point we have NOT valid XML document
                    // just print message
                    System.err.println("====================================");
                    System.err.println(xmlFileName + " is NOT valid against "
                            + xsdFileName + ":\n" + event.getMessage());
                    System.err.println("====================================");

                    // if we place 'return false;' unmarshal method throws
                    // exception
                    // 'return true;' does not imply any exceptions
                    return true;
                }
            });
        }

        // do unmarshal
        Airplanes airplanes = (Airplanes) unmarshaller.unmarshal(new File(xmlFileName));
        return airplanes; // <-- filled container
    }

    /**
     * Java --> XML (with validation against XSD). Throws exception if XML is
     * NOT valid.
     *
     * @param xmlFileName Output XML file name (not null, required).
     * @param xsdFileName XSD for validation. If equals to null, there is NO
     *                    validation.
     * @throws JAXBException If JAXB object is not valid against XSD document.
     */
    public static void saveAirplanes(Airplanes airplanes, final String xmlFileName,
                                  final String xsdFileName, Class<?> objectFactory) throws JAXBException, SAXException {
        JAXBContext jc = JAXBContext.newInstance(objectFactory);
        Marshaller marshaller = jc.createMarshaller();

        // obtain schema
        SchemaFactory sf = SchemaFactory
                .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

        // setup validation against XSD
        if (xsdFileName != null) {
            Schema schema = sf.newSchema(new File(xsdFileName));

            marshaller.setSchema(schema);
            marshaller.setEventHandler(new ValidationEventHandler() {
                @Override
                public boolean handleEvent(ValidationEvent event) {
                    // at this point we have NOT valid XML document
                    // just print message
                    System.err.println("====================================");
                    System.err.println(xmlFileName + " is NOT valid against "
                            + xsdFileName + ":\n" + event.getMessage());
                    System.err.println("====================================");

                    // if we place 'return false;' marshal method throws
                    // exception
                    // 'return true;' does not imply any exceptions
                    return false;
                }
            });
        }

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, Const.SCHEMA_LOCATION__URI);
        marshaller.marshal(airplanes, new File(xmlFileName));
    }

    public static void main1(String[] args) throws JAXBException, FileNotFoundException {
        JAXBContext jc = JAXBContext.newInstance(Const.OBJECT_FACTORY);
        Unmarshaller um = jc.createUnmarshaller();
        Airplanes airplanes = (Airplanes) um.unmarshal(new FileInputStream(Const.XML_FILE));
        System.out.println(airplanes);
    }

    public static void main(String[] args) throws JAXBException, SAXException {
        System.out.println("--== JAXB Parser ==--");
        // load Articles object from NOT valid XML (success, just prints validation
        // warning)
//        Articles articles = loadArticles(Const.XML_FILE, Const.XSD_FILE, Const.OBJECT_FACTORY);
        Airplanes airplanes = new Airplanes();
        Airplane airplane = new Airplane();
        airplane.setId(1);
        airplane.setAirplaneTitle("Doctor Strange");
        airplane.setDestination("3D");
        airplane.setDuration("1000");

        Passenger passenger = new Passenger();
        passenger.setId(1);
        passenger.setSurname("Nikiforow");
        passenger.setName("Gleb");

        Ticket ticket = new Ticket();
        ticket.setTicketNumber("1");
        ticket.setSeatNumber("11A");
        ticket.setPurchaseDate("2020-10-10");
        ticket.setPassenger(passenger);

        airplane.getTicket().add(ticket);
        airplanes.getAirplane().add(airplane);

        // we have Articles object at this point
        System.out.println("====================================");
        System.out.println("Here is the articles: \n" + airplanes);
        System.out.println("====================================");

        // try to save Articles object to XML file (failed, exception)
        try {
            saveAirplanes(airplanes, Const.XML_FILE + ".jaxb.xml", Const.XSD_FILE, Const.OBJECT_FACTORY);
        } catch (Exception ex) {
            System.err.println("====================================");
            System.err.println("Object tree not valid against XSD.");
            System.err.println(ex.getClass().getName());
            System.err.println("====================================");
        }
    }
}