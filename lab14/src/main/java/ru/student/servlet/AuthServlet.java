package ru.student.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class AuthServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>\n"
                + "<meta charset=\"UTF-8\">\n"
                + "<title>Login Page</title>\n"
                + "</head>\n"
                + "<body>\n"
                + "  <form action=\"hello\" method=\"post\">\n"
                + "    <table>\n"
                + "      <tr>\n"
                + "        <td>Name:</td>\n"
                + "        <td><input type=\"text\" name=\"username\" /></td>\n"
                + "      <tr>\n"
                + "        <td>Password:</td>\n"
                + "        <td><input type=\"password\" name=\"password\" /></td>\n"
                + "      <tr>\n"
                + "        <td></td>\n"
                + "        <td><input type=\"submit\" value=\"login\" /></td>\n"
                + "      </tr>\n"
                + "    </table>\n"
                + "  </form>\n"
                + "</body>\n"
                + "</html>");
        resp.setStatus(200);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
