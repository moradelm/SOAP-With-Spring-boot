package org.example.webservicesoapwithspringboot.config;


import lombok.AllArgsConstructor;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.example.webservicesoapwithspringboot.ws.CompteSoapService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class CxfConfig {

    private CompteSoapService compteSoapService;
    private Bus bus;

    @Bean
    public EndpointImpl endpoint() {
        EndpointImpl endpoint= new EndpointImpl(bus,compteSoapService);
        endpoint.publish("/ws");
        return endpoint;

    }


}
