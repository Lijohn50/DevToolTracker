package com.example.devtooltracker.service;

import com.example.devtooltracker.dto.DashboardStats;
import com.example.devtooltracker.model.Category;
import com.example.devtooltracker.model.Tool;
import com.example.devtooltracker.repository.AssignmentRepository;
import com.example.devtooltracker.repository.ToolRepository;
import com.example.devtooltracker.repository.UserListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final ToolRepository toolRepository;
    private final UserListRepository userRepository;
    private final AssignmentRepository assignmentRepository;

    public DashboardStats getAdminStats() {

        List<Tool> tools = toolRepository.findAll();
        long totalTools = tools.size();
        long totalDevelopers = userRepository.findAllByRole("ROLE_USER").size();
        int totalSeats = tools.stream()
                .mapToInt(tool -> tool.getSeatsPurchased() == null
                        ? 0
                        : tool.getSeatsPurchased())
                .sum();
        int usedSeats = tools.stream()
                .mapToInt(tool ->
                        assignmentRepository.findByToolId(tool.getId()).size()
                )
                .sum();
        double overallUtilizationPercent = totalSeats == 0
                ? 0
                : ((double) usedSeats / totalSeats) * 100;
        int inactiveSeats = totalSeats - usedSeats;

        double inactiveSeatsPercent = totalSeats == 0
                ? 0
                : ((double) inactiveSeats / totalSeats) * 100;

        double totalMonthlySpend = tools.stream()
                .mapToDouble(tool ->
                        tool.getCostPerSeat()
                                * (tool.getSeatsPurchased() == null
                                ? 0
                                : tool.getSeatsPurchased())
                )
                .sum();

        double totalAnnualSpend = totalMonthlySpend * 12;

        Map<Category, Double> categorySpend = tools.stream()
                .collect(Collectors.groupingBy(Tool::getCategory,
                        Collectors.summingDouble(tool ->
                                tool.getCostPerSeat()
                                        * (tool.getSeatsPurchased() == null
                                        ? 0
                                        : tool.getSeatsPurchased())
                        )
                ));
        LocalDate today = LocalDate.now();
        LocalDate thirtyDaysLater = today.plusDays(30);
        List<Tool> toolsRenewingSoon =
                toolRepository.findByRenewalDateBetween(
                        today,
                        thirtyDaysLater
                );
        return new DashboardStats(
                totalTools,
                totalDevelopers,
                overallUtilizationPercent,
                inactiveSeatsPercent,
                totalMonthlySpend,
                totalAnnualSpend,
                categorySpend,
                toolsRenewingSoon
        );
    }

    public long getMyToolsCount(int userId) {

        return assignmentRepository.countByUserId(userId);
    }
}
