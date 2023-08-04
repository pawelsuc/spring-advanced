package com.pawelsuc.controller;

import com.pawelsuc.entity.Item;
import com.pawelsuc.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;

@RestController
public class MainController {

    @Autowired
    ItemService itemService;

    @RequestMapping("/")
    public String index(HttpServletResponse response) {
        response.addHeader("Spring", "jest great!");

        Item item = new Item();

        item.setName("car");
        item.setPrice("10000$");
        itemService.saveItem(item);



        return "Hello world";
    }
}
