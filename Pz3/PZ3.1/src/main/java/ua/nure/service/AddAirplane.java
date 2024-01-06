
package ua.nure.service;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import ua.nure.entity.Airplane;


/**
 * <p>Java class for addAirplane complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addAirplane"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://nure.ua/entity}Airplane" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addAirplane", propOrder = {
    "airplane"
})
public class AddAirplane {

    @XmlElement(name = "Airplane", namespace = "http://nure.ua/entity")
    protected Airplane airplane;

    /**
     * Gets the value of the airplane property.
     * 
     * @return
     *     possible object is
     *     {@link Airplane }
     *     
     */
    public Airplane getAirplane() {
        return airplane;
    }

    /**
     * Sets the value of the airplane property.
     * 
     * @param value
     *     allowed object is
     *     {@link Airplane }
     *     
     */
    public void setAirplane(Airplane value) {
        this.airplane = value;
    }

}
