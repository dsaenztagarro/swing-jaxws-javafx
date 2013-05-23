
package hidrocon.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for neighbour complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="neighbour">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="adelac" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="adelaf" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ajus" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="bankAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bankCccDetails" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bankDc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bankOffice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="buildingId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="comen" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="comenau" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="consumac" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="consumaf" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="consumc2" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="consumf2" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="estima" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="factupts" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="family" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fijaac" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="fijaaf" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="floor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gastoac" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="lecantac" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="lecantaf" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="lecantc2" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="lecantcl" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="lecantf2" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="lecantfl" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="leccon" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="lecposac" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="lecposaf" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="lecposc2" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="lecposcl" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="lecposf2" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="lecposfl" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="modelo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="modopago" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="neighbourName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="neighbourNumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="newac" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="newaf" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="nif" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numadmor" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numlector" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="observ" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="observ2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pelasiva" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="pelasm3fi" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="phoneNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="precay" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="precay2" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="precca1" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="precca2" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="ptsivaca" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="ptsivalecc" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="ptstotal" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="recStatus" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="reserva" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="totalac" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="totalaf" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="ultilectu" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="ultilpp40" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "neighbour", propOrder = {
    "adelac",
    "adelaf",
    "ajus",
    "bankAccount",
    "bankCccDetails",
    "bankDc",
    "bankOffice",
    "buildingId",
    "comen",
    "comenau",
    "consumac",
    "consumaf",
    "consumc2",
    "consumf2",
    "estima",
    "factupts",
    "family",
    "fijaac",
    "fijaaf",
    "floor",
    "gastoac",
    "id",
    "lecantac",
    "lecantaf",
    "lecantc2",
    "lecantcl",
    "lecantf2",
    "lecantfl",
    "leccon",
    "lecposac",
    "lecposaf",
    "lecposc2",
    "lecposcl",
    "lecposf2",
    "lecposfl",
    "modelo",
    "modopago",
    "neighbourName",
    "neighbourNumber",
    "newac",
    "newaf",
    "nif",
    "numadmor",
    "numlector",
    "observ",
    "observ2",
    "pelasiva",
    "pelasm3Fi",
    "phoneNumber",
    "precay",
    "precay2",
    "precca1",
    "precca2",
    "ptsivaca",
    "ptsivalecc",
    "ptstotal",
    "recStatus",
    "reserva",
    "totalac",
    "totalaf",
    "ultilectu",
    "ultilpp40"
})
public class Neighbour {

    protected int adelac;
    protected int adelaf;
    protected int ajus;
    protected String bankAccount;
    protected String bankCccDetails;
    protected String bankDc;
    protected String bankOffice;
    protected Integer buildingId;
    protected int comen;
    protected int comenau;
    protected int consumac;
    protected int consumaf;
    protected int consumc2;
    protected int consumf2;
    protected String estima;
    protected String factupts;
    protected String family;
    protected double fijaac;
    protected double fijaaf;
    protected String floor;
    protected double gastoac;
    protected Integer id;
    protected int lecantac;
    protected int lecantaf;
    protected int lecantc2;
    protected int lecantcl;
    protected int lecantf2;
    protected int lecantfl;
    protected double leccon;
    protected int lecposac;
    protected int lecposaf;
    protected int lecposc2;
    protected int lecposcl;
    protected int lecposf2;
    protected int lecposfl;
    protected int modelo;
    protected String modopago;
    protected String neighbourName;
    protected Integer neighbourNumber;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar newac;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar newaf;
    protected String nif;
    protected int numadmor;
    protected int numlector;
    protected String observ;
    protected String observ2;
    protected double pelasiva;
    @XmlElement(name = "pelasm3fi")
    protected double pelasm3Fi;
    protected String phoneNumber;
    protected double precay;
    protected double precay2;
    protected double precca1;
    protected double precca2;
    protected double ptsivaca;
    protected double ptsivalecc;
    protected double ptstotal;
    @XmlSchemaType(name = "unsignedShort")
    protected int recStatus;
    protected double reserva;
    protected double totalac;
    protected double totalaf;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar ultilectu;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar ultilpp40;

    /**
     * Gets the value of the adelac property.
     * 
     */
    public int getAdelac() {
        return adelac;
    }

    /**
     * Sets the value of the adelac property.
     * 
     */
    public void setAdelac(int value) {
        this.adelac = value;
    }

    /**
     * Gets the value of the adelaf property.
     * 
     */
    public int getAdelaf() {
        return adelaf;
    }

    /**
     * Sets the value of the adelaf property.
     * 
     */
    public void setAdelaf(int value) {
        this.adelaf = value;
    }

    /**
     * Gets the value of the ajus property.
     * 
     */
    public int getAjus() {
        return ajus;
    }

