//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.14 at 11:46:05 PM CEST 
//


package app.soap.clearing_mt102;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="clearing_mt102" type="{soap.app/clearing_mt102}clearing_mt102"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "clearingMt102"
})
@XmlRootElement(name = "getClearingNalogResponse")
public class GetClearingNalogResponse {

    @XmlElement(name = "clearing_mt102", required = true)
    protected ClearingMt102 clearingMt102;

    /**
     * Gets the value of the clearingMt102 property.
     * 
     * @return
     *     possible object is
     *     {@link ClearingMt102 }
     *     
     */
    public ClearingMt102 getClearingMt102() {
        return clearingMt102;
    }

    /**
     * Sets the value of the clearingMt102 property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClearingMt102 }
     *     
     */
    public void setClearingMt102(ClearingMt102 value) {
        this.clearingMt102 = value;
    }

}
