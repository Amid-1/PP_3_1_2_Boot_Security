package ru.kata.spring.boot_security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.dto.UserDto;
import ru.kata.spring.boot_security.demo.service.UserService;
import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("userDtos", userService.getAllUsers());
        model.addAttribute("userDto", new UserDto());
        return "users";
    }
    @PostMapping("/save")
    public String saveUser(@ModelAttribute("userDto") @Valid UserDto userDto,
                           BindingResult result,
                           Model model) {
        if (result.hasErrors()) {
            model.addAttribute("userDtos", userService.getAllUsers());
            return "users";
        }

        userService.saveUser(userDto);
        return "redirect:/users";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("userDto") @Valid UserDto userDto,
                             BindingResult result,
                             Model model) {
        if (result.hasErrors()) {
            model.addAttribute("userDtos", userService.getAllUsers());
            return "users";
        }
        userService.saveUser(userDto);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String deleteUser(@ModelAttribute("userDto") UserDto userDto, Model model) {
        Long id = userDto.getId();
        if (id == null) {
            model.addAttribute("error", "Ошибка: ID пользователя не передан.");
            return "users";
        }
        try {
            userService.deleteUser(id);
        } catch (Exception e) {
            model.addAttribute("error", "Не удалось удалить пользователя: " + e.getMessage());
            return "users";
        }
        return "redirect:/users";
    }
}
