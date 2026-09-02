package com.example.devtooltracker.service.user;

import com.example.devtooltracker.model.Assignment;
import com.example.devtooltracker.model.User;
import com.example.devtooltracker.repository.AssignmentRepository;
import com.example.devtooltracker.repository.UserListRepository;
import com.example.devtooltracker.service.UserListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssignedToolsService {

    private final AssignmentRepository assignmentRepository;
    private final UserListRepository userListRepository;

    public List<Assignment> getAssignedTools(String email) {

        User user = userListRepository.findByEmail(email);
        return assignmentRepository.findAllByUserId(user.getId());
    }
}
