package com.pawelsuc.controller;

import com.pawelsuc.entity.User;
import com.pawelsuc.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignUpController {

    private SignUpService signUpService;

    @Autowired
    private SignUpController(SignUpService signUpService) {
        this.signUpService = signUpService;
    }


    @GetMapping("/api/test")
    public String apiTest() {
        return "Hello from apiTest";
    }

    @PostMapping("/api/sign_up")
    public String signUp(String username, String password) {
        User userToSignUp = new User(username, password);
        signUpService.signUpUser(userToSignUp);

        return "User signed up";
    }
}
