package com.pawelsuc.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerServiceTwo implements ApplicationListener<UserPanelEnterEvent> {
    @Override
    public void onApplicationEvent(UserPanelEnterEvent event) {
        System.out.println("ListenerServiceTwo received event, username: " + event.getUsername());
    }
}
