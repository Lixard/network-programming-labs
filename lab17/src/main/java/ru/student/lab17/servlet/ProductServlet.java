package ru.student.lab17.servlet;

import ru.student.lab17.entity.Product;
import ru.student.lab17.repository.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet
public class ProductServlet extends HttpServlet {

    private static final String PAGE_START = "<html>"
            + "<head>\n"
            + "    <style type=\"text/css\">\n"
            + "        table, th, td {\n"
            + "            border: 1px solid black;\n"
            + "            border-collapse: collapse;\n"
            + "        }\n"
            + "    </style>\n"
            + "</head>\n"
            + "<body>"
            + "    <form action=\"basket\" method=\"post\">\n"
            + "        <span>Product ID (for deleting)</span>\n"
            + "        <input type=\"text\" name=\"id\">\n"
            + "        <br>"
            + "        <span>Product name</span>\n"
            + "        <input type=\"text\" name=\"name\">\n"
            + "        <br>";
    private static final String PAGE_END = "<button type=\"submit\" name=\"button\" value=\"add\">Add</button>\n"
            + "        <br>\n"
            + "        <button type=\"submit\" name=\"button\" value=\"remove\">Remove</button>\n"
            + "    </form>\n"
            + "</body>\n"
            + "</html>";

    private final ProductRepository productRepository;

    public ProductServlet(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(PAGE_START);
        resp.getWriter().println(formProductTable(productRepository.findAll()));
        resp.getWriter().println(PAGE_END);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        switch (req.getParameter("button")) {
            case "add":
                final var name = req.getParameter("name");
                final var product = new Product();
                product.setName(name);
                productRepository.save(product);
                break;
            case "remove":
                final var id = req.getParameter("id");
                productRepository.deleteById(Integer.valueOf(id));
                break;
        }
        resp.sendRedirect("/basket");
    }

    private String formProductTable(List<Product> products) {
        final var html = new StringBuilder();
        html.append("<br>");
        html.append("<table>");
        html.append("<tr><th>ID</th><th>Name</th></tr>");
        for (final var product : products) {
            html.append("<tr><td>")
                    .append(product.getId())
                    .append("</td><td>")
                    .append(product.getName())
                    .append("</td></tr>");
        }
        html.append("</table><br>");
        return html.toString();
    }
}