    /**
     * Sets the value of the ajus property.
     * 
     */
    public void setAjus(int value) {
        this.ajus = value;
    }

    /**
     * Gets the value of the bankAccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankAccount() {
        return bankAccount;
    }

    /**
     * Sets the value of the bankAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankAccount(String value) {
        this.bankAccount = value;
    }

    /**
     * Gets the value of the bankCccDetails property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankCccDetails() {
        return bankCccDetails;
    }

    /**
     * Sets the value of the bankCccDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankCccDetails(String value) {
        this.bankCccDetails = value;
    }

    /**
     * Gets the value of the bankDc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankDc() {
        return bankDc;
    }

    /**
     * Sets the value of the bankDc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankDc(String value) {
        this.bankDc = value;
    }

    /**
     * Gets the value of the bankOffice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankOffice() {
        return bankOffice;
    }

    /**
     * Sets the value of the bankOffice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankOffice(String value) {
        this.bankOffice = value;
    }

    /**
     * Gets the value of the buildingId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBuildingId() {
        return buildingId;
    }

    /**
     * Sets the value of the buildingId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBuildingId(Integer value) {
        this.buildingId = value;
    }

    /**
     * Gets the value of the comen property.
     * 
     */
    public int getComen() {
        return comen;
    }

    /**
     * Sets the value of the comen property.
     * 
     */
    public void setComen(int value) {
        this.comen = value;
    }

    /**
     * Gets the value of the comenau property.
     * 
     */
    public int getComenau() {
        return comenau;
    }

    /**
     * Sets the value of the comenau property.
     * 
     */
    public void setComenau(int value) {
        this.comenau = value;
    }

    /**
     * Gets the value of the consumac property.
     * 
     */
    public int getConsumac() {
        return consumac;
    }

    /**
     * Sets the value of the consumac property.
     * 
     */
    public void setConsumac(int value) {
        this.consumac = value;
    }

    /**
     * Gets the value of the consumaf property.
     * 
     */
    public int getConsumaf() {
        return consumaf;
    }

    /**
     * Sets the value of the consumaf property.
     * 
     */
    public void setConsumaf(int value) {
        this.consumaf = value;
    }

    /**
     * Gets the value of the consumc2 property.
     * 
     */
    public int getConsumc2() {
        return consumc2;
    }

    /**
     * Sets the value of the consumc2 property.
     * 
     */
    public void setConsumc2(int value) {
        this.consumc2 = value;
    }

    /**
     * Gets the value of the consumf2 property.
     * 
     */
    public int getConsumf2() {
        return consumf2;
    }

    /**
     * Sets the value of the consumf2 property.
     * 
     */
    public void setConsumf2(int value) {
        this.consumf2 = value;
    }

    /**
     * Gets the value of the estima property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstima() {
        return estima;
    }

    /**
     * Sets the value of the estima property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstima(String value) {
        this.estima = value;
    }

    /**
     * Gets the value of the factupts property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFactupts() {
        return factupts;
    }

    /**
     * Sets the value of the factupts property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFactupts(String value) {
        this.factupts = value;
    }

    /**
     * Gets the value of the family property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFamily() {
        return family;
    }

    /**
     * Sets the value of the family property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFamily(String value) {
        this.family = value;
    }

    /**
     * Gets the value of the fijaac property.
     * 
     */
    public double getFijaac() {
        return fijaac;
    }

    /**
     * Sets the value of the fijaac property.
     * 
     */
    public void setFijaac(double value) {
        this.fijaac = value;
    }

    /**
     * Gets the value of the fijaaf property.
     * 
     */
    public double getFijaaf() {
        return fijaaf;
    }

    /**
     * Sets the value of the fijaaf property.
     * 
     */
    public void setFijaaf(double value) {
        this.fijaaf = value;
    }

    /**
     * Gets the value of the floor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFloor() {
        return floor;
    }

    /**
     * Sets the value of the floor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFloor(String value) {
        this.floor = value;
    }

    /**
     * Gets the value of the gastoac property.
     * 
     */
    public double getGastoac() {
        return gastoac;
    }

