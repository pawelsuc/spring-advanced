package com.pawelsuc.event;

import org.springframework.context.ApplicationEvent;

public class UserPanelEnterEvent extends ApplicationEvent {

    private String username;

    public UserPanelEnterEvent(Object source, String username) {
        super(source);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
