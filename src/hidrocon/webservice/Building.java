
package hidrocon.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for building complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="building">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="acpagaaf" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="administratorId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ammountM3ColdWater" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ammountM3HotWater" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="bakcuocan" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="banco" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="billPerBlocks" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" minOccurs="0"/>
 *         &lt;element name="buildingCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="buildingNumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="circuito" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contactName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contactPhoneNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contactPhoneNumber2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cuotacanal" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="cuotalect" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="depuracion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="diameterBuilding" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="diameterHome" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="dinconac" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="dinconaf" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="dinnocapi" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="dircorres" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="disco" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="distcorres" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="emitido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechinicio" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fijoac" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="fijoaf" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="hidroconBankAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hidroconBankDc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hidroconBankEntity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hidroconBankIban" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hidroconBankOffice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="iesa" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="lisa" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="lisb" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="lisg" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="lisp" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="liss" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="madridcap" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mescierre" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="mescobro" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="modelId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nif" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombcorres" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="noticeAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="noticeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="noticeNumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="noticeZipCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numberColdWaterMeters" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="numberColdWaterMetersPerHome" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="numberHotWaterMeters" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="numberHotWaterMetersPerHome" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="numberReadingsPerYear" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="numviv" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="observations" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="periodocob" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="province" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ptsalcobro" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="ptsanual" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="ptsneto" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="rateId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="rateIsDefault" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="readerObservations" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="recStatus" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="relatedBankAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="relatedBankCccDetails" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="relatedBankDc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="relatedBankEntity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="relatedBankIban" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="relatedBankOffice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reserva" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reserva1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reserva2" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="reserva3" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="routeIsDefault" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="sucursal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tarifabim" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="tarifacont" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="tipoesti" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="typeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ultiveci" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="zipCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "building", propOrder = {
    "acpagaaf",
    "address",
    "administratorId",
    "ammountM3ColdWater",
    "ammountM3HotWater",
    "bakcuocan",
    "banco",
    "billPerBlocks",
    "buildingCode",
    "buildingNumber",
    "circuito",
    "contactName",
    "contactPhoneNumber",
    "contactPhoneNumber2",
    "cta",
    "cuotacanal",
    "cuotalect",
    "depuracion",
    "diameterBuilding",
    "diameterHome",
    "dinconac",
    "dinconaf",
    "dinnocapi",
    "dircorres",
    "disco",
    "distcorres",
    "emitido",
    "fechinicio",
    "fijoac",
    "fijoaf",
    "hidroconBankAccount",
    "hidroconBankDc",
    "hidroconBankEntity",
    "hidroconBankIban",
    "hidroconBankOffice",
    "id",
    "iesa",
    "lisa",
    "lisb",
    "lisg",
    "lisp",
    "liss",
    "madridcap",
    "mescierre",
    "mescobro",
    "modelId",
    "nif",
    "nombcorres",
    "noticeAddress",
    "noticeName",
    "noticeNumber",
    "noticeZipCode",
    "numberColdWaterMeters",
    "numberColdWaterMetersPerHome",
    "numberHotWaterMeters",
    "numberHotWaterMetersPerHome",
    "numberReadingsPerYear",
    "numviv",
    "observations",
    "periodocob",
    "province",
    "ptsalcobro",
    "ptsanual",
    "ptsneto",
    "rateId",
    "rateIsDefault",
    "readerObservations",
    "recStatus",
    "relatedBankAccount",
    "relatedBankCccDetails",
    "relatedBankDc",
    "relatedBankEntity",
    "relatedBankIban",
    "relatedBankOffice",
    "reserva",
    "reserva1",
    "reserva2",
    "reserva3",
    "routeIsDefault",
    "sucursal",
    "tarifabim",
    "tarifacont",
    "tipoesti",
    "typeName",
    "ultiveci",
    "zipCode"
})
public class Building {

