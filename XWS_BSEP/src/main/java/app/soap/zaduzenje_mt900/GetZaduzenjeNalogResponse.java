//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.13 at 09:51:16 PM CEST 
//


package app.soap.zaduzenje_mt900;

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
 *         &lt;element name="zaduzenje_mt900" type="{soap.app/zaduzenje_mt900}zaduzenje_mt900"/>
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
    "zaduzenjeMt900"
})
@XmlRootElement(name = "getZaduzenjeNalogResponse")
public class GetZaduzenjeNalogResponse {

    @XmlElement(name = "zaduzenje_mt900", required = true)
    protected ZaduzenjeMt900 zaduzenjeMt900;

    /**
     * Gets the value of the zaduzenjeMt900 property.
     * 
     * @return
     *     possible object is
     *     {@link ZaduzenjeMt900 }
     *     
     */
    public ZaduzenjeMt900 getZaduzenjeMt900() {
        return zaduzenjeMt900;
    }

    /**
     * Sets the value of the zaduzenjeMt900 property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZaduzenjeMt900 }
     *     
     */
    public void setZaduzenjeMt900(ZaduzenjeMt900 value) {
        this.zaduzenjeMt900 = value;
    }

}
