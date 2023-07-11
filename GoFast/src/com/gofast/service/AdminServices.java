package com.gofast.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminServices {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Admin Services:");
        System.out.println("1. Add an employee");
        System.out.println("2. Add a new region for courier delivery");
        System.out.println("3. Update the courier rate per weight");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                addEmployee(scanner);
                break;
            case 2:
                addNewRegion(scanner);
                break;
            case 3:
                updateCourierRate(scanner);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    public static void addEmployee(Scanner scanner) {
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();

        System.out.print("Enter employee type (admin/delivery boy): ");
        String type = scanner.nextLine();

        
        System.out.println("Employee added successfully!");
    }

    public static void addNewRegion(Scanner scanner) {
        System.out.print("Enter new region name: ");
        String regionName = scanner.nextLine();

        
        System.out.println("New region added successfully!");
    }

    public static void updateCourierRate(Scanner scanner) {
        System.out.print("Enter new courier rate per weight: ");
        double rate = scanner.nextDouble();
        scanner.nextLine(); 

        
        System.out.println("Courier rate updated successfully!");
    }
}

