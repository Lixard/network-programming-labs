package ru.student.lab16.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface MathService {

    @WebMethod
    double add(double one, double two);

    @WebMethod
    double subtract(double one, double two);

    @WebMethod
    double multiply(double one, double two);

    @WebMethod
    double divide(double one, double two);
}
