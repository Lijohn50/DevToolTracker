package com.example.devtooltracker.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Tool {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @NotBlank(message = "Tool name is required")
        private String name;

        @NotBlank(message = "Vendor is required")
        private String vendor;

        @NotNull(message = "Category is required")
        @Enumerated(EnumType.STRING)
        private Category category;

        @NotNull(message = "License type is required")
        @Enumerated(EnumType.STRING)
        private LicenseType licenseType;

        @NotNull(message = "Cost per seat is required")
        @DecimalMin(value = "0.0", message = "Cost per seat cannot be negative")
        private double costPerSeat;

        @NotNull(message = "Seats purchased is required")
        @Min(value = 0, message = "Seats purchased cannot be negative")
        private Integer seatsPurchased;

        @NotNull(message = "Renewal date is required")
        private LocalDate renewalDate;

        @OneToMany(mappedBy = "tool", cascade = CascadeType.ALL)
        private List<Assignment> assignments = new ArrayList<>();

}
