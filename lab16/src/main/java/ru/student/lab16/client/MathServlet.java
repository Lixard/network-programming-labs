package ru.student.lab16.client;

import ru.student.lab16.webservice.MathService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet
public class MathServlet extends HttpServlet {

    private static final String PAGE_START = "<html>\n"
            + "<form action=\"math\" method=\"post\">\n"
            + "    <input type=\"text\" name=\"one\">\n"
            + "    <select name=\"operation\">\n"
            + "        <option value=\"+\">+</option>\n"
            + "        <option value=\"-\">-</option>\n"
            + "        <option value=\"*\">*</option>\n"
            + "        <option value=\"/\">/</option>\n"
            + "    </select>\n"
            + "    <input type=\"text\" name=\"two\">\n"
            + "    <button type=\"submit\">=</button>";
    private static final String PAGE_END = "</form>\n"
            + "</html>\n";
    private final MathService mathService;

    public MathServlet(MathService mathService) {
        this.mathService = mathService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(PAGE_START + PAGE_END);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final var one = Double.valueOf(req.getParameter("one"));
        final var two = Double.valueOf(req.getParameter("two"));
        switch (req.getParameter("operation")) {
            case "+":
                final var add = mathService.add(one, two);
                resp.getWriter().println(pageWithTotal(add));
                break;
            case "/":
                final var divide = mathService.divide(one, two);
                resp.getWriter().println(pageWithTotal(divide));
                break;
            case "*":
                final var multiply = mathService.multiply(one, two);
                resp.getWriter().println(pageWithTotal(multiply));
                break;
            case "-":
                final var subtract = mathService.subtract(one, two);
                resp.getWriter().println(pageWithTotal(subtract));
                break;
        }
    }

    private String pageWithTotal(Double total) {
        return PAGE_START + " " + total + "\n" + PAGE_END;
    }
}
