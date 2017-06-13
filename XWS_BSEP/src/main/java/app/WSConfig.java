package app;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
@ComponentScan(basePackages = "soap.app")
public class WSConfig {
    
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, "/wsdl/*");
	}
   
	@Bean(value = "NalogZaPlacanje")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema countriesSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("NaloziPort");
		wsdl11Definition.setLocationUri("/wsdl");
		wsdl11Definition.setTargetNamespace("app.soap/nalog_za_placanje");
		wsdl11Definition.setSchema(naloziSchema());
		return wsdl11Definition;
	}
	
	
	@Bean(value = "RtgsMt103")
	public DefaultWsdl11Definition defaultWsdl11Definition1(XsdSchema countriesSchema) {
		DefaultWsdl11Definition wsdl11Definition1 = new DefaultWsdl11Definition();
		wsdl11Definition1.setPortTypeName("RtgsNaloziPort");
		wsdl11Definition1.setLocationUri("/wsdl");
		wsdl11Definition1.setTargetNamespace("app.soap/rtgs_mt103");
		wsdl11Definition1.setSchema(RtgsMt103naloziSchema());
		return wsdl11Definition1;
	}
	
	
	@Bean(value = "ZaduzenjeMt900")
	public DefaultWsdl11Definition defaultWsdl11Definition2(XsdSchema countriesSchema) {
		DefaultWsdl11Definition wsdl11Definition2 = new DefaultWsdl11Definition();
		wsdl11Definition2.setPortTypeName("ZaduzenjeNaloziPort");
		wsdl11Definition2.setLocationUri("/wsdl");
		wsdl11Definition2.setTargetNamespace("app.soap/zaduzenje_mt900");
		wsdl11Definition2.setSchema(ZaduzenjeMt900naloziSchema());
		return wsdl11Definition2;
	}
	@Bean(value = "OdobrenjeMt910")
	public DefaultWsdl11Definition defaultWsdl11Definition3(XsdSchema countriesSchema) {
		DefaultWsdl11Definition wsdl11Definition3 = new DefaultWsdl11Definition();
		wsdl11Definition3.setPortTypeName("OdobrenjeNaloziPort");
		wsdl11Definition3.setLocationUri("/wsdl");
		wsdl11Definition3.setTargetNamespace("app.soap/odobrenje_mt910");
		wsdl11Definition3.setSchema(OdobrenjeMt910naloziSchema());
		return wsdl11Definition3;
	}
	@Primary
	@Bean
	public XsdSchema naloziSchema() {
		return new SimpleXsdSchema(new ClassPathResource("/seme/NalogZaPlacanje.xsd"));
	}
	
		
	@Bean
	public XsdSchema RtgsMt103naloziSchema() {
		return new SimpleXsdSchema(new ClassPathResource("/seme/rtgs_mt103.xsd"));
	}
	
	
	@Bean
	public XsdSchema ZaduzenjeMt900naloziSchema() {
		return new SimpleXsdSchema(new ClassPathResource("/seme/zaduzenje_mt900.xsd"));
	
	}
	@Bean
	public XsdSchema OdobrenjeMt910naloziSchema() {
		return new SimpleXsdSchema(new ClassPathResource("/seme/odobrenje_mt910.xsd"));
	
	}
	  @Bean
	  public EmbeddedServletContainerFactory servletContainer() {
	    TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory() {
	        @Override
	        protected void postProcessContext(Context context) {
	          SecurityConstraint securityConstraint = new SecurityConstraint();
	          securityConstraint.setUserConstraint("CONFIDENTIAL");
	          SecurityCollection collection = new SecurityCollection();
	          collection.addPattern("/*");
	          securityConstraint.addCollection(collection);
	          context.addConstraint(securityConstraint);
	        }
	      };
	    
	    tomcat.addAdditionalTomcatConnectors(initiateHttpConnector());
	    return tomcat;
	  }
	  
	  private Connector initiateHttpConnector() {
	    Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
	    connector.setScheme("http");
	    connector.setPort(8080);
	    connector.setSecure(false);
	    connector.setRedirectPort(8443);
	    
	    return connector;
	  }
	  
}
