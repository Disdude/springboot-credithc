package com.hc.henghuirong.server.config;

import com.hc.henghuirong.server.service.CxfService;
import com.hc.henghuirong.server.service.impl.CxfServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

import javax.xml.ws.Endpoint;

/**
 * Created by wenzhiwei on 17-3-21.
 */
@Configuration
public class CxfServiceConfig {

    @Autowired
    private SpringBus bus;

    @Bean
    public CxfServiceImpl cxfService() {
        return new CxfServiceImpl();
    }

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, cxfService());
        endpoint.publish("/cxf");
        return endpoint;
    }

}
