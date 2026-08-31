package com.example.devtooltracker;

import com.example.devtooltracker.model.User;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@SpringBootTest
public interface LoginRepository extends JpaRepository<User,  Integer>{
    User findUsersByUsername(String username);

    User findByEmail(String email);
}
