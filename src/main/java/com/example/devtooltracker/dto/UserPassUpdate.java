package com.example.devtooltracker.dto;

public record UserPassUpdate(

        String currentPassword,
        String newPassword
) {
}
