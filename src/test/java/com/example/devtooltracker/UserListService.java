package com.example.devtooltracker;

import com.example.devtooltracker.repository.UserListRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@SpringBootTest
public class UserListService {

    private final UserListRepository userListRepository;

    @Test
    public void findAll() {

        userListRepository.findAllByRole("ROLE_USER");
    }
}
