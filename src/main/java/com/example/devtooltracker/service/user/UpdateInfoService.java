package com.example.devtooltracker.service.user;

import com.example.devtooltracker.dto.UserPassUpdate;
import com.example.devtooltracker.model.User;
import com.example.devtooltracker.repository.user.UpdateInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateInfoService {

    private final UpdateInfoRepository updateInfoRepository;
    private final PasswordEncoder passwordEncoder;

    public void updateInfo(User user) {

        updateInfoRepository.save(user);
    }
    public User getUser(String email){

        return updateInfoRepository.findByEmail(email);
    }
    public void updatePassword(String email, UserPassUpdate password){

        User user = updateInfoRepository.findByEmail(email);
        if(user != null && password.currentPassword() != null && password.newPassword() != null && passwordEncoder.matches(password.currentPassword(), user.getPassword())){

            user.setPassword(passwordEncoder.encode(password.newPassword()));
            updateInfoRepository.save(user);
        }else {
            throw new RuntimeException("Invalid password");
        }
    }
}
