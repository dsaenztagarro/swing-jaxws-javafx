
package hidrocon.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for rate complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="rate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bloque1AduccionInvierno" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="bloque1AduccionVerano" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="bloque1DepuracionInvierno" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="bloque1DepuracionVerano" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="bloque1DistribucionInvierno" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="bloque1DistribucionVerano" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="bloque1SaneamientoInvierno" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="bloque1SaneamientoVerano" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="bloque2AduccionInvierno" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="bloque2AduccionVerano" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="bloque2DepuracionInvierno" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="bloque2DepuracionVerano" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="bloque2DistribucionInvierno" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="bloque2DistribucionVerano" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="bloque2SaneamientoInvierno" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="bloque2SaneamientoVerano" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="bloque3AduccionInvierno" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="bloque3AduccionVerano" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="bloque3DepuracionInvierno" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="bloque3DepuracionVerano" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="bloque3DistribucionInvierno" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="bloque3DistribucionVerano" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="bloque3SaneamientoInvierno" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="bloque3SaneamientoVerano" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="bloque4AduccionInvierno" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="bloque4AduccionVerano" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="bloque4DepuracionInvierno" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="bloque4DepuracionVerano" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="bloque4DistribucionInvierno" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="bloque4DistribucionVerano" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="bloque4SaneamientoInvierno" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="bloque4SaneamientoVerano" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="dinconac" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="dinconaf" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="isDefault" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="ivaCuotaCanal" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ivaHidrocon" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="percentAduccion" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="percentAlcantarillado" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="percentDepuracion" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="percentDistribucion" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="rateName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="recStatus" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="recibohi" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rate", propOrder = {
    "bloque1AduccionInvierno",
    "bloque1AduccionVerano",
    "bloque1DepuracionInvierno",
    "bloque1DepuracionVerano",
    "bloque1DistribucionInvierno",
    "bloque1DistribucionVerano",
    "bloque1SaneamientoInvierno",
    "bloque1SaneamientoVerano",
    "bloque2AduccionInvierno",
    "bloque2AduccionVerano",
    "bloque2DepuracionInvierno",
    "bloque2DepuracionVerano",
    "bloque2DistribucionInvierno",
    "bloque2DistribucionVerano",
    "bloque2SaneamientoInvierno",
    "bloque2SaneamientoVerano",
    "bloque3AduccionInvierno",
    "bloque3AduccionVerano",
    "bloque3DepuracionInvierno",
    "bloque3DepuracionVerano",
    "bloque3DistribucionInvierno",
    "bloque3DistribucionVerano",
    "bloque3SaneamientoInvierno",
    "bloque3SaneamientoVerano",
    "bloque4AduccionInvierno",
    "bloque4AduccionVerano",
    "bloque4DepuracionInvierno",
    "bloque4DepuracionVerano",
    "bloque4DistribucionInvierno",
    "bloque4DistribucionVerano",
    "bloque4SaneamientoInvierno",
    "bloque4SaneamientoVerano",
    "dinconac",
    "dinconaf",
    "id",
    "isDefault",
    "ivaCuotaCanal",
    "ivaHidrocon",
    "percentAduccion",
    "percentAlcantarillado",
    "percentDepuracion",
    "percentDistribucion",
    "rateName",
    "recStatus",
    "recibohi"
})
public class Rate {

    protected Double bloque1AduccionInvierno;
    protected Double bloque1AduccionVerano;
    protected Double bloque1DepuracionInvierno;
    protected Double bloque1DepuracionVerano;
    protected Double bloque1DistribucionInvierno;
    protected Double bloque1DistribucionVerano;
    protected Double bloque1SaneamientoInvierno;
    protected Double bloque1SaneamientoVerano;
    protected Double bloque2AduccionInvierno;
    protected Double bloque2AduccionVerano;
    protected Double bloque2DepuracionInvierno;
    protected Double bloque2DepuracionVerano;
    protected Double bloque2DistribucionInvierno;
    protected Double bloque2DistribucionVerano;
    protected Double bloque2SaneamientoInvierno;
    protected Double bloque2SaneamientoVerano;
    protected Double bloque3AduccionInvierno;
    protected Double bloque3AduccionVerano;
    protected Double bloque3DepuracionInvierno;
    protected Double bloque3DepuracionVerano;
    protected Double bloque3DistribucionInvierno;
    protected Double bloque3DistribucionVerano;
    protected Double bloque3SaneamientoInvierno;
    protected Double bloque3SaneamientoVerano;
    protected Double bloque4AduccionInvierno;
    protected Double bloque4AduccionVerano;
    protected Double bloque4DepuracionInvierno;
    protected Double bloque4DepuracionVerano;
    protected Double bloque4DistribucionInvierno;
    protected Double bloque4DistribucionVerano;
    protected Double bloque4SaneamientoInvierno;
    protected Double bloque4SaneamientoVerano;
    protected double dinconac;
    protected double dinconaf;
    protected Integer id;
    @XmlSchemaType(name = "unsignedShort")
    protected int isDefault;
    protected int ivaCuotaCanal;
    protected int ivaHidrocon;
    protected Double percentAduccion;
    protected Double percentAlcantarillado;
    protected Double percentDepuracion;
    protected Double percentDistribucion;
    protected String rateName;
    @XmlSchemaType(name = "unsignedShort")
    protected int recStatus;
    protected int recibohi;

