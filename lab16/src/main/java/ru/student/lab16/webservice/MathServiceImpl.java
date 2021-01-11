package ru.student.lab16.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "ru.student.lab16.webservice.MathService")
public class MathServiceImpl implements MathService {

    @WebMethod
    @Override
    public double add(double one, double two) {
        return one + two;
    }

    @WebMethod
    @Override
    public double subtract(double one, double two) {
        return one - two;
    }

    @WebMethod
    @Override
    public double multiply(double one, double two) {
        return one * two;
    }

    @WebMethod
    @Override
    public double divide(double one, double two) {
        return one / two;
    }
}
