package com.example.devtooltracker.repository;

import com.example.devtooltracker.Model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<User,  Integer>{
    User findUsersByUsername(String username);

    User findByEmail(String email);
}
