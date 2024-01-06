
package ua.nure.service;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ua.nure.service package. 
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

    private final static QName _DAOException_QNAME = new QName("http://nure.ua/service", "DAOException");
    private final static QName _AddAirplane_QNAME = new QName("http://nure.ua/service", "addAirplane");
    private final static QName _AddAirplaneResponse_QNAME = new QName("http://nure.ua/service", "addAirplaneResponse");
    private final static QName _AddTicket_QNAME = new QName("http://nure.ua/service", "addTicket");
    private final static QName _AddTicketResponse_QNAME = new QName("http://nure.ua/service", "addTicketResponse");
    private final static QName _GetTicket_QNAME = new QName("http://nure.ua/service", "getTicket");
    private final static QName _GetTicketResponse_QNAME = new QName("http://nure.ua/service", "getTicketResponse");
    private final static QName _ListAirplanes_QNAME = new QName("http://nure.ua/service", "listAirplanes");
    private final static QName _ListAirplanesResponse_QNAME = new QName("http://nure.ua/service", "listAirplanesResponse");
    private final static QName _RemoveAirplane_QNAME = new QName("http://nure.ua/service", "removeAirplane");
    private final static QName _RemoveAirplaneResponse_QNAME = new QName("http://nure.ua/service", "removeAirplaneResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ua.nure.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DAOException }
     * 
     */
    public DAOException createDAOException() {
        return new DAOException();
    }

    /**
     * Create an instance of {@link AddAirplane }
     * 
     */
    public AddAirplane createAddAirplane() {
        return new AddAirplane();
    }

    /**
     * Create an instance of {@link AddAirplaneResponse }
     * 
     */
    public AddAirplaneResponse createAddAirplaneResponse() {
        return new AddAirplaneResponse();
    }

    /**
     * Create an instance of {@link AddTicket }
     * 
     */
    public AddTicket createAddTicket() {
        return new AddTicket();
    }

    /**
     * Create an instance of {@link AddTicketResponse }
     * 
     */
    public AddTicketResponse createAddTicketResponse() {
        return new AddTicketResponse();
    }

    /**
     * Create an instance of {@link GetTicket }
     * 
     */
    public GetTicket createGetTicket() {
        return new GetTicket();
    }

    /**
     * Create an instance of {@link GetTicketResponse }
     * 
     */
    public GetTicketResponse createGetTicketResponse() {
        return new GetTicketResponse();
    }

    /**
     * Create an instance of {@link ListAirplanes }
     * 
     */
    public ListAirplanes createListAirplanes() {
        return new ListAirplanes();
    }

    /**
     * Create an instance of {@link ListAirplanesResponse }
     * 
     */
    public ListAirplanesResponse createListAirplanesResponse() {
        return new ListAirplanesResponse();
    }

    /**
     * Create an instance of {@link RemoveAirplane }
     * 
     */
    public RemoveAirplane createRemoveAirplane() {
        return new RemoveAirplane();
    }

    /**
     * Create an instance of {@link RemoveAirplaneResponse }
     * 
     */
    public RemoveAirplaneResponse createRemoveAirplaneResponse() {
        return new RemoveAirplaneResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DAOException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DAOException }{@code >}
     */
    @XmlElementDecl(namespace = "http://nure.ua/service", name = "DAOException")
    public JAXBElement<DAOException> createDAOException(DAOException value) {
        return new JAXBElement<DAOException>(_DAOException_QNAME, DAOException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddAirplane }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddAirplane }{@code >}
     */
    @XmlElementDecl(namespace = "http://nure.ua/service", name = "addAirplane")
    public JAXBElement<AddAirplane> createAddAirplane(AddAirplane value) {
        return new JAXBElement<AddAirplane>(_AddAirplane_QNAME, AddAirplane.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddAirplaneResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddAirplaneResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://nure.ua/service", name = "addAirplaneResponse")
    public JAXBElement<AddAirplaneResponse> createAddAirplaneResponse(AddAirplaneResponse value) {
        return new JAXBElement<AddAirplaneResponse>(_AddAirplaneResponse_QNAME, AddAirplaneResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddTicket }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddTicket }{@code >}
     */
    @XmlElementDecl(namespace = "http://nure.ua/service", name = "addTicket")
    public JAXBElement<AddTicket> createAddTicket(AddTicket value) {
        return new JAXBElement<AddTicket>(_AddTicket_QNAME, AddTicket.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddTicketResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddTicketResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://nure.ua/service", name = "addTicketResponse")
    public JAXBElement<AddTicketResponse> createAddTicketResponse(AddTicketResponse value) {
        return new JAXBElement<AddTicketResponse>(_AddTicketResponse_QNAME, AddTicketResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTicket }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetTicket }{@code >}
     */
    @XmlElementDecl(namespace = "http://nure.ua/service", name = "getTicket")
    public JAXBElement<GetTicket> createGetTicket(GetTicket value) {
        return new JAXBElement<GetTicket>(_GetTicket_QNAME, GetTicket.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTicketResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetTicketResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://nure.ua/service", name = "getTicketResponse")
    public JAXBElement<GetTicketResponse> createGetTicketResponse(GetTicketResponse value) {
        return new JAXBElement<GetTicketResponse>(_GetTicketResponse_QNAME, GetTicketResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListAirplanes }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListAirplanes }{@code >}
     */
    @XmlElementDecl(namespace = "http://nure.ua/service", name = "listAirplanes")
    public JAXBElement<ListAirplanes> createListAirplanes(ListAirplanes value) {
        return new JAXBElement<ListAirplanes>(_ListAirplanes_QNAME, ListAirplanes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListAirplanesResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListAirplanesResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://nure.ua/service", name = "listAirplanesResponse")
    public JAXBElement<ListAirplanesResponse> createListAirplanesResponse(ListAirplanesResponse value) {
        return new JAXBElement<ListAirplanesResponse>(_ListAirplanesResponse_QNAME, ListAirplanesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveAirplane }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RemoveAirplane }{@code >}
     */
    @XmlElementDecl(namespace = "http://nure.ua/service", name = "removeAirplane")
    public JAXBElement<RemoveAirplane> createRemoveAirplane(RemoveAirplane value) {
        return new JAXBElement<RemoveAirplane>(_RemoveAirplane_QNAME, RemoveAirplane.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveAirplaneResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RemoveAirplaneResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://nure.ua/service", name = "removeAirplaneResponse")
    public JAXBElement<RemoveAirplaneResponse> createRemoveAirplaneResponse(RemoveAirplaneResponse value) {
        return new JAXBElement<RemoveAirplaneResponse>(_RemoveAirplaneResponse_QNAME, RemoveAirplaneResponse.class, null, value);
    }

}