    /**
     * Gets the value of the bloque1AduccionInvierno property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBloque1AduccionInvierno() {
        return bloque1AduccionInvierno;
    }

    /**
     * Sets the value of the bloque1AduccionInvierno property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBloque1AduccionInvierno(Double value) {
        this.bloque1AduccionInvierno = value;
    }

    /**
     * Gets the value of the bloque1AduccionVerano property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBloque1AduccionVerano() {
        return bloque1AduccionVerano;
    }

    /**
     * Sets the value of the bloque1AduccionVerano property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBloque1AduccionVerano(Double value) {
        this.bloque1AduccionVerano = value;
    }

    /**
     * Gets the value of the bloque1DepuracionInvierno property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBloque1DepuracionInvierno() {
        return bloque1DepuracionInvierno;
    }

    /**
     * Sets the value of the bloque1DepuracionInvierno property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBloque1DepuracionInvierno(Double value) {
        this.bloque1DepuracionInvierno = value;
    }

    /**
     * Gets the value of the bloque1DepuracionVerano property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBloque1DepuracionVerano() {
        return bloque1DepuracionVerano;
    }

    /**
     * Sets the value of the bloque1DepuracionVerano property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBloque1DepuracionVerano(Double value) {
        this.bloque1DepuracionVerano = value;
    }

    /**
     * Gets the value of the bloque1DistribucionInvierno property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBloque1DistribucionInvierno() {
        return bloque1DistribucionInvierno;
    }

    /**
     * Sets the value of the bloque1DistribucionInvierno property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBloque1DistribucionInvierno(Double value) {
        this.bloque1DistribucionInvierno = value;
    }

    /**
     * Gets the value of the bloque1DistribucionVerano property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBloque1DistribucionVerano() {
        return bloque1DistribucionVerano;
    }

    /**
     * Sets the value of the bloque1DistribucionVerano property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBloque1DistribucionVerano(Double value) {
        this.bloque1DistribucionVerano = value;
    }

    /**
     * Gets the value of the bloque1SaneamientoInvierno property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBloque1SaneamientoInvierno() {
        return bloque1SaneamientoInvierno;
    }

    /**
     * Sets the value of the bloque1SaneamientoInvierno property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBloque1SaneamientoInvierno(Double value) {
        this.bloque1SaneamientoInvierno = value;
    }

    /**
     * Gets the value of the bloque1SaneamientoVerano property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBloque1SaneamientoVerano() {
        return bloque1SaneamientoVerano;
    }

    /**
     * Sets the value of the bloque1SaneamientoVerano property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBloque1SaneamientoVerano(Double value) {
        this.bloque1SaneamientoVerano = value;
    }

    /**
     * Gets the value of the bloque2AduccionInvierno property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBloque2AduccionInvierno() {
        return bloque2AduccionInvierno;
    }

    /**
     * Sets the value of the bloque2AduccionInvierno property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBloque2AduccionInvierno(Double value) {
        this.bloque2AduccionInvierno = value;
    }

    /**
     * Gets the value of the bloque2AduccionVerano property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBloque2AduccionVerano() {
        return bloque2AduccionVerano;
    }

    /**
     * Sets the value of the bloque2AduccionVerano property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBloque2AduccionVerano(Double value) {
        this.bloque2AduccionVerano = value;
    }

    /**
     * Gets the value of the bloque2DepuracionInvierno property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBloque2DepuracionInvierno() {
        return bloque2DepuracionInvierno;
    }

    /**
     * Sets the value of the bloque2DepuracionInvierno property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBloque2DepuracionInvierno(Double value) {
        this.bloque2DepuracionInvierno = value;
    }

    /**
     * Gets the value of the bloque2DepuracionVerano property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBloque2DepuracionVerano() {
        return bloque2DepuracionVerano;
    }

    /**
     * Sets the value of the bloque2DepuracionVerano property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBloque2DepuracionVerano(Double value) {
        this.bloque2DepuracionVerano = value;
    }

    /**
     * Gets the value of the bloque2DistribucionInvierno property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBloque2DistribucionInvierno() {
        return bloque2DistribucionInvierno;
    }

    /**
     * Sets the value of the bloque2DistribucionInvierno property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBloque2DistribucionInvierno(Double value) {
        this.bloque2DistribucionInvierno = value;
    }

    /**
     * Gets the value of the bloque2DistribucionVerano property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBloque2DistribucionVerano() {
        return bloque2DistribucionVerano;
    }

    /**
     * Sets the value of the bloque2DistribucionVerano property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBloque2DistribucionVerano(Double value) {
        this.bloque2DistribucionVerano = value;
    }

    /**
     * Gets the value of the bloque2SaneamientoInvierno property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBloque2SaneamientoInvierno() {
        return bloque2SaneamientoInvierno;
    }

    /**
     * Sets the value of the bloque2SaneamientoInvierno property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBloque2SaneamientoInvierno(Double value) {
        this.bloque2SaneamientoInvierno = value;
    }

    /**
     * Gets the value of the bloque2SaneamientoVerano property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBloque2SaneamientoVerano() {
        return bloque2SaneamientoVerano;
    }

    /**
     * Sets the value of the bloque2SaneamientoVerano property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBloque2SaneamientoVerano(Double value) {
        this.bloque2SaneamientoVerano = value;
    }

    /**
     * Gets the value of the bloque3AduccionInvierno property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBloque3AduccionInvierno() {
        return bloque3AduccionInvierno;
    }

    /**
     * Sets the value of the bloque3AduccionInvierno property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBloque3AduccionInvierno(Double value) {
        this.bloque3AduccionInvierno = value;
    }

    /**
     * Gets the value of the bloque3AduccionVerano property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBloque3AduccionVerano() {
        return bloque3AduccionVerano;
    }

    /**
     * Sets the value of the bloque3AduccionVerano property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBloque3AduccionVerano(Double value) {
        this.bloque3AduccionVerano = value;
    }

    /**
     * Gets the value of the bloque3DepuracionInvierno property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBloque3DepuracionInvierno() {
        return bloque3DepuracionInvierno;
    }

    /**
     * Sets the value of the bloque3DepuracionInvierno property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBloque3DepuracionInvierno(Double value) {
        this.bloque3DepuracionInvierno = value;
    }

    /**
     * Gets the value of the bloque3DepuracionVerano property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBloque3DepuracionVerano() {
        return bloque3DepuracionVerano;
    }

    /**
     * Sets the value of the bloque3DepuracionVerano property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBloque3DepuracionVerano(Double value) {
        this.bloque3DepuracionVerano = value;
    }

    /**
     * Gets the value of the bloque3DistribucionInvierno property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBloque3DistribucionInvierno() {
        return bloque3DistribucionInvierno;
    }

    /**
     * Sets the value of the bloque3DistribucionInvierno property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBloque3DistribucionInvierno(Double value) {
        this.bloque3DistribucionInvierno = value;
    }

    /**
     * Gets the value of the bloque3DistribucionVerano property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBloque3DistribucionVerano() {
        return bloque3DistribucionVerano;
    }

    /**
     * Sets the value of the bloque3DistribucionVerano property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBloque3DistribucionVerano(Double value) {
        this.bloque3DistribucionVerano = value;
    }

    /**
     * Gets the value of the bloque3SaneamientoInvierno property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBloque3SaneamientoInvierno() {
        return bloque3SaneamientoInvierno;
    }

    /**
     * Sets the value of the bloque3SaneamientoInvierno property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBloque3SaneamientoInvierno(Double value) {
        this.bloque3SaneamientoInvierno = value;
    }

    /**
     * Gets the value of the bloque3SaneamientoVerano property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBloque3SaneamientoVerano() {
        return bloque3SaneamientoVerano;
    }

    /**
     * Sets the value of the bloque3SaneamientoVerano property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBloque3SaneamientoVerano(Double value) {
        this.bloque3SaneamientoVerano = value;
    }

    /**
     * Gets the value of the bloque4AduccionInvierno property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBloque4AduccionInvierno() {
        return bloque4AduccionInvierno;
    }

    /**
     * Sets the value of the bloque4AduccionInvierno property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBloque4AduccionInvierno(Double value) {
        this.bloque4AduccionInvierno = value;
    }

    /**
     * Gets the value of the bloque4AduccionVerano property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBloque4AduccionVerano() {
        return bloque4AduccionVerano;
    }

    /**
     * Sets the value of the bloque4AduccionVerano property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBloque4AduccionVerano(Double value) {
        this.bloque4AduccionVerano = value;
    }

    /**
     * Gets the value of the bloque4DepuracionInvierno property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBloque4DepuracionInvierno() {
        return bloque4DepuracionInvierno;
    }

    /**
     * Sets the value of the bloque4DepuracionInvierno property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBloque4DepuracionInvierno(Double value) {
        this.bloque4DepuracionInvierno = value;
    }

    /**
     * Gets the value of the bloque4DepuracionVerano property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBloque4DepuracionVerano() {
        return bloque4DepuracionVerano;
    }

    /**
     * Sets the value of the bloque4DepuracionVerano property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBloque4DepuracionVerano(Double value) {
        this.bloque4DepuracionVerano = value;
    }

    /**
     * Gets the value of the bloque4DistribucionInvierno property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBloque4DistribucionInvierno() {
        return bloque4DistribucionInvierno;
    }

    /**
     * Sets the value of the bloque4DistribucionInvierno property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBloque4DistribucionInvierno(Double value) {
        this.bloque4DistribucionInvierno = value;
    }

    /**
     * Gets the value of the bloque4DistribucionVerano property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBloque4DistribucionVerano() {
        return bloque4DistribucionVerano;
    }

    /**
     * Sets the value of the bloque4DistribucionVerano property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBloque4DistribucionVerano(Double value) {
        this.bloque4DistribucionVerano = value;
    }

    /**
     * Gets the value of the bloque4SaneamientoInvierno property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBloque4SaneamientoInvierno() {
        return bloque4SaneamientoInvierno;
    }

    /**
     * Sets the value of the bloque4SaneamientoInvierno property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBloque4SaneamientoInvierno(Double value) {
        this.bloque4SaneamientoInvierno = value;
    }

    /**
     * Gets the value of the bloque4SaneamientoVerano property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBloque4SaneamientoVerano() {
        return bloque4SaneamientoVerano;
    }

    /**
     * Sets the value of the bloque4SaneamientoVerano property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBloque4SaneamientoVerano(Double value) {
        this.bloque4SaneamientoVerano = value;
    }

    /**
     * Gets the value of the dinconac property.
     * 
     */
    public double getDinconac() {
        return dinconac;
    }

