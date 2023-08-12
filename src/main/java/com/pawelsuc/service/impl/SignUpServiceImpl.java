package com.pawelsuc.service.impl;

import com.pawelsuc.entity.User;
import com.pawelsuc.repository.UserRepository;
import com.pawelsuc.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class SignUpServiceImpl implements SignUpService {
    private UserRepository userRepository;

    @Autowired
    public SignUpServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User signUpUser(User user) {
        Assert.isNull(user.getIdUser(), "Can't sign up given user, it already has set id. User: " + user.toString());
        User savedUser = userRepository.save(user);
        return savedUser;
    }
}
