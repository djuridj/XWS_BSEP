//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.10 at 09:19:13 PM CEST 
//


package app.soap.zaduzenje_mt900;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;




/**
 * <p>Java class for zaduzenje_mt900 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="zaduzenje_mt900">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="id_poruke">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="50"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="swift_kod_banke_duznika">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="[A-Z]{6}[A-Z0-9]{2}(X{3}|[A-Z0-9]{3})?"/>
 *               &lt;minLength value="8"/>
 *               &lt;maxLength value="11"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="obracunski_racun_banke_duznika">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="[0-9]{3}-[0-9]{13}-[0-9]{2}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="id_poruke_naloga">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="50"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="datum_valute">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="[0-9]{2}-[0-9]{2}-[0-9]{4}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="iznos">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *               &lt;fractionDigits value="2"/>
 *               &lt;totalDigits value="15"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="sifra_valute">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="3"/>
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
@XmlType(name = "zaduzenje_mt900", propOrder = {

})
@Entity
@Table(name="zaduzenje_mt900")
public class ZaduzenjeMt900 {
    @Id
    @Column
    @XmlElement(name = "id_poruke", required = true)
    protected String idPoruke;
    @Column
    @XmlElement(name = "swift_kod_banke_duznika", required = true)
    protected String swiftKodBankeDuznika;
    @Column
    @XmlElement(name = "obracunski_racun_banke_duznika", required = true, defaultValue = "000-0000000000000-00")
    protected String obracunskiRacunBankeDuznika;
    @Column
    @XmlElement(name = "id_poruke_naloga", required = true)
    protected String idPorukeNaloga;
    @Column
    @XmlElement(name = "datum_valute", required = true, defaultValue = "00-00-0000")
    protected String datumValute;
    @Column
    @XmlElement(required = true)
    protected BigDecimal iznos;
    @Column
    @XmlElement(name = "sifra_valute", required = true)
    protected String sifraValute;

    /**
     * Gets the value of the idPoruke property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdPoruke() {
        return idPoruke;
    }

    /**
     * Sets the value of the idPoruke property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdPoruke(String value) {
        this.idPoruke = value;
    }

    /**
     * Gets the value of the swiftKodBankeDuznika property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSwiftKodBankeDuznika() {
        return swiftKodBankeDuznika;
    }

    /**
     * Sets the value of the swiftKodBankeDuznika property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSwiftKodBankeDuznika(String value) {
        this.swiftKodBankeDuznika = value;
    }

    /**
     * Gets the value of the obracunskiRacunBankeDuznika property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObracunskiRacunBankeDuznika() {
        return obracunskiRacunBankeDuznika;
    }

    /**
     * Sets the value of the obracunskiRacunBankeDuznika property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObracunskiRacunBankeDuznika(String value) {
        this.obracunskiRacunBankeDuznika = value;
    }

    /**
     * Gets the value of the idPorukeNaloga property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdPorukeNaloga() {
        return idPorukeNaloga;
    }

    /**
     * Sets the value of the idPorukeNaloga property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdPorukeNaloga(String value) {
        this.idPorukeNaloga = value;
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
     * Gets the value of the sifraValute property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSifraValute() {
        return sifraValute;
    }

    /**
     * Sets the value of the sifraValute property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSifraValute(String value) {
        this.sifraValute = value;
    }

}