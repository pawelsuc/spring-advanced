package com.pawelsuc.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("local")
public class TestController {

    @RequestMapping("/test")
    public String test() {
        return "Some test data";
    }
}
