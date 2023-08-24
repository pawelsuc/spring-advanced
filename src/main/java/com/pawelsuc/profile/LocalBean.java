package com.pawelsuc.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("local")
public class LocalBean implements ProfileBean {

    @Override
    public String showMessage() {
        return "LocalBean autowired";
    }
}
