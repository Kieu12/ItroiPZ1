
package ua.nure.entity;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ua.nure.entity package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Airplane_QNAME = new QName("http://nure.ua/entity", "Airplane");
    private final static QName _Ticket_QNAME = new QName("http://nure.ua/entity", "Ticket");
    private final static QName _ListAirplanes_QNAME = new QName("http://nure.ua/entity", "listAirplanes");
    private final static QName _Return_QNAME = new QName("http://nure.ua/entity", "return");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ua.nure.entity
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Airplane }
     * 
     */
    public Airplane createAirplane() {
        return new Airplane();
    }

    /**
     * Create an instance of {@link Ticket }
     * 
     */
    public Ticket createTicket() {
        return new Ticket();
    }

    /**
     * Create an instance of {@link EntityBase }
     * 
     */
    public EntityBase createEntityBase() {
        return new EntityBase();
    }

    /**
     * Create an instance of {@link Passenger }
     * 
     */
    public Passenger createPassenger() {
        return new Passenger();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Airplane }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Airplane }{@code >}
     */
    @XmlElementDecl(namespace = "http://nure.ua/entity", name = "Airplane")
    public JAXBElement<Airplane> createAirplane(Airplane value) {
        return new JAXBElement<Airplane>(_Airplane_QNAME, Airplane.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Ticket }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Ticket }{@code >}
     */
    @XmlElementDecl(namespace = "http://nure.ua/entity", name = "Ticket")
    public JAXBElement<Ticket> createTicket(Ticket value) {
        return new JAXBElement<Ticket>(_Ticket_QNAME, Ticket.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Airplane }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Airplane }{@code >}
     */
    @XmlElementDecl(namespace = "http://nure.ua/entity", name = "listAirplanes")
    public JAXBElement<Airplane> createListAirplanes(Airplane value) {
        return new JAXBElement<Airplane>(_ListAirplanes_QNAME, Airplane.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "http://nure.ua/entity", name = "return")
    public JAXBElement<Integer> createReturn(Integer value) {
        return new JAXBElement<Integer>(_Return_QNAME, Integer.class, null, value);
    }

}
