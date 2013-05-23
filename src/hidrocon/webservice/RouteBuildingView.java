
package hidrocon.webservice;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for routeBuildingView complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="routeBuildingView">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="buildingAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="buildingCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="buildingId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="buildingMeterCounter" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="buildingNumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="buildingRouteIsDefault" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="orderId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="routeBuildingId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="routeId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "routeBuildingView", propOrder = {
    "buildingAddress",
    "buildingCode",
    "buildingId",
    "buildingMeterCounter",
    "buildingNumber",
    "buildingRouteIsDefault",
    "orderId",
    "routeBuildingId",
    "routeId"
})
public class RouteBuildingView {

    protected String buildingAddress;
    protected String buildingCode;
    protected int buildingId;
    protected BigInteger buildingMeterCounter;
    protected Integer buildingNumber;
    @XmlSchemaType(name = "unsignedShort")
    protected int buildingRouteIsDefault;
    protected int orderId;
    protected int routeBuildingId;
    protected int routeId;

    /**
     * Gets the value of the buildingAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBuildingAddress() {
        return buildingAddress;
    }

    /**
     * Sets the value of the buildingAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBuildingAddress(String value) {
        this.buildingAddress = value;
    }

    /**
     * Gets the value of the buildingCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBuildingCode() {
        return buildingCode;
    }

    /**
     * Sets the value of the buildingCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBuildingCode(String value) {
        this.buildingCode = value;
    }

    /**
     * Gets the value of the buildingId property.
     * 
     */
    public int getBuildingId() {
        return buildingId;
    }

    /**
     * Sets the value of the buildingId property.
     * 
     */
    public void setBuildingId(int value) {
        this.buildingId = value;
    }

    /**
     * Gets the value of the buildingMeterCounter property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBuildingMeterCounter() {
        return buildingMeterCounter;
    }

    /**
     * Sets the value of the buildingMeterCounter property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBuildingMeterCounter(BigInteger value) {
        this.buildingMeterCounter = value;
    }

    /**
     * Gets the value of the buildingNumber property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBuildingNumber() {
        return buildingNumber;
    }

    /**
     * Sets the value of the buildingNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBuildingNumber(Integer value) {
        this.buildingNumber = value;
    }

    /**
     * Gets the value of the buildingRouteIsDefault property.
     * 
     */
    public int getBuildingRouteIsDefault() {
        return buildingRouteIsDefault;
    }

    /**
     * Sets the value of the buildingRouteIsDefault property.
     * 
     */
    public void setBuildingRouteIsDefault(int value) {
        this.buildingRouteIsDefault = value;
    }

    /**
     * Gets the value of the orderId property.
     * 
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * Sets the value of the orderId property.
     * 
     */
    public void setOrderId(int value) {
        this.orderId = value;
    }

    /**
     * Gets the value of the routeBuildingId property.
     * 
     */
    public int getRouteBuildingId() {
        return routeBuildingId;
    }

    /**
     * Sets the value of the routeBuildingId property.
     * 
     */
    public void setRouteBuildingId(int value) {
        this.routeBuildingId = value;
    }

    /**
     * Gets the value of the routeId property.
     * 
     */
    public int getRouteId() {
        return routeId;
    }

    /**
     * Sets the value of the routeId property.
     * 
     */
    public void setRouteId(int value) {
        this.routeId = value;
    }

}
