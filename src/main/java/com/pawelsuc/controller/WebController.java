package com.pawelsuc.controller;

import com.pawelsuc.entity.User;
import com.pawelsuc.event.UserPanelEnterEvent;
import com.pawelsuc.event.UserPanelEnterPublisher;
import com.pawelsuc.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {

    private UserPanelEnterPublisher publisher;

    @Autowired
    public WebController(UserPanelEnterPublisher publisher) {
        this.publisher = publisher;
    }


    @RequestMapping(value = "/user_panel", method = RequestMethod.GET)
    public ModelAndView userPanel(ModelAndView mav) {
        mav.setViewName("user_panel");

        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        publisher.publish(principal.getUsername());

        return mav;
    }

    @RequestMapping(value = "/admin_panel", method = RequestMethod.GET)
    public ModelAndView adminPanel(ModelAndView mav) {
        mav.setViewName("admin_panel");

        return mav;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(ModelAndView mav) {
        mav.setViewName("login");

        return mav;
    }
}
