
package hidrocon.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for neighbourMeterReadingView complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="neighbourMeterReadingView">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="m3" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="meterId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="meterReadingId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="meterTypeId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="neighbourId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="neighbourMeterId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="readValue" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="readingDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="registeredValue" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="serialNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "neighbourMeterReadingView", propOrder = {
    "m3",
    "meterId",
    "meterReadingId",
    "meterTypeId",
    "neighbourId",
    "neighbourMeterId",
    "readValue",
    "readingDate",
    "registeredValue",
    "serialNumber"
})
public class NeighbourMeterReadingView {

    protected Integer m3;
    protected String meterId;
    protected int meterReadingId;
    protected int meterTypeId;
    protected Integer neighbourId;
    protected Integer neighbourMeterId;
    protected Integer readValue;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar readingDate;
    protected Integer registeredValue;
    protected int serialNumber;

    /**
     * Gets the value of the m3 property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getM3() {
        return m3;
    }

    /**
     * Sets the value of the m3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setM3(Integer value) {
        this.m3 = value;
    }

    /**
     * Gets the value of the meterId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeterId() {
        return meterId;
    }

    /**
     * Sets the value of the meterId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeterId(String value) {
        this.meterId = value;
    }

    /**
     * Gets the value of the meterReadingId property.
     * 
     */
    public int getMeterReadingId() {
        return meterReadingId;
    }

    /**
     * Sets the value of the meterReadingId property.
     * 
     */
    public void setMeterReadingId(int value) {
        this.meterReadingId = value;
    }

    /**
     * Gets the value of the meterTypeId property.
     * 
     */
    public int getMeterTypeId() {
        return meterTypeId;
    }

    /**
     * Sets the value of the meterTypeId property.
     * 
     */
    public void setMeterTypeId(int value) {
        this.meterTypeId = value;
    }

    /**
     * Gets the value of the neighbourId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNeighbourId() {
        return neighbourId;
    }

    /**
     * Sets the value of the neighbourId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNeighbourId(Integer value) {
        this.neighbourId = value;
    }

    /**
     * Gets the value of the neighbourMeterId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNeighbourMeterId() {
        return neighbourMeterId;
    }

    /**
     * Sets the value of the neighbourMeterId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNeighbourMeterId(Integer value) {
        this.neighbourMeterId = value;
    }

    /**
     * Gets the value of the readValue property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getReadValue() {
        return readValue;
    }

    /**
     * Sets the value of the readValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setReadValue(Integer value) {
        this.readValue = value;
    }

    /**
     * Gets the value of the readingDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getReadingDate() {
        return readingDate;
    }

    /**
     * Sets the value of the readingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setReadingDate(XMLGregorianCalendar value) {
        this.readingDate = value;
    }

    /**
     * Gets the value of the registeredValue property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRegisteredValue() {
        return registeredValue;
    }

    /**
     * Sets the value of the registeredValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRegisteredValue(Integer value) {
        this.registeredValue = value;
    }

    /**
     * Gets the value of the serialNumber property.
     * 
     */
    public int getSerialNumber() {
        return serialNumber;
    }

    /**
     * Sets the value of the serialNumber property.
     * 
     */
    public void setSerialNumber(int value) {
        this.serialNumber = value;
    }

}
