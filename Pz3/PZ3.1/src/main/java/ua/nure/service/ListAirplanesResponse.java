
package ua.nure.service;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import ua.nure.entity.Airplane;


/**
 * <p>Java class for listAirplanesResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="listAirplanesResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://nure.ua/entity}listAirplanes" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listAirplanesResponse", propOrder = {
    "listAirplanes"
})
public class ListAirplanesResponse {

    @XmlElement(namespace = "http://nure.ua/entity")
    protected List<Airplane> listAirplanes;

    /**
     * Gets the value of the listAirplanes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the listAirplanes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListAirplanes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Airplane }
     * 
     * 
     */
    public List<Airplane> getListAirplanes() {
        if (listAirplanes == null) {
            listAirplanes = new ArrayList<Airplane>();
        }
        return this.listAirplanes;
    }

}
