package com.example.devtooltracker;

import com.example.devtooltracker.Model.user.User;
import com.example.devtooltracker.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@SpringBootTest
public class RegistrationService {

    private final LoginRepository loginRepository;

    private final PasswordEncoder passwordEncoder;

    @Test
    public void saveUser(User user) {

        user.setRole("ROLE_USER");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        loginRepository.save(user);
    }

    @Test
    public void saveAdmin(User user) {

        user.setRole("ROLE_ADMIN");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        loginRepository.save(user);
    }

    @Test
    public void findByEmail(String email){

        loginRepository.findByEmail(email);
    }
}
