package com.example.devtooltracker.dto;


import com.example.devtooltracker.model.Category;
import com.example.devtooltracker.model.LicenseType;
import com.example.devtooltracker.model.User;

import java.time.LocalDate;
import java.util.List;

public record ToolDetail(

        String name,
        String vendor,
        Integer id,
        Category category,
        LicenseType licenseType,
        Double costPerSeat,
        Integer seatsPurchased,
        LocalDate renewalDate,
        Integer seatsUsed,
        Integer utilizationPercent,
        List<User> assignedDevelopers,
        List<User> unassignedDevelopers
) {
}
