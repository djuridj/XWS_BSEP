//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.27 at 11:53:47 PM CEST 
//


package app.soap.izvod;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the app.soap.izvod package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: app.soap.izvod
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetIzvodResponse }
     * 
     */
    public GetIzvodResponse createGetIzvodResponse() {
        return new GetIzvodResponse();
    }

    /**
     * Create an instance of {@link Izvod }
     * 
     */
    public Izvod createIzvod() {
        return new Izvod();
    }

    /**
     * Create an instance of {@link GetIzvodRequest }
     * 
     */
    public GetIzvodRequest createGetIzvodRequest() {
        return new GetIzvodRequest();
    }

    /**
     * Create an instance of {@link CreateIzvodRequest }
     * 
     */
    public CreateIzvodRequest createCreateIzvodRequest() {
        return new CreateIzvodRequest();
    }

    /**
     * Create an instance of {@link ZahtevZaIzvod }
     * 
     */
    public ZahtevZaIzvod createZahtevZaIzvod() {
        return new ZahtevZaIzvod();
    }

    /**
     * Create an instance of {@link Presek }
     * 
     */
    public Presek createPresek() {
        return new Presek();
    }

    /**
     * Create an instance of {@link Zaglavlje }
     * 
     */
    public Zaglavlje createZaglavlje() {
        return new Zaglavlje();
    }

    /**
     * Create an instance of {@link StavkaPreseka }
     * 
     */
    public StavkaPreseka createStavkaPreseka() {
        return new StavkaPreseka();
    }

}