    /**
     * Sets the value of the gastoac property.
     * 
     */
    public void setGastoac(double value) {
        this.gastoac = value;
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
     * Gets the value of the lecantac property.
     * 
     */
    public int getLecantac() {
        return lecantac;
    }

    /**
     * Sets the value of the lecantac property.
     * 
     */
    public void setLecantac(int value) {
        this.lecantac = value;
    }

    /**
     * Gets the value of the lecantaf property.
     * 
     */
    public int getLecantaf() {
        return lecantaf;
    }

    /**
     * Sets the value of the lecantaf property.
     * 
     */
    public void setLecantaf(int value) {
        this.lecantaf = value;
    }

    /**
     * Gets the value of the lecantc2 property.
     * 
     */
    public int getLecantc2() {
        return lecantc2;
    }

    /**
     * Sets the value of the lecantc2 property.
     * 
     */
    public void setLecantc2(int value) {
        this.lecantc2 = value;
    }

    /**
     * Gets the value of the lecantcl property.
     * 
     */
    public int getLecantcl() {
        return lecantcl;
    }

    /**
     * Sets the value of the lecantcl property.
     * 
     */
    public void setLecantcl(int value) {
        this.lecantcl = value;
    }

    /**
     * Gets the value of the lecantf2 property.
     * 
     */
    public int getLecantf2() {
        return lecantf2;
    }

    /**
     * Sets the value of the lecantf2 property.
     * 
     */
    public void setLecantf2(int value) {
        this.lecantf2 = value;
    }

    /**
     * Gets the value of the lecantfl property.
     * 
     */
    public int getLecantfl() {
        return lecantfl;
    }

    /**
     * Sets the value of the lecantfl property.
     * 
     */
    public void setLecantfl(int value) {
        this.lecantfl = value;
    }

    /**
     * Gets the value of the leccon property.
     * 
     */
    public double getLeccon() {
        return leccon;
    }

    /**
     * Sets the value of the leccon property.
     * 
     */
    public void setLeccon(double value) {
        this.leccon = value;
    }

    /**
     * Gets the value of the lecposac property.
     * 
     */
    public int getLecposac() {
        return lecposac;
    }

    /**
     * Sets the value of the lecposac property.
     * 
     */
    public void setLecposac(int value) {
        this.lecposac = value;
    }

    /**
     * Gets the value of the lecposaf property.
     * 
     */
    public int getLecposaf() {
        return lecposaf;
    }

    /**
     * Sets the value of the lecposaf property.
     * 
     */
    public void setLecposaf(int value) {
        this.lecposaf = value;
    }

    /**
     * Gets the value of the lecposc2 property.
     * 
     */
    public int getLecposc2() {
        return lecposc2;
    }

    /**
     * Sets the value of the lecposc2 property.
     * 
     */
    public void setLecposc2(int value) {
        this.lecposc2 = value;
    }

    /**
     * Gets the value of the lecposcl property.
     * 
     */
    public int getLecposcl() {
        return lecposcl;
    }

    /**
     * Sets the value of the lecposcl property.
     * 
     */
    public void setLecposcl(int value) {
        this.lecposcl = value;
    }

    /**
     * Gets the value of the lecposf2 property.
     * 
     */
    public int getLecposf2() {
        return lecposf2;
    }

    /**
     * Sets the value of the lecposf2 property.
     * 
     */
    public void setLecposf2(int value) {
        this.lecposf2 = value;
    }

    /**
     * Gets the value of the lecposfl property.
     * 
     */
    public int getLecposfl() {
        return lecposfl;
    }

    /**
     * Sets the value of the lecposfl property.
     * 
     */
    public void setLecposfl(int value) {
        this.lecposfl = value;
    }

    /**
     * Gets the value of the modelo property.
     * 
     */
    public int getModelo() {
        return modelo;
    }

    /**
     * Sets the value of the modelo property.
     * 
     */
    public void setModelo(int value) {
        this.modelo = value;
    }

    /**
     * Gets the value of the modopago property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModopago() {
        return modopago;
    }

    /**
     * Sets the value of the modopago property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModopago(String value) {
        this.modopago = value;
    }

    /**
     * Gets the value of the neighbourName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNeighbourName() {
        return neighbourName;
    }

    /**
     * Sets the value of the neighbourName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNeighbourName(String value) {
        this.neighbourName = value;
    }

    /**
     * Gets the value of the neighbourNumber property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNeighbourNumber() {
        return neighbourNumber;
    }

    /**
     * Sets the value of the neighbourNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNeighbourNumber(Integer value) {
        this.neighbourNumber = value;
    }

    /**
     * Gets the value of the newac property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getNewac() {
        return newac;
    }

    /**
     * Sets the value of the newac property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setNewac(XMLGregorianCalendar value) {
        this.newac = value;
    }

    /**
     * Gets the value of the newaf property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getNewaf() {
        return newaf;
    }

    /**
     * Sets the value of the newaf property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setNewaf(XMLGregorianCalendar value) {
        this.newaf = value;
    }

    /**
     * Gets the value of the nif property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNif() {
        return nif;
    }

    /**
     * Sets the value of the nif property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNif(String value) {
        this.nif = value;
    }

    /**
     * Gets the value of the numadmor property.
     * 
     */
    public int getNumadmor() {
        return numadmor;
    }

    /**
     * Sets the value of the numadmor property.
     * 
     */
    public void setNumadmor(int value) {
        this.numadmor = value;
    }

    /**
     * Gets the value of the numlector property.
     * 
     */
    public int getNumlector() {
        return numlector;
    }

    /**
     * Sets the value of the numlector property.
     * 
     */
    public void setNumlector(int value) {
        this.numlector = value;
    }

    /**
     * Gets the value of the observ property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObserv() {
        return observ;
    }

    /**
     * Sets the value of the observ property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObserv(String value) {
        this.observ = value;
    }

    /**
     * Gets the value of the observ2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObserv2() {
        return observ2;
    }

    /**
     * Sets the value of the observ2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObserv2(String value) {
        this.observ2 = value;
    }

    /**
     * Gets the value of the pelasiva property.
     * 
     */
    public double getPelasiva() {
        return pelasiva;
    }

    /**
     * Sets the value of the pelasiva property.
     * 
     */
    public void setPelasiva(double value) {
        this.pelasiva = value;
    }

    /**
     * Gets the value of the pelasm3Fi property.
     * 
     */
    public double getPelasm3Fi() {
        return pelasm3Fi;
    }

    /**
     * Sets the value of the pelasm3Fi property.
     * 
     */
    public void setPelasm3Fi(double value) {
        this.pelasm3Fi = value;
    }

    /**
     * Gets the value of the phoneNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the value of the phoneNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhoneNumber(String value) {
        this.phoneNumber = value;
    }

    /**
     * Gets the value of the precay property.
     * 
     */
    public double getPrecay() {
        return precay;
    }

    /**
     * Sets the value of the precay property.
     * 
     */
    public void setPrecay(double value) {
        this.precay = value;
    }

    /**
     * Gets the value of the precay2 property.
     * 
     */
    public double getPrecay2() {
        return precay2;
    }

    /**
     * Sets the value of the precay2 property.
     * 
     */
    public void setPrecay2(double value) {
        this.precay2 = value;
    }

    /**
     * Gets the value of the precca1 property.
     * 
     */
    public double getPrecca1() {
        return precca1;
    }

    /**
     * Sets the value of the precca1 property.
     * 
     */
    public void setPrecca1(double value) {
        this.precca1 = value;
    }

    /**
     * Gets the value of the precca2 property.
     * 
     */
    public double getPrecca2() {
        return precca2;
    }

    /**
     * Sets the value of the precca2 property.
     * 
     */
    public void setPrecca2(double value) {
        this.precca2 = value;
    }

    /**
     * Gets the value of the ptsivaca property.
     * 
     */
    public double getPtsivaca() {
        return ptsivaca;
    }

    /**
     * Sets the value of the ptsivaca property.
     * 
     */
    public void setPtsivaca(double value) {
        this.ptsivaca = value;
    }

    /**
     * Gets the value of the ptsivalecc property.
     * 
     */
    public double getPtsivalecc() {
        return ptsivalecc;
    }

    /**
     * Sets the value of the ptsivalecc property.
     * 
     */
    public void setPtsivalecc(double value) {
        this.ptsivalecc = value;
    }

    /**
     * Gets the value of the ptstotal property.
     * 
     */
    public double getPtstotal() {
        return ptstotal;
    }

    /**
     * Sets the value of the ptstotal property.
     * 
     */
    public void setPtstotal(double value) {
        this.ptstotal = value;
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
     * Gets the value of the reserva property.
     * 
     */
    public double getReserva() {
        return reserva;
    }

    /**
     * Sets the value of the reserva property.
     * 
     */
    public void setReserva(double value) {
        this.reserva = value;
    }

    /**
     * Gets the value of the totalac property.
     * 
     */
    public double getTotalac() {
        return totalac;
    }

    /**
     * Sets the value of the totalac property.
     * 
     */
    public void setTotalac(double value) {
        this.totalac = value;
    }

    /**
     * Gets the value of the totalaf property.
     * 
     */
    public double getTotalaf() {
        return totalaf;
    }

    /**
     * Sets the value of the totalaf property.
     * 
     */
    public void setTotalaf(double value) {
        this.totalaf = value;
    }

    /**
     * Gets the value of the ultilectu property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getUltilectu() {
        return ultilectu;
    }

    /**
     * Sets the value of the ultilectu property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setUltilectu(XMLGregorianCalendar value) {
        this.ultilectu = value;
    }

    /**
     * Gets the value of the ultilpp40 property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getUltilpp40() {
        return ultilpp40;
    }

    /**
     * Sets the value of the ultilpp40 property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setUltilpp40(XMLGregorianCalendar value) {
        this.ultilpp40 = value;
    }

}
