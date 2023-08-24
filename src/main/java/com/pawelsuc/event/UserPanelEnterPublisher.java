package com.pawelsuc.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class UserPanelEnterPublisher {

    private ApplicationEventPublisher publisher;

    public UserPanelEnterPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void publish(String username) {
        UserPanelEnterEvent event = new UserPanelEnterEvent(this, username);
        publisher.publishEvent(event);
    }


}
