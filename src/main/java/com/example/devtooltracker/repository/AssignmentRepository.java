package com.example.devtooltracker.repository;

import com.example.devtooltracker.model.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AssignmentRepository extends JpaRepository<Assignment, Integer> {

    List<Assignment> findAllByUserId(int userId);
    List<Assignment> findByToolId(int toolId);
    long countByUserId(int userId);
    @Modifying
    @Query("DELETE FROM Assignment a WHERE a.user.id = :userId AND a.tool.id = :toolId")
    void deleteByUserIdAndToolId(
            @Param("userId") int userId,
            @Param("toolId") int toolId
    );
}
