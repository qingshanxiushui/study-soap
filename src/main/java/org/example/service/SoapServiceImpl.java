package org.example.service;

import org.example.model.Student;
import org.springframework.stereotype.Component;

import javax.jws.WebService;

@Component
@WebService(serviceName = "soapService"
                ,name="SoapService" //porType名称 客户端生成代码时为接口名称
                ,targetNamespace = "http://service.example.org"//wsdl命名空间
                ,endpointInterface = "org.example.service.SoapService")
public class SoapServiceImpl implements SoapService{
    @Override
    public Student getUserByName(String name) {
        return new Student(1,name,18);
    }
}


