
package hidrocon.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for createNeighbour complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="createNeighbour">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="neighbour" type="{http://webservice.hidrocon/}neighbour" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createNeighbour", propOrder = {
    "neighbour"
})
public class CreateNeighbour {

    protected Neighbour neighbour;

    /**
     * Gets the value of the neighbour property.
     * 
     * @return
     *     possible object is
     *     {@link Neighbour }
     *     
     */
    public Neighbour getNeighbour() {
        return neighbour;
    }

    /**
     * Sets the value of the neighbour property.
     * 
     * @param value
     *     allowed object is
     *     {@link Neighbour }
     *     
     */
    public void setNeighbour(Neighbour value) {
        this.neighbour = value;
    }

}
