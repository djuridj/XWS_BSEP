//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.10 at 09:19:13 PM CEST 
//


package app.soap.odobrenje_mt910;

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
 *         &lt;element name="odobrenje_mt910" type="{soap.app/odobrenje_mt910}odobrenje_mt910"/>
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
    "odobrenjeMt910"
})
@XmlRootElement(name = "getOdobrenjeNalogResponse")
public class GetOdobrenjeNalogResponse {

    @XmlElement(name = "odobrenje_mt910", required = true)
    protected OdobrenjeMt910 odobrenjeMt910;

    /**
     * Gets the value of the odobrenjeMt910 property.
     * 
     * @return
     *     possible object is
     *     {@link OdobrenjeMt910 }
     *     
     */
    public OdobrenjeMt910 getOdobrenjeMt910() {
        return odobrenjeMt910;
    }

    /**
     * Sets the value of the odobrenjeMt910 property.
     * 
     * @param value
     *     allowed object is
     *     {@link OdobrenjeMt910 }
     *     
     */
    public void setOdobrenjeMt910(OdobrenjeMt910 value) {
        this.odobrenjeMt910 = value;
    }

}
