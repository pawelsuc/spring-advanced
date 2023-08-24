package com.pawelsuc.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerServiceThree implements ApplicationListener<UserPanelEnterEvent> {
    @Override
    public void onApplicationEvent(UserPanelEnterEvent event) {
        System.out.println("ListenerServiceThree received event, username: " + event.getUsername());
    }
}