    protected String acpagaaf;
    protected String address;
    protected Integer administratorId;
    protected Integer ammountM3ColdWater;
    protected Integer ammountM3HotWater;
    protected double bakcuocan;
    protected String banco;
    @XmlSchemaType(name = "unsignedShort")
    protected Integer billPerBlocks;
    protected String buildingCode;
    protected Integer buildingNumber;
    protected String circuito;
    protected String contactName;
    protected String contactPhoneNumber;
    protected String contactPhoneNumber2;
    protected String cta;
    protected double cuotacanal;
    protected String cuotalect;
    protected String depuracion;
    protected Integer diameterBuilding;
    protected Integer diameterHome;
    protected double dinconac;
    protected double dinconaf;
    protected double dinnocapi;
    protected String dircorres;
    protected String disco;
    protected int distcorres;
    protected String emitido;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechinicio;
    protected double fijoac;
    protected double fijoaf;
    protected String hidroconBankAccount;
    protected String hidroconBankDc;
    protected String hidroconBankEntity;
    protected String hidroconBankIban;
    protected String hidroconBankOffice;
    protected Integer id;
    protected int iesa;
    protected int lisa;
    protected int lisb;
    protected int lisg;
    protected int lisp;
    protected int liss;
    protected String madridcap;
    protected int mescierre;
    protected int mescobro;
    protected Integer modelId;
    protected String nif;
    protected String nombcorres;
    protected String noticeAddress;
    protected String noticeName;
    protected Integer noticeNumber;
    protected String noticeZipCode;
    protected Integer numberColdWaterMeters;
    protected Integer numberColdWaterMetersPerHome;
    protected Integer numberHotWaterMeters;
    protected Integer numberHotWaterMetersPerHome;
    protected Integer numberReadingsPerYear;
    protected int numviv;
    protected String observations;
    protected int periodocob;
    protected String province;
    protected double ptsalcobro;
    protected double ptsanual;
    protected double ptsneto;
    protected int rateId;
    @XmlSchemaType(name = "unsignedShort")
    protected int rateIsDefault;
    protected String readerObservations;
    @XmlSchemaType(name = "unsignedShort")
    protected int recStatus;
    protected String relatedBankAccount;
    protected String relatedBankCccDetails;
    protected String relatedBankDc;
    protected String relatedBankEntity;
    protected String relatedBankIban;
    protected String relatedBankOffice;
    protected String reserva;
    protected String reserva1;
    protected int reserva2;
    protected double reserva3;
    @XmlSchemaType(name = "unsignedShort")
    protected int routeIsDefault;
    protected String sucursal;
    protected double tarifabim;
    protected double tarifacont;
    protected String tipoesti;
    protected String typeName;
    protected int ultiveci;
    protected String zipCode;

    /**
     * Gets the value of the acpagaaf property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcpagaaf() {
        return acpagaaf;
    }

    /**
     * Sets the value of the acpagaaf property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcpagaaf(String value) {
        this.acpagaaf = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * Gets the value of the administratorId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAdministratorId() {
        return administratorId;
    }

    /**
     * Sets the value of the administratorId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAdministratorId(Integer value) {
        this.administratorId = value;
    }

    /**
     * Gets the value of the ammountM3ColdWater property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAmmountM3ColdWater() {
        return ammountM3ColdWater;
    }

    /**
     * Sets the value of the ammountM3ColdWater property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAmmountM3ColdWater(Integer value) {
        this.ammountM3ColdWater = value;
    }

    /**
     * Gets the value of the ammountM3HotWater property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAmmountM3HotWater() {
        return ammountM3HotWater;
    }

    /**
     * Sets the value of the ammountM3HotWater property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAmmountM3HotWater(Integer value) {
        this.ammountM3HotWater = value;
    }

    /**
     * Gets the value of the bakcuocan property.
     * 
     */
    public double getBakcuocan() {
        return bakcuocan;
    }

    /**
     * Sets the value of the bakcuocan property.
     * 
     */
    public void setBakcuocan(double value) {
        this.bakcuocan = value;
    }

