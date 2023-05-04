package com.hcz.buy_detail.service;


import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(name = "webtestService",targetNamespace = "http://service.buy_detail.hcz.com")
public interface WebtestService {


    @WebMethod
    @WebResult(name = "String", targetNamespace = "")
    String webserviceSimple(@WebParam(name = "username",targetNamespace = "http://service.buy_detail.hcz.com") String username,
                          @WebParam(name = "age",targetNamespace = "http://service.buy_detail.hcz.com") Integer age
    );

    @WebMethod
    @WebResult(name = "String", targetNamespace = "")
    String webservice100(@WebParam(name = "username",targetNamespace = "http://service.buy_detail.hcz.com") String username,
                      @WebParam(name = "age",targetNamespace = "http://service.buy_detail.hcz.com") Integer age
    );

    @WebMethod
    @WebResult(name = "String", targetNamespace = "")
    String webservice1000(@WebParam(name = "username",targetNamespace = "http://service.buy_detail.hcz.com") String username,
                         @WebParam(name = "age",targetNamespace = "http://service.buy_detail.hcz.com") Integer age
    );


    @WebMethod
    @WebResult(name = "String", targetNamespace = "")
    String webservice30000(@WebParam(name = "username",targetNamespace = "http://service.buy_detail.hcz.com") String username,
                          @WebParam(name = "age",targetNamespace = "http://service.buy_detail.hcz.com") Integer age
    );


}
