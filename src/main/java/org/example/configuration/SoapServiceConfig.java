package org.example.configuration;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.example.service.SoapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.xml.ws.Endpoint;

//http://127.0.0.1:8089/services/soapService

@Configuration
public class SoapServiceConfig {
    @Autowired
    private Bus bus;
    @Autowired
    private SoapService soapService;

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, soapService);
        endpoint.publish("/soapService");
        return endpoint;
    }
    /**
     * 添加普通的controller处理，兼容rest接口用，非必须
     * @return
     */
    /*@Bean
    public ServletRegistrationBean dispatcherRestServlet() {
        AnnotationConfigWebApplicationContext context
                = new AnnotationConfigWebApplicationContext();
        //替换成自己的controller包路径
        context.scan("org.ysp.webservice2020.controller");
        DispatcherServlet disp = new DispatcherServlet(context);
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(disp);
        registrationBean.setLoadOnStartup(1);
        //映射路径自定义,必须设置一个不重复的名称
        registrationBean.addUrlMappings("/rest/*");
        registrationBean.setName("rest");
        return registrationBean;
    }*/

    /*@Bean
    public ServletRegistrationBean dispatcherServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new CXFServlet(), "/soap/*");
        return servletRegistrationBean;
    }*/
}
