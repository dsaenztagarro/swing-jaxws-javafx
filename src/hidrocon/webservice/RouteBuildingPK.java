
package hidrocon.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for routeBuildingPK complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="routeBuildingPK">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="buildingId" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "routeBuildingPK", propOrder = {
    "buildingId",
    "routeId"
})
public class RouteBuildingPK {

    protected int buildingId;
    protected int routeId;

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
