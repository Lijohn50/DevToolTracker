package com.example.devtooltracker.service;

import com.example.devtooltracker.dto.ToolDetail;
import com.example.devtooltracker.model.Assignment;
import com.example.devtooltracker.model.Tool;
import com.example.devtooltracker.model.User;
import com.example.devtooltracker.repository.AssignmentRepository;
import com.example.devtooltracker.repository.ToolRepository;
import com.example.devtooltracker.repository.UserListRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToolDetailsService {

    private final ToolRepository toolRepository;
    private final UserListRepository userListRepository;
    private final AssignmentRepository assignmentRepository;

    public ToolDetail getToolDetails(int id){

        Tool tool = toolRepository.findById(id).orElse(null);
        int seatsUsed = tool.getAssignments().size();
        int utilizationPercent = 0;
        if(tool.getSeatsPurchased() != null && tool.getSeatsPurchased() > 0){

            utilizationPercent = seatsUsed * 100 / tool.getSeatsPurchased();
        }
        List<User> assignedDevelopers = tool.getAssignments().stream().map(Assignment::getUser).toList();
        List<User> allUsers = userListRepository.findAllByRole("ROLE_USER");
        List<User> unassignedDevelopers = allUsers.stream().filter(user -> !assignedDevelopers.contains(user)).toList();
        return new ToolDetail(tool.getName()
                ,tool.getVendor()
                ,tool.getId()
                ,tool.getCategory()
                ,tool.getLicenseType()
                ,tool.getCostPerSeat()
                ,tool.getSeatsPurchased()
                ,tool.getRenewalDate()
                ,seatsUsed
                ,utilizationPercent
                ,assignedDevelopers
                ,unassignedDevelopers);
    }
    @Transactional
    public void unassignUser(int toolId, int devId){

        assignmentRepository.deleteByUserIdAndToolId(devId, toolId);
    }
}
