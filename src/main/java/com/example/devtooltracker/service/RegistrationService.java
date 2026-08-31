package com.example.devtooltracker.service;

import com.example.devtooltracker.model.User;
import com.example.devtooltracker.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final LoginRepository loginRepository;

    private final PasswordEncoder passwordEncoder;

    public void saveUser(User user) {

        user.setRole("ROLE_USER");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        loginRepository.save(user);
    }

    public void saveAdmin(User user) {

        user.setRole("ROLE_ADMIN");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        loginRepository.save(user);
    }
    public User findByEmail(String email){

        return loginRepository.findByEmail(email);
    }
}
