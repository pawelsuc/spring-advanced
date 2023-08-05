package com.pawelsuc.controller;

import com.pawelsuc.entity.Item;
import com.pawelsuc.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
public class MainController {

    @Autowired
    ItemService itemService;

    @RequestMapping("/")
    public List<Item> index(HttpServletResponse response) {

        return itemService.findByQuantityGreaterThanEqualOrderByQuantityDesc(250);
    }

    @RequestMapping("/quantity_threshold")
    public List<Item> quantityThreshold(@RequestParam(name = "quantity") Optional<Integer> quantityParam) {
        int quantity = 50;

        if (quantityParam.isPresent()) {
            quantity = quantityParam.get();
        }

        return itemService.getItemsWithQuantityOver(50);
    }

    @RequestMapping("/find_by_name")
    public List<Item> findByName() {
        String regexName = "s%";
        List<Item> result = itemService.getItemsWithNameLike(regexName);
        return  result;
    }
}
