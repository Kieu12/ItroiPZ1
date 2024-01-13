
package ua.nure.service;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for removeAirplane complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="removeAirplane"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="airplaneId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "removeAirplane", propOrder = {
    "airplaneId"
})
public class RemoveAirplane {

    @XmlElement(namespace = "")
    protected int airplaneId;

    /**
     * Gets the value of the airplaneId property.
     * 
     */
    public int getAirplaneId() {
        return airplaneId;
    }

    /**
     * Sets the value of the airplaneId property.
     * 
     */
    public void setAirplaneId(int value) {
        this.airplaneId = value;
    }

}
