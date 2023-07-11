 package com.gofast.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CourierDelivery {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the order ID: ");
        int orderId = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter the delivery status (P - Pending, R - Rejected, D - Delivered): ");
        String status = scanner.nextLine().toUpperCase();

        
        updateDeliveryStatus(orderId, status);
    }

    public static void updateDeliveryStatus(int orderId, String status) {
        String updateStatusQuery = "UPDATE courier_orders SET status = ? WHERE order_id = ?";
        final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
        String dbUsername = "postgres";
        String dbPassword = "1234";
        try (Connection connection = DriverManager.getConnection(DB_URL, dbUsername, dbPassword);
             PreparedStatement statement = connection.prepareStatement(updateStatusQuery)) {
            statement.setString(1, status);
            statement.setInt(2, orderId);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected <= 0) {
                System.out.println("Invalid order ID. Delivery status update failed.");
            } else {
                System.out.println("Delivery status updated successfully!");
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while updating the delivery status.");
            e.printStackTrace();
        }
    }
}
