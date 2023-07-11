package com.ems.service;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ems.exception.InvalidDateFormatException;
import com.ems.exception.NoEmployeeEligibleException;
import com.ems.model.Employee;

public class EmployeeManagementService {
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Scanner scanner) {
        scanner.nextLine(); // Consume newline left over from previous nextInt() call

        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();

        System.out.print("Enter date of joining (yyyy-mm-dd): ");
        LocalDate dateOfJoining = LocalDate.parse(scanner.nextLine());

        System.out.print("Enter performance rating: ");
        int performanceRating = scanner.nextInt();

        System.out.print("Enter date of birth (yyyy-mm-dd): ");
        LocalDate dateOfBirth = LocalDate.parse(scanner.next());

        Employee employee = new Employee(name, dateOfJoining, performanceRating, dateOfBirth);
        employees.add(employee);

        System.out.println("Employee added successfully!");
    }

    public void findEmployeesForPromotion() throws NoEmployeeEligibleException {
        LocalDate today = LocalDate.now();
        boolean foundEligibleEmployee = false;


        for (Employee employee : employees) {
            LocalDate twoYearsAgo = today.minusYears(2);
            if (employee.getDateOfJoining().isBefore(twoYearsAgo) && employee.getPerformanceRating() >= 3) {
                System.out.println("Employee eligible for promotion: " + employee.getName());
                foundEligibleEmployee = true;
            }
             }
        if (!foundEligibleEmployee) {
            throw new NoEmployeeEligibleException("No employees found eligible for promotion.");
        }
    }

    public void findEmployeesByMonth(Scanner scanner) {
        System.out.print("Enter the month (1-12): ");
        int monthValue = scanner.nextInt();

        Month month = Month.of(monthValue);

        for (Employee employee : employees) {
            if (employee.getDateOfBirth().getMonth() == month) {
                System.out.println("Employee celebrating birthday in " + month.toString() + ": " + employee.getName());
            }
            else {
            	System.out.println("Invalid Month");
            }
        }
    }
    private LocalDate parseDate(String input) {
        try {
            return LocalDate.parse(input);
        } catch (DateTimeParseException e) {
            throw new InvalidDateFormatException("Invalid date format. Please enter a date in the format yyyy-mm-dd.", e);
        }
    
    
    }
    }
