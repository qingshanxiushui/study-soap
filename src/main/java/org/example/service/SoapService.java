package org.example.service;

import org.example.model.Student;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface SoapService {
    @WebMethod
    public Student getUserByName(@WebParam(name = "name") String name);
}
