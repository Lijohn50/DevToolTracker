package com.example.devtooltracker.repository;

import com.example.devtooltracker.Model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserListRepository extends JpaRepository<User, Integer> {

    List<User> findAllByRole(String role);
}
