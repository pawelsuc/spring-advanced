package com.pawelsuc.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerServiceOne implements ApplicationListener<UserPanelEnterEvent> {
    @Override
    public void onApplicationEvent(UserPanelEnterEvent event) {
        System.out.println("ListenerServiceOne received event, username: " + event.getUsername());
    }
}
