package ru.student.lab14.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import ru.student.lab14.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    private final UserRepository repository;

    @Autowired
    public HelloServlet(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final var username = req.getParameter("username");
        final var password = req.getParameter("password");
        final var optionalUser = repository.findOneByLoginAndPassword(username, password);
        optionalUser.ifPresentOrElse(u -> {
            resp.setStatus(200);
            try {
                resp.getWriter().println("<html><h2> Welcome " + u.getName() + " " + u.getSurname() + " </h2></html>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }, () -> {
            try {
                resp.setStatus(403);
                resp.sendRedirect("/login");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
