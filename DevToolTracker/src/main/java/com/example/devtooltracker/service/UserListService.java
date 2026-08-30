package com.example.devtooltracker.service;

import com.example.devtooltracker.Model.user.User;
import com.example.devtooltracker.repository.UserListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserListService {

    private final UserListRepository userListRepository;

    public List<User> findAll() {
        return userListRepository.findAllByRole("ROLE_USER");
    }

    public User findById(int id){

        return userListRepository.findById(id).orElse(null);
    }
}
