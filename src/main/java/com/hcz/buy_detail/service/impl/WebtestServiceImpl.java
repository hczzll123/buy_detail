package com.hcz.buy_detail.service.impl;

import com.hcz.buy_detail.service.WebtestService;
import org.springframework.stereotype.Component;

import javax.jws.WebService;

@WebService(serviceName = "WebtestService",//对外发布服务名
        targetNamespace = "http://service.buy_detail.hcz.com",//包报名倒叙，并且和接口定义保持一致
        endpointInterface = "com.hcz.buy_detail.service.WebtestService"///接口权限定名,指定做SEI（Service EndPoint Interface）服务端点接口
)
@Component
public class WebtestServiceImpl implements WebtestService {


    @Override
    public String webserviceSimple(String body) {
        return "Simple";
    }

    @Override
    public String webservice100(String body) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "100";
    }

    @Override
    public String webservice1000(String body) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "1000";
    }

    @Override
    public String webservice30000(String body) {
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "30000";
    }
}
