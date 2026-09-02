package com.example.devtooltracker.service;

import com.example.devtooltracker.model.Assignment;
import com.example.devtooltracker.model.Tool;
import com.example.devtooltracker.model.User;
import com.example.devtooltracker.repository.AssignmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;
    private final UserListService userListService;
    private final ToolService toolService;

    public void addAssignment(int toolId, int userId){

        Assignment assignment = new Assignment();
        assignment.setTool(toolService.findById(toolId));
        assignment.setUser(userListService.findById(userId));
        assignment.setStartDate(LocalDate.now());
        assignmentRepository.save(assignment);
    }
    public List<Assignment> findByUser(int id){

        return assignmentRepository.findAllByUserId(id);
    }
    public void unassignTool(int id){

        assignmentRepository.deleteById(id);
    }
}
