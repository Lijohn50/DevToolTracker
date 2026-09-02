package com.example.devtooltracker.repository.user;

import com.example.devtooltracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpdateInfoRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
