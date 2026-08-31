package com.example.devtooltracker.repository;

import com.example.devtooltracker.model.Tool;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToolRepository extends JpaRepository<Tool, Integer> {
}
