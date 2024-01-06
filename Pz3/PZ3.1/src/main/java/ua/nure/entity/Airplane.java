
package ua.nure.entity;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Airplane complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Airplane"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://nure.ua/entity}EntityBase"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Airplane_Title" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Duration" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Destination" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Ticket" type="{http://nure.ua/entity}Ticket" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Airplane", propOrder = {
    "airplaneTitle",
    "duration",
    "destination",
    "ticket"
})
public class Airplane
    extends EntityBase
{
    @Override
    public String toString() {
        return "Airplane{" +
                "airplaneTitle='" + airplaneTitle + '\'' +
                ", duration='" + duration + '\'' +
                ", destination='" + destination + '\'' +
                ", ticket=" + ticket +
                '}';
    }

    @XmlElement(name = "Airplane_Title", required = true)
    protected String airplaneTitle;
    @XmlElement(name = "Duration", required = true)
    protected String duration;
    @XmlElement(name = "Destination", required = true)
    protected String destination;
    @XmlElement(name = "Ticket")
    protected List<Ticket> ticket;

    /**
     * Gets the value of the airplaneTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAirplaneTitle() {
        return airplaneTitle;
    }

    /**
     * Sets the value of the airplaneTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAirplaneTitle(String value) {
        this.airplaneTitle = value;
    }

    /**
     * Gets the value of the duration property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDuration() {
        return duration;
    }

    /**
     * Sets the value of the duration property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDuration(String value) {
        this.duration = value;
    }

    /**
     * Gets the value of the destination property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Sets the value of the destination property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestination(String value) {
        this.destination = value;
    }

    /**
     * Gets the value of the ticket property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the ticket property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTicket().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Ticket }
     * 
     * 
     */
    public List<Ticket> getTicket() {
        if (ticket == null) {
            ticket = new ArrayList<Ticket>();
        }
        return this.ticket;
    }

}