    /**
     * Sets the value of the dinconac property.
     * 
     */
    public void setDinconac(double value) {
        this.dinconac = value;
    }

    /**
     * Gets the value of the dinconaf property.
     * 
     */
    public double getDinconaf() {
        return dinconaf;
    }

    /**
     * Sets the value of the dinconaf property.
     * 
     */
    public void setDinconaf(double value) {
        this.dinconaf = value;
    }

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
     * Gets the value of the isDefault property.
     * 
     */
    public int getIsDefault() {
        return isDefault;
    }

    /**
     * Sets the value of the isDefault property.
     * 
     */
    public void setIsDefault(int value) {
        this.isDefault = value;
    }

    /**
     * Gets the value of the ivaCuotaCanal property.
     * 
     */
    public int getIvaCuotaCanal() {
        return ivaCuotaCanal;
    }

    /**
     * Sets the value of the ivaCuotaCanal property.
     * 
     */
    public void setIvaCuotaCanal(int value) {
        this.ivaCuotaCanal = value;
    }

    /**
     * Gets the value of the ivaHidrocon property.
     * 
     */
    public int getIvaHidrocon() {
        return ivaHidrocon;
    }

    /**
     * Sets the value of the ivaHidrocon property.
     * 
     */
    public void setIvaHidrocon(int value) {
        this.ivaHidrocon = value;
    }

