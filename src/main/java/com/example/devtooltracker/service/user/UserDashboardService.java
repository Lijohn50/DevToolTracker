package com.example.devtooltracker.service.user;

import com.example.devtooltracker.model.User;
import com.example.devtooltracker.repository.AssignmentRepository;
import com.example.devtooltracker.repository.UserListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class UserDashboardService {

    private final UserListRepository userRepository;
    private final AssignmentRepository assignmentRepository;

    public long getMyToolsCount(String email) {

        User user = userRepository.findByEmail(email);
        return assignmentRepository.countByUserId(user.getId());
    }

    public LocalDate getNextRenewal(String email) {

        User user = userRepository.findByEmail(email);

        return assignmentRepository.findAllByUserId(user.getId())
                .stream()
                .map(assignment -> assignment.getTool().getRenewalDate())
                .min(LocalDate::compareTo)
                .orElse(null);
    }
}
