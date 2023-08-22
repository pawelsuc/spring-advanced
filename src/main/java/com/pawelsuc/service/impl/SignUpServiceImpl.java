package com.pawelsuc.service.impl;

import com.pawelsuc.component.mailer.RandomStringFactory;
import com.pawelsuc.component.mailer.SignUpMailer;
import com.pawelsuc.entity.User;
import com.pawelsuc.repository.UserRepository;
import com.pawelsuc.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class SignUpServiceImpl implements SignUpService {
    private static final int TOKEN_LENGTH = 15;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private SignUpMailer mailer;

    @Autowired
    public SignUpServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, SignUpMailer mailer) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.mailer = mailer;
    }

    @Override
    public User signUpUser(User user) {
        Assert.isNull(user.getIdUser(), "Can't sign up given user, it already has set id. User: " + user.toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        String token = RandomStringFactory.getRandomString(TOKEN_LENGTH);
        user.setConfirmationToken(token);
        mailer.sendConfirmationLink(user.getEmail(), token);
        User savedUser = userRepository.save(user);

        return savedUser;
    }
}
