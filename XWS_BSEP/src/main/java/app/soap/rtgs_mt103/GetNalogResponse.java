//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.14 at 11:46:05 PM CEST 
//


package app.soap.rtgs_mt103;

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
 *         &lt;element name="rtgs_mt103" type="{soap.app/rtgs_mt103}rtgs_mt103"/>
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
    "rtgsMt103"
})
@XmlRootElement(name = "getNalogResponse")
public class GetNalogResponse {

    @XmlElement(name = "rtgs_mt103", required = true)
    protected RtgsMt103 rtgsMt103;

    /**
     * Gets the value of the rtgsMt103 property.
     * 
     * @return
     *     possible object is
     *     {@link RtgsMt103 }
     *     
     */
    public RtgsMt103 getRtgsMt103() {
        return rtgsMt103;
    }

    /**
     * Sets the value of the rtgsMt103 property.
     * 
     * @param value
     *     allowed object is
     *     {@link RtgsMt103 }
     *     
     */
    public void setRtgsMt103(RtgsMt103 value) {
        this.rtgsMt103 = value;
    }

}
