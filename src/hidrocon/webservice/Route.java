
package hidrocon.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for route complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="route">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="numberReadingsPerYear" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="recStatus" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="routeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "route", propOrder = {
    "id",
    "numberReadingsPerYear",
    "recStatus",
    "routeName"
})
public class Route {

    protected Integer id;
    protected int numberReadingsPerYear;
    @XmlSchemaType(name = "unsignedShort")
    protected int recStatus;
    protected String routeName;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }

    /**
     * Gets the value of the numberReadingsPerYear property.
     * 
     */
    public int getNumberReadingsPerYear() {
        return numberReadingsPerYear;
    }

    /**
     * Sets the value of the numberReadingsPerYear property.
     * 
     */
    public void setNumberReadingsPerYear(int value) {
        this.numberReadingsPerYear = value;
    }

    /**
     * Gets the value of the recStatus property.
     * 
     */
    public int getRecStatus() {
        return recStatus;
    }

    /**
     * Sets the value of the recStatus property.
     * 
     */
    public void setRecStatus(int value) {
        this.recStatus = value;
    }

    /**
     * Gets the value of the routeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRouteName() {
        return routeName;
    }

    /**
     * Sets the value of the routeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRouteName(String value) {
        this.routeName = value;
    }

}
