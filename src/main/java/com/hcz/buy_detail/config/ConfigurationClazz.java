package com.hcz.buy_detail.config;

import com.hcz.buy_detail.service.WebtestService;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class ConfigurationClazz {

//    @Autowired
//    Bus bus;

    @Autowired
    private WebtestService webtestService;


    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus(){
        return new SpringBus();
    }

    // 配置路径后缀，发布服务
    @Bean
    public Endpoint endpoint(){
        EndpointImpl endpointImpl = new EndpointImpl(springBus(),webtestService);
        // 配置路径后缀
        endpointImpl.publish("/iwebservice");
        return endpointImpl;
    }

}
