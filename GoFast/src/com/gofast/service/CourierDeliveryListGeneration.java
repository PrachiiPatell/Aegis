package com.gofast.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CourierDeliveryListGeneration {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the delivery boy's region: ");
        String region = scanner.nextLine();

        
        generateCourierDeliveryList(region);
    }

    public static void generateCourierDeliveryList(String region) {
        String selectOrdersQuery = "SELECT * FROM courier_orders WHERE status = 'Delivered' AND region = ?";
        final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
        String dbUsername = "postgres";
        String dbPassword = "1234";
        try (Connection connection = DriverManager.getConnection(DB_URL, dbUsername, dbPassword);
             PreparedStatement statement = connection.prepareStatement(selectOrdersQuery)) {
            statement.setString(1, region);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int orderId = resultSet.getInt("order_id");
                String customerName = resultSet.getString("customer_name");
                String customerAddress = resultSet.getString("customer_address");
                String contactNumber = resultSet.getString("contact_number");
                double weight = resultSet.getDouble("weight");

                // Process the order details or generate the delivery list as per your requirements
                System.out.println("Order ID: " + orderId);
                System.out.println("Customer Name: " + customerName);
                System.out.println("Customer Address: " + customerAddress);
                System.out.println("Contact Number: " + contactNumber);
                System.out.println("Weight: " + weight);
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while generating the courier delivery list.");
            e.printStackTrace();
        }
    }
}