    /**
     * Gets the value of the banco property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBanco() {
        return banco;
    }

    /**
     * Sets the value of the banco property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBanco(String value) {
        this.banco = value;
    }

    /**
     * Gets the value of the billPerBlocks property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBillPerBlocks() {
        return billPerBlocks;
    }

    /**
     * Sets the value of the billPerBlocks property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBillPerBlocks(Integer value) {
        this.billPerBlocks = value;
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
     * Gets the value of the circuito property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCircuito() {
        return circuito;
    }

    /**
     * Sets the value of the circuito property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCircuito(String value) {
        this.circuito = value;
    }

    /**
     * Gets the value of the contactName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * Sets the value of the contactName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactName(String value) {
        this.contactName = value;
    }

    /**
     * Gets the value of the contactPhoneNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    /**
     * Sets the value of the contactPhoneNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactPhoneNumber(String value) {
        this.contactPhoneNumber = value;
    }

    /**
     * Gets the value of the contactPhoneNumber2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactPhoneNumber2() {
        return contactPhoneNumber2;
    }

    /**
     * Sets the value of the contactPhoneNumber2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactPhoneNumber2(String value) {
        this.contactPhoneNumber2 = value;
    }

    /**
     * Gets the value of the cta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCta() {
        return cta;
    }

    /**
     * Sets the value of the cta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCta(String value) {
        this.cta = value;
    }

    /**
     * Gets the value of the cuotacanal property.
     * 
     */
    public double getCuotacanal() {
        return cuotacanal;
    }

    /**
     * Sets the value of the cuotacanal property.
     * 
     */
    public void setCuotacanal(double value) {
        this.cuotacanal = value;
    }

    /**
     * Gets the value of the cuotalect property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCuotalect() {
        return cuotalect;
    }

    /**
     * Sets the value of the cuotalect property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCuotalect(String value) {
        this.cuotalect = value;
    }

    /**
     * Gets the value of the depuracion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepuracion() {
        return depuracion;
    }

    /**
     * Sets the value of the depuracion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepuracion(String value) {
        this.depuracion = value;
    }

    /**
     * Gets the value of the diameterBuilding property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDiameterBuilding() {
        return diameterBuilding;
    }

    /**
     * Sets the value of the diameterBuilding property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDiameterBuilding(Integer value) {
        this.diameterBuilding = value;
    }

    /**
     * Gets the value of the diameterHome property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDiameterHome() {
        return diameterHome;
    }

    /**
     * Sets the value of the diameterHome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDiameterHome(Integer value) {
        this.diameterHome = value;
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
     * Gets the value of the dinnocapi property.
     * 
     */
    public double getDinnocapi() {
        return dinnocapi;
    }

    /**
     * Sets the value of the dinnocapi property.
     * 
     */
    public void setDinnocapi(double value) {
        this.dinnocapi = value;
    }

    /**
     * Gets the value of the dircorres property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDircorres() {
        return dircorres;
    }

    /**
     * Sets the value of the dircorres property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDircorres(String value) {
        this.dircorres = value;
    }

    /**
     * Gets the value of the disco property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisco() {
        return disco;
    }

    /**
     * Sets the value of the disco property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisco(String value) {
        this.disco = value;
    }

    /**
     * Gets the value of the distcorres property.
     * 
     */
    public int getDistcorres() {
        return distcorres;
    }

    /**
     * Sets the value of the distcorres property.
     * 
     */
    public void setDistcorres(int value) {
        this.distcorres = value;
    }

    /**
     * Gets the value of the emitido property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmitido() {
        return emitido;
    }

    /**
     * Sets the value of the emitido property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmitido(String value) {
        this.emitido = value;
    }

    /**
     * Gets the value of the fechinicio property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechinicio() {
        return fechinicio;
    }

    /**
     * Sets the value of the fechinicio property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechinicio(XMLGregorianCalendar value) {
        this.fechinicio = value;
    }

    /**
     * Gets the value of the fijoac property.
     * 
     */
    public double getFijoac() {
        return fijoac;
    }

    /**
     * Sets the value of the fijoac property.
     * 
     */
    public void setFijoac(double value) {
        this.fijoac = value;
    }

    /**
     * Gets the value of the fijoaf property.
     * 
     */
    public double getFijoaf() {
        return fijoaf;
    }

    /**
     * Sets the value of the fijoaf property.
     * 
     */
    public void setFijoaf(double value) {
        this.fijoaf = value;
    }