    /**
     * Gets the value of the percentAduccion property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPercentAduccion() {
        return percentAduccion;
    }

    /**
     * Sets the value of the percentAduccion property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPercentAduccion(Double value) {
        this.percentAduccion = value;
    }

    /**
     * Gets the value of the percentAlcantarillado property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPercentAlcantarillado() {
        return percentAlcantarillado;
    }

    /**
     * Sets the value of the percentAlcantarillado property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPercentAlcantarillado(Double value) {
        this.percentAlcantarillado = value;
    }

    /**
     * Gets the value of the percentDepuracion property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPercentDepuracion() {
        return percentDepuracion;
    }

    /**
     * Sets the value of the percentDepuracion property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPercentDepuracion(Double value) {
        this.percentDepuracion = value;
    }

    /**
     * Gets the value of the percentDistribucion property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPercentDistribucion() {
        return percentDistribucion;
    }

    /**
     * Sets the value of the percentDistribucion property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPercentDistribucion(Double value) {
        this.percentDistribucion = value;
    }

    /**
     * Gets the value of the rateName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRateName() {
        return rateName;
    }

    /**
     * Sets the value of the rateName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRateName(String value) {
        this.rateName = value;
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
     * Gets the value of the recibohi property.
     * 
     */
    public int getRecibohi() {
        return recibohi;
    }

    /**
     * Sets the value of the recibohi property.
     * 
     */
    public void setRecibohi(int value) {
        this.recibohi = value;
    }

}
