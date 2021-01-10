package ru.student.lab15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.student.lab15.entity.Log;
import ru.student.lab15.entity.User;
import ru.student.lab15.repository.LogRepository;
import ru.student.lab15.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@Controller
public class UserController {

    private final UserRepository userRepository;
    private final LogRepository logRepository;

    @Autowired
    public UserController(UserRepository userRepository, LogRepository logRepository) {
        this.userRepository = userRepository;
        this.logRepository = logRepository;
    }

    @GetMapping(value = "/login")
    public ModelAndView loginPage() {
        return new ModelAndView("auth");
    }

    @PostMapping(value = "/hello", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView helloPage(HttpServletRequest request) {
        final var username = request.getParameter("username");
        final var password = request.getParameter("password");
        final var oneByLoginAndPassword = userRepository.findOneByLoginAndPassword(username, password);
        var modelAndView = new ModelAndView();
        oneByLoginAndPassword.ifPresentOrElse(user -> {
            modelAndView.addObject("name", user.getName());
            modelAndView.addObject("surname", user.getSurname());
            modelAndView.setViewName("hello");
            logRepository.save(createLog(user, request.getRemoteAddr()));
        }, () -> modelAndView.setViewName("redirect:" + "/login"));
        return modelAndView;
    }

    private Log createLog(User user, String ipAddress) {
        final var log = new Log();
        log.setUser(user);
        log.setIpAddress(ipAddress);
        log.setDate(Instant.now());
        return log;
    }

}