    /**
     * Gets the value of the hidroconBankAccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHidroconBankAccount() {
        return hidroconBankAccount;
    }

    /**
     * Sets the value of the hidroconBankAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHidroconBankAccount(String value) {
        this.hidroconBankAccount = value;
    }

    /**
     * Gets the value of the hidroconBankDc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHidroconBankDc() {
        return hidroconBankDc;
    }

    /**
     * Sets the value of the hidroconBankDc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHidroconBankDc(String value) {
        this.hidroconBankDc = value;
    }

    /**
     * Gets the value of the hidroconBankEntity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHidroconBankEntity() {
        return hidroconBankEntity;
    }

    /**
     * Sets the value of the hidroconBankEntity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHidroconBankEntity(String value) {
        this.hidroconBankEntity = value;
    }

    /**
     * Gets the value of the hidroconBankIban property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHidroconBankIban() {
        return hidroconBankIban;
    }

    /**
     * Sets the value of the hidroconBankIban property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHidroconBankIban(String value) {
        this.hidroconBankIban = value;
    }

    /**
     * Gets the value of the hidroconBankOffice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHidroconBankOffice() {
        return hidroconBankOffice;
    }

    /**
     * Sets the value of the hidroconBankOffice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHidroconBankOffice(String value) {
        this.hidroconBankOffice = value;
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
     * Gets the value of the iesa property.
     * 
     */
    public int getIesa() {
        return iesa;
    }

    /**
     * Sets the value of the iesa property.
     * 
     */
    public void setIesa(int value) {
        this.iesa = value;
    }

    /**
     * Gets the value of the lisa property.
     * 
     */
    public int getLisa() {
        return lisa;
    }

    /**
     * Sets the value of the lisa property.
     * 
     */
    public void setLisa(int value) {
        this.lisa = value;
    }

    /**
     * Gets the value of the lisb property.
     * 
     */
    public int getLisb() {
        return lisb;
    }

    /**
     * Sets the value of the lisb property.
     * 
     */
    public void setLisb(int value) {
        this.lisb = value;
    }

    /**
     * Gets the value of the lisg property.
     * 
     */
    public int getLisg() {
        return lisg;
    }

    /**
     * Sets the value of the lisg property.
     * 
     */
    public void setLisg(int value) {
        this.lisg = value;
    }

    /**
     * Gets the value of the lisp property.
     * 
     */
    public int getLisp() {
        return lisp;
    }

    /**
     * Sets the value of the lisp property.
     * 
     */
    public void setLisp(int value) {
        this.lisp = value;
    }

    /**
     * Gets the value of the liss property.
     * 
     */
    public int getLiss() {
        return liss;
    }

    /**
     * Sets the value of the liss property.
     * 
     */
    public void setLiss(int value) {
        this.liss = value;
    }

    /**
     * Gets the value of the madridcap property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMadridcap() {
        return madridcap;
    }

    /**
     * Sets the value of the madridcap property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMadridcap(String value) {
        this.madridcap = value;
    }

    /**
     * Gets the value of the mescierre property.
     * 
     */
    public int getMescierre() {
        return mescierre;
    }

    /**
     * Sets the value of the mescierre property.
     * 
     */
    public void setMescierre(int value) {
        this.mescierre = value;
    }

    /**
     * Gets the value of the mescobro property.
     * 
     */
    public int getMescobro() {
        return mescobro;
    }

    /**
     * Sets the value of the mescobro property.
     * 
     */
    public void setMescobro(int value) {
        this.mescobro = value;
    }

    /**
     * Gets the value of the modelId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getModelId() {
        return modelId;
    }

    /**
     * Sets the value of the modelId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setModelId(Integer value) {
        this.modelId = value;
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
     * Gets the value of the nombcorres property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombcorres() {
        return nombcorres;
    }

    /**
     * Sets the value of the nombcorres property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombcorres(String value) {
        this.nombcorres = value;
    }

    /**
     * Gets the value of the noticeAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoticeAddress() {
        return noticeAddress;
    }

    /**
     * Sets the value of the noticeAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoticeAddress(String value) {
        this.noticeAddress = value;
    }

    /**
     * Gets the value of the noticeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoticeName() {
        return noticeName;
    }

    /**
     * Sets the value of the noticeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoticeName(String value) {
        this.noticeName = value;
    }

    /**
     * Gets the value of the noticeNumber property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNoticeNumber() {
        return noticeNumber;
    }

    /**
     * Sets the value of the noticeNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNoticeNumber(Integer value) {
        this.noticeNumber = value;
    }

    /**
     * Gets the value of the noticeZipCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoticeZipCode() {
        return noticeZipCode;
    }

    /**
     * Sets the value of the noticeZipCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoticeZipCode(String value) {
        this.noticeZipCode = value;
    }

    /**
     * Gets the value of the numberColdWaterMeters property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumberColdWaterMeters() {
        return numberColdWaterMeters;
    }

    /**
     * Sets the value of the numberColdWaterMeters property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumberColdWaterMeters(Integer value) {
        this.numberColdWaterMeters = value;
    }

    /**
     * Gets the value of the numberColdWaterMetersPerHome property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumberColdWaterMetersPerHome() {
        return numberColdWaterMetersPerHome;
    }

    /**
     * Sets the value of the numberColdWaterMetersPerHome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumberColdWaterMetersPerHome(Integer value) {
        this.numberColdWaterMetersPerHome = value;
    }

    /**
     * Gets the value of the numberHotWaterMeters property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumberHotWaterMeters() {
        return numberHotWaterMeters;
    }

    /**
     * Sets the value of the numberHotWaterMeters property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumberHotWaterMeters(Integer value) {
        this.numberHotWaterMeters = value;
    }

    /**
     * Gets the value of the numberHotWaterMetersPerHome property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumberHotWaterMetersPerHome() {
        return numberHotWaterMetersPerHome;
    }

    /**
     * Sets the value of the numberHotWaterMetersPerHome property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumberHotWaterMetersPerHome(Integer value) {
        this.numberHotWaterMetersPerHome = value;
    }

    /**
     * Gets the value of the numberReadingsPerYear property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumberReadingsPerYear() {
        return numberReadingsPerYear;
    }

    /**
     * Sets the value of the numberReadingsPerYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumberReadingsPerYear(Integer value) {
        this.numberReadingsPerYear = value;
    }

    /**
     * Gets the value of the numviv property.
     * 
     */
    public int getNumviv() {
        return numviv;
    }

    /**
     * Sets the value of the numviv property.
     * 
     */
    public void setNumviv(int value) {
        this.numviv = value;
    }

    /**
     * Gets the value of the observations property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObservations() {
        return observations;
    }

    /**
     * Sets the value of the observations property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObservations(String value) {
        this.observations = value;
    }

    /**
     * Gets the value of the periodocob property.
     * 
     */
    public int getPeriodocob() {
        return periodocob;
    }

    /**
     * Sets the value of the periodocob property.
     * 
     */
    public void setPeriodocob(int value) {
        this.periodocob = value;
    }

    /**
     * Gets the value of the province property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProvince() {
        return province;
    }

    /**
     * Sets the value of the province property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProvince(String value) {
        this.province = value;
    }

    /**
     * Gets the value of the ptsalcobro property.
     * 
     */
    public double getPtsalcobro() {
        return ptsalcobro;
    }

    /**
     * Sets the value of the ptsalcobro property.
     * 
     */
    public void setPtsalcobro(double value) {
        this.ptsalcobro = value;
    }

    /**
     * Gets the value of the ptsanual property.
     * 
     */
    public double getPtsanual() {
        return ptsanual;
    }

    /**
     * Sets the value of the ptsanual property.
     * 
     */
    public void setPtsanual(double value) {
        this.ptsanual = value;
    }

    /**
     * Gets the value of the ptsneto property.
     * 
     */
    public double getPtsneto() {
        return ptsneto;
    }

    /**
     * Sets the value of the ptsneto property.
     * 
     */
    public void setPtsneto(double value) {
        this.ptsneto = value;
    }

    /**
     * Gets the value of the rateId property.
     * 
     */
    public int getRateId() {
        return rateId;
    }

    /**
     * Sets the value of the rateId property.
     * 
     */
    public void setRateId(int value) {
        this.rateId = value;
    }

    /**
     * Gets the value of the rateIsDefault property.
     * 
     */
    public int getRateIsDefault() {
        return rateIsDefault;
    }

    /**
     * Sets the value of the rateIsDefault property.
     * 
     */
    public void setRateIsDefault(int value) {
        this.rateIsDefault = value;
    }

