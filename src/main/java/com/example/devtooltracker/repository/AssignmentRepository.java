package com.example.devtooltracker.repository;

import com.example.devtooltracker.model.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssignmentRepository extends JpaRepository<Assignment, Integer> {

    List<Assignment> findAllByUserId(int userId);
    List<Assignment> findByToolId(int toolId);
    long countByUserId(int userId);
}
