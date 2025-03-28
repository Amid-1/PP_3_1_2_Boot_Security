package ru.kata.spring.boot_security.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repositories.UserRepository;

@Controller
public class PersonalController {

    private final UserRepository userRepository;

    public PersonalController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/user")
    public String userHome(Authentication authentication, Model model) {
        String email = authentication.getName(); // т.к. email используется как login
        User user = userRepository.findByEmail(email).orElse(null);
        model.addAttribute("user", user);
        return "user";
    }
}

