
package ua.nure.service;

import jakarta.xml.ws.*;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 3.0.0
 * Generated source version: 3.0
 * 
 */
@WebServiceClient(name = "Airplane", targetNamespace = "http://nure.ua/service", wsdlLocation = "http://localhost:9000/airplanes?wsdl")
public class Airplane
    extends Service
{

    private final static URL AIRPLANE_WSDL_LOCATION;
    private final static WebServiceException AIRPLANE_EXCEPTION;
    private final static QName AIRPLANE_QNAME = new QName("http://nure.ua/service", "Airplane");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:9000/airplanes?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        AIRPLANE_WSDL_LOCATION = url;
        AIRPLANE_EXCEPTION = e;
    }

    public Airplane() {
        super(__getWsdlLocation(), AIRPLANE_QNAME);
    }

    public Airplane(WebServiceFeature... features) {
        super(__getWsdlLocation(), AIRPLANE_QNAME, features);
    }

    public Airplane(URL wsdlLocation) {
        super(wsdlLocation, AIRPLANE_QNAME);
    }

    public Airplane(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, AIRPLANE_QNAME, features);
    }

    public Airplane(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Airplane(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns AirplaneService
     */
    @WebEndpoint(name = "AirplanePort")
    public AirplaneService getAirplanePort() {
        return super.getPort(new QName("http://nure.ua/service", "AirplanePort"), AirplaneService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AirplaneService
     */
    @WebEndpoint(name = "AirplanePort")
    public AirplaneService getAirplanePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://nure.ua/service", "AirplanePort"), AirplaneService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (AIRPLANE_EXCEPTION!= null) {
            throw AIRPLANE_EXCEPTION;
        }
        return AIRPLANE_WSDL_LOCATION;
    }

}