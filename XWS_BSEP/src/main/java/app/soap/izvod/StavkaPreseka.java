//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.22 at 11:27:01 PM CEST 
//


package app.soap.izvod;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for stavka-preseka complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="stavka-preseka">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="duznik-nalogodavac">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="255"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="svrha-placanja">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="255"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="primalac-poverilac">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="255"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="datum-naloga" type="{soap.app/izvod}TDate"/>
 *         &lt;element name="iznos">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;fractionDigits value="2"/>
 *               &lt;totalDigits value="17"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="datum-valute" type="{soap.app/izvod}TDate"/>
 *         &lt;element name="racunduznik" type="{soap.app/izvod}TBroj_racuna"/>
 *         &lt;element name="modelduznik" type="{soap.app/izvod}model"/>
 *         &lt;element name="pnbd" type="{soap.app/izvod}poziv-na-broj"/>
 *         &lt;element name="racunpoverioc" type="{soap.app/izvod}TBroj_racuna"/>
 *         &lt;element name="modelpoverioc" type="{soap.app/izvod}model"/>
 *         &lt;element name="pnbp" type="{soap.app/izvod}poziv-na-broj"/>
 *         &lt;element name="smer">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "stavka-preseka", propOrder = {

})
public class StavkaPreseka {

    @XmlElement(name = "duznik-nalogodavac", required = true)
    protected String duznikNalogodavac;
    @XmlElement(name = "svrha-placanja", required = true)
    protected String svrhaPlacanja;
    @XmlElement(name = "primalac-poverilac", required = true)
    protected String primalacPoverilac;
    @XmlElement(name = "datum-naloga", required = true)
    protected String datumNaloga;
    @XmlElement(required = true)
    protected BigDecimal iznos;
    @XmlElement(name = "datum-valute", required = true)
    protected String datumValute;
    @XmlElement(required = true)
    protected String racunduznik;
    protected int modelduznik;
    protected int pnbd;
    @XmlElement(required = true)
    protected String racunpoverioc;
    protected int modelpoverioc;
    protected int pnbp;
    @XmlElement(required = true)
    protected String smer;

    /**
     * Gets the value of the duznikNalogodavac property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDuznikNalogodavac() {
        return duznikNalogodavac;
    }

    /**
     * Sets the value of the duznikNalogodavac property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDuznikNalogodavac(String value) {
        this.duznikNalogodavac = value;
    }

    /**
     * Gets the value of the svrhaPlacanja property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSvrhaPlacanja() {
        return svrhaPlacanja;
    }

    /**
     * Sets the value of the svrhaPlacanja property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSvrhaPlacanja(String value) {
        this.svrhaPlacanja = value;
    }

    /**
     * Gets the value of the primalacPoverilac property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimalacPoverilac() {
        return primalacPoverilac;
    }

    /**
     * Sets the value of the primalacPoverilac property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimalacPoverilac(String value) {
        this.primalacPoverilac = value;
    }

    /**
     * Gets the value of the datumNaloga property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatumNaloga() {
        return datumNaloga;
    }

    /**
     * Sets the value of the datumNaloga property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatumNaloga(String value) {
        this.datumNaloga = value;
    }

    /**
     * Gets the value of the iznos property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getIznos() {
        return iznos;
    }

    /**
     * Sets the value of the iznos property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setIznos(BigDecimal value) {
        this.iznos = value;
    }

    /**
     * Gets the value of the datumValute property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatumValute() {
        return datumValute;
    }

    /**
     * Sets the value of the datumValute property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatumValute(String value) {
        this.datumValute = value;
    }

    /**
     * Gets the value of the racunduznik property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRacunduznik() {
        return racunduznik;
    }

    /**
     * Sets the value of the racunduznik property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRacunduznik(String value) {
        this.racunduznik = value;
    }

    /**
     * Gets the value of the modelduznik property.
     * 
     */
    public int getModelduznik() {
        return modelduznik;
    }

    /**
     * Sets the value of the modelduznik property.
     * 
     */
    public void setModelduznik(int value) {
        this.modelduznik = value;
    }

    /**
     * Gets the value of the pnbd property.
     * 
     */
    public int getPnbd() {
        return pnbd;
    }

    /**
     * Sets the value of the pnbd property.
     * 
     */
    public void setPnbd(int value) {
        this.pnbd = value;
    }

    /**
     * Gets the value of the racunpoverioc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRacunpoverioc() {
        return racunpoverioc;
    }

    /**
     * Sets the value of the racunpoverioc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRacunpoverioc(String value) {
        this.racunpoverioc = value;
    }

    /**
     * Gets the value of the modelpoverioc property.
     * 
     */
    public int getModelpoverioc() {
        return modelpoverioc;
    }

    /**
     * Sets the value of the modelpoverioc property.
     * 
     */
    public void setModelpoverioc(int value) {
        this.modelpoverioc = value;
    }

    /**
     * Gets the value of the pnbp property.
     * 
     */
    public int getPnbp() {
        return pnbp;
    }

    /**
     * Sets the value of the pnbp property.
     * 
     */
    public void setPnbp(int value) {
        this.pnbp = value;
    }

    /**
     * Gets the value of the smer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSmer() {
        return smer;
    }

    /**
     * Sets the value of the smer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSmer(String value) {
        this.smer = value;
    }

}
