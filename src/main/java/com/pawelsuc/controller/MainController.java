package com.pawelsuc.controller;

import com.pawelsuc.entity.Item;
import com.pawelsuc.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class MainController {

    @Autowired
    ItemService itemService;

    @RequestMapping("/")
    public List<Item> index(HttpServletResponse response) {

        return itemService.getItemsWithQuantityOverTwenty();
    }
}
