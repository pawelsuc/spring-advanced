package com.pawelsuc.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class DevBean implements ProfileBean{
    @Override
    public String showMessage() {
        return "DevBean autowired";
    }
}
