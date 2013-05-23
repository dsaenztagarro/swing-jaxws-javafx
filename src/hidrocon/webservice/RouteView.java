
package hidrocon.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for routeView complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="routeView">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="lastReadingDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="nextReadingDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="numberReadingsPerYear" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "routeView", propOrder = {
    "id",
    "lastReadingDate",
    "nextReadingDate",
    "numberReadingsPerYear",
    "routeName"
})
public class RouteView {

    protected int id;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastReadingDate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar nextReadingDate;
    protected int numberReadingsPerYear;
    protected String routeName;

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the lastReadingDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastReadingDate() {
        return lastReadingDate;
    }

    /**
     * Sets the value of the lastReadingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastReadingDate(XMLGregorianCalendar value) {
        this.lastReadingDate = value;
    }

    /**
     * Gets the value of the nextReadingDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getNextReadingDate() {
        return nextReadingDate;
    }

    /**
     * Sets the value of the nextReadingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setNextReadingDate(XMLGregorianCalendar value) {
        this.nextReadingDate = value;
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
