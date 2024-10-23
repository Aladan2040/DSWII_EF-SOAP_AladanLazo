package com.cibertec.DSWII_EF_SOAP_AladanLazo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
public class ClienteWsdlConfig {

    @Bean(name = "clientes")
    public DefaultWsdl11Definition clienteWsdl11Definition(XsdSchema clienteEsquema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("ClientesPort");
        wsdl11Definition.setLocationUri("/ws/clientes");
        wsdl11Definition.setTargetNamespace("http://www.cibertec.com/ws/objects");
        wsdl11Definition.setSchema(clienteEsquema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema clienteEsquema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/schema.xsd"));
    }
}
