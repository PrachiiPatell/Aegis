package com.gofast.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class InvoiceGeneration {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter customer ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter the month (1-12): ");
        int month = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter the year: ");
        int year = scanner.nextInt();
        scanner.nextLine(); 
        generateInvoice(customerId, month, year);
    }

    public static void generateInvoice(int customerId, int month, int year) {
        String selectOrdersQuery = "SELECT SUM(weight) AS total_weight FROM courier_orders WHERE customer_id = ? AND " +
                "EXTRACT(MONTH FROM order_date) = ? AND EXTRACT(YEAR FROM order_date) = ?";
        
        final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
        String dbUsername = "postgres";
        String dbPassword = "1234";
        try (Connection connection = DriverManager.getConnection(DB_URL, dbUsername, dbPassword );
             PreparedStatement statement = connection.prepareStatement(selectOrdersQuery)) {
            statement.setInt(1, customerId);
            statement.setInt(2, month);
            statement.setInt(3, year);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                double totalWeight = resultSet.getDouble("total_weight");
                double invoiceAmount = calculateInvoiceAmount(totalWeight);

                System.out.println("Invoice for Customer ID: " + customerId);
                System.out.println("Month: " + month);
                System.out.println("Year: " + year);
                System.out.println("Total Weight: " + totalWeight);
                System.out.println("Invoice Amount: " + invoiceAmount);
            } else {
                System.out.println("No orders found for the specified customer and period.");
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while generating the invoice.");
            e.printStackTrace();
        }
    }

    public static double calculateInvoiceAmount(double totalWeight) {
       
        double ratePerWeight = 2.0;
        return totalWeight * ratePerWeight;
    }
}

