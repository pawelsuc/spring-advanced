package com.pawelsuc.controller;

import com.pawelsuc.component.mailer.SignUpMailer;
import com.pawelsuc.entity.Item;
import com.pawelsuc.entity.User;
import com.pawelsuc.repository.UserRepository;
import com.pawelsuc.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
public class MainController {

    private static final int PAGE_SIZE = 3;
    @Autowired
    ItemService itemService;

    @Autowired
    private SignUpMailer mailer;

    @Autowired
    UserRepository userRepository;

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
        return result;
    }

    @RequestMapping("/items")
    public List<Item> items(@RequestParam(defaultValue = "0") String page) {
        int currentPage = Integer.parseInt(page);
        PageRequest pageRequest = PageRequest.of(currentPage, PAGE_SIZE);

        Page<Item> items = itemService.findAll(pageRequest);

        return items.getContent();

    }

    @RequestMapping("/send_mail")
    public String sendMail() {
        mailer.sendMessage("pablosuc94test@gmail.com", "Test14082023", "Test14082023 - content of message");
        return "mail sent";
    }
    @RequestMapping("confirm_email")
    public String confirmEmail(@RequestParam(name="token") String token) {
        Optional<User> optionalUser = userRepository.findByConfirmationToken(token);

        if(optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setEnabled(true);
            userRepository.save(user);
            return "Your account has been activated";
        } else {
            return "Given token does not exist";
        }

    }
}
