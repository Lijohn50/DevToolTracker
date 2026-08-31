package com.example.devtooltracker;

import com.example.devtooltracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserListRepository extends JpaRepository<User, Integer> {

    List<User> findAllByRole(String role);
}
