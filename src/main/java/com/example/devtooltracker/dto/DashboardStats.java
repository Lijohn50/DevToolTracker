package com.example.devtooltracker.dto;

import com.example.devtooltracker.model.Category;
import com.example.devtooltracker.model.Tool;

import java.util.List;
import java.util.Map;

public record DashboardStats(

        long totalTools,
        long totalDevelopers,
        double overallUtilizationPercent,
        double inactiveSeatsPercent,
        double totalMonthlySpend,
        double totalAnnualSpend,
        Map<Category, Double> categorySpend,
        List<Tool> toolsRenewingSoon

) {
}
