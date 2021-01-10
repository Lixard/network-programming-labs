package ru.student.lab16;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
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
