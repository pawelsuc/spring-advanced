package com.pawelsuc.controller;

import com.pawelsuc.entity.User;
import com.pawelsuc.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignUpController {

    private SignUpService signUpService;

    @Autowired
    private SignUpController(SignUpService signUpService) {
        this.signUpService = signUpService;
    }

    @GetMapping(value = "/sign_up")
    public ModelAndView signUp(ModelAndView mav) {
        mav.setViewName("sign_up");
        return mav;
    }

    @PostMapping(value = "/sign_up")
    public ModelAndView signUpPost(ModelAndView mav, @RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("email") String email) {
        mav.setViewName("redirect:/login");
        User user = User.of(username, password, email);
        signUpService.signUpUser(user);
        return mav;
    }
}