    /**
     * Gets the value of the readerObservations property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReaderObservations() {
        return readerObservations;
    }

    /**
     * Sets the value of the readerObservations property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReaderObservations(String value) {
        this.readerObservations = value;
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
     * Gets the value of the relatedBankAccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelatedBankAccount() {
        return relatedBankAccount;
    }

    /**
     * Sets the value of the relatedBankAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelatedBankAccount(String value) {
        this.relatedBankAccount = value;
    }

    /**
     * Gets the value of the relatedBankCccDetails property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelatedBankCccDetails() {
        return relatedBankCccDetails;
    }

    /**
     * Sets the value of the relatedBankCccDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelatedBankCccDetails(String value) {
        this.relatedBankCccDetails = value;
    }

    /**
     * Gets the value of the relatedBankDc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelatedBankDc() {
        return relatedBankDc;
    }

    /**
     * Sets the value of the relatedBankDc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelatedBankDc(String value) {
        this.relatedBankDc = value;
    }

    /**
     * Gets the value of the relatedBankEntity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelatedBankEntity() {
        return relatedBankEntity;
    }

    /**
     * Sets the value of the relatedBankEntity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelatedBankEntity(String value) {
        this.relatedBankEntity = value;
    }

    /**
     * Gets the value of the relatedBankIban property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelatedBankIban() {
        return relatedBankIban;
    }

    /**
     * Sets the value of the relatedBankIban property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelatedBankIban(String value) {
        this.relatedBankIban = value;
    }

    /**
     * Gets the value of the relatedBankOffice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelatedBankOffice() {
        return relatedBankOffice;
    }

    /**
     * Sets the value of the relatedBankOffice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelatedBankOffice(String value) {
        this.relatedBankOffice = value;
    }

    /**
     * Gets the value of the reserva property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReserva() {
        return reserva;
    }

    /**
     * Sets the value of the reserva property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReserva(String value) {
        this.reserva = value;
    }

    /**
     * Gets the value of the reserva1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReserva1() {
        return reserva1;
    }

    /**
     * Sets the value of the reserva1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReserva1(String value) {
        this.reserva1 = value;
    }

    /**
     * Gets the value of the reserva2 property.
     * 
     */
    public int getReserva2() {
        return reserva2;
    }

    /**
     * Sets the value of the reserva2 property.
     * 
     */
    public void setReserva2(int value) {
        this.reserva2 = value;
    }

    /**
     * Gets the value of the reserva3 property.
     * 
     */
    public double getReserva3() {
        return reserva3;
    }

    /**
     * Sets the value of the reserva3 property.
     * 
     */
    public void setReserva3(double value) {
        this.reserva3 = value;
    }

    /**
     * Gets the value of the routeIsDefault property.
     * 
     */
    public int getRouteIsDefault() {
        return routeIsDefault;
    }

    /**
     * Sets the value of the routeIsDefault property.
     * 
     */
    public void setRouteIsDefault(int value) {
        this.routeIsDefault = value;
    }

    /**
     * Gets the value of the sucursal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSucursal() {
        return sucursal;
    }

    /**
     * Sets the value of the sucursal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSucursal(String value) {
        this.sucursal = value;
    }

    /**
     * Gets the value of the tarifabim property.
     * 
     */
    public double getTarifabim() {
        return tarifabim;
    }

    /**
     * Sets the value of the tarifabim property.
     * 
     */
    public void setTarifabim(double value) {
        this.tarifabim = value;
    }

    /**
     * Gets the value of the tarifacont property.
     * 
     */
    public double getTarifacont() {
        return tarifacont;
    }

    /**
     * Sets the value of the tarifacont property.
     * 
     */
    public void setTarifacont(double value) {
        this.tarifacont = value;
    }

    /**
     * Gets the value of the tipoesti property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoesti() {
        return tipoesti;
    }

    /**
     * Sets the value of the tipoesti property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoesti(String value) {
        this.tipoesti = value;
    }

    /**
     * Gets the value of the typeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * Sets the value of the typeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeName(String value) {
        this.typeName = value;
    }

    /**
     * Gets the value of the ultiveci property.
     * 
     */
    public int getUltiveci() {
        return ultiveci;
    }

    /**
     * Sets the value of the ultiveci property.
     * 
     */
    public void setUltiveci(int value) {
        this.ultiveci = value;
    }

    /**
     * Gets the value of the zipCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Sets the value of the zipCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZipCode(String value) {
        this.zipCode = value;
    }

}
