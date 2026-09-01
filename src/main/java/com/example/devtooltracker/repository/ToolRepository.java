package com.example.devtooltracker.repository;

import com.example.devtooltracker.model.Tool;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ToolRepository extends JpaRepository<Tool, Integer> {

    List<Tool> findByRenewalDateBetween(LocalDate startDate, LocalDate endDate );
}
