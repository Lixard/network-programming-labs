package ru.student.lab16;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
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
