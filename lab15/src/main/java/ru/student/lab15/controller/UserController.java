package ru.student.lab15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.student.lab15.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    private final UserRepository repository;

    @Autowired
    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/login")
    public ModelAndView loginPage() {
        return new ModelAndView("auth");
    }

    @PostMapping(value = "/hello", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView helloPage(HttpServletRequest request, HttpServletResponse response) {
        final var username = request.getParameter("username");
        final var password = request.getParameter("password");
        final var oneByLoginAndPassword = repository.findOneByLoginAndPassword(username, password);
        var modelAndView = new ModelAndView();
        oneByLoginAndPassword.ifPresentOrElse(user -> {
            modelAndView.addObject("name", user.getName());
            modelAndView.addObject("surname", user.getSurname());
            modelAndView.setViewName("hello");
        }, () -> modelAndView.setViewName("redirect:" + "/login"));
        return modelAndView;
    }


}
