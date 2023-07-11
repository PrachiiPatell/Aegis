package com.ems.model;

import java.time.LocalDate;

public class Employee {
	private String name;
    private LocalDate dateOfJoining;
    private int performanceRating;
    private LocalDate dateOfBirth;

    public Employee(String name, LocalDate dateOfJoining, int performanceRating, LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfJoining = dateOfJoining;
        this.performanceRating = performanceRating;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public int getPerformanceRating() {
        return performanceRating;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
}
