package com.itransition.kursach.controller;

import com.itransition.kursach.entity.User;
import com.itransition.kursach.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class RegistrationController {

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(
            User user, Map<String,Object> model
    ) {
        if (!userService.createUser(user)){
            model.put("message","User exist");
            return "registration";
        }
        return "redirect:/login";
    }
}
