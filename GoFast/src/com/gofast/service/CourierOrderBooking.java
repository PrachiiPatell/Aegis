//package com.gofast.service;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.Scanner;
//
//public class CourierOrderBooking {
//    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
//    private static final String USERNAME = "postgres";
//    private static final String PASSWORD = "1234";
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Enter customer name: ");
//        String customerName = scanner.nextLine();
//
//        System.out.print("Enter pickup address: ");
//        String pickupAddress = scanner.nextLine();
//
//        System.out.print("Enter delivery address: ");
//        String deliveryAddress = scanner.nextLine();
//
//        System.out.print("Enter order date (MM/dd/yy): ");
//        String orderDateStr = scanner.nextLine();
//        
//        System.out.print("Enter total amount: ");
//        double totalAmount = scanner.nextDouble();
//        scanner.nextLine(); // Consume the newline character
//
//        System.out.print("Enter status: ");
//        String status = scanner.nextLine();
//
//        System.out.print("Enter region: ");
//        String region = scanner.nextLine();
//
//        System.out.print("Enter customer address: ");
//        String customerAddress = scanner.nextLine();
//
//        System.out.print("Enter contact number: ");
//        String contactNumber = scanner.nextLine();
//
//        System.out.print("Enter weight: ");
//        double weight = scanner.nextDouble();
//        scanner.nextLine();
//
//        // Perform the necessary database operations to book the courier order
//        bookCourierOrder( customerName, pickupAddress, deliveryAddress, orderDateStr, totalAmount, status, region, customerAddress, contactNumber, weight);
//
//        System.out.println("Courier order booked successfully!");
//    }
//
//    public static void bookCourierOrder(String customerName, String pickupAddress, String deliveryAddress, String orderDateStr, double totalAmount, String status, String region, String customerAddress, String contactNumber, double weight) {
//        String insertOrderQuery = "INSERT INTO courier_orders (order_Id, customer_name, pickup_address, delivery_address, order_date, total_amount, status, region, customer_address, contact_number, weight) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//        String orderNumber = generateOrderNumber();
//        
//        final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
//        String dbUsername = "postgres";
//        String dbPassword = "1234";
//        try (Connection connection = DriverManager.getConnection(DB_URL, dbUsername, dbPassword);
//             PreparedStatement statement = connection.prepareStatement(insertOrderQuery)) {
//        	//String orderNumber = generateOrderNumber();
//
//        	//String orderNumber = generateOrderNumber();
//            statement.setString(1, orderNumber);
//            statement.setString(2, customerName);
//            statement.setString(3, pickupAddress);
//            statement.setString(4, deliveryAddress);
//            //statement.setString(5, orderDate);
//            LocalDate orderDate = LocalDate.parse(orderDateStr, DateTimeFormatter.ofPattern("MM/dd/yy"));
//            statement.setDate(5, java.sql.Date.valueOf(orderDate));            
//            statement.setDouble(6, totalAmount);
//            statement.setString(7, status);
//            statement.setString(8, region);
//            statement.setString(9, customerAddress);
//            statement.setString(10, contactNumber);
//            statement.setDouble(11, weight); // Assuming the initial status of the order is "Accepted"
//
//            int rowsAffected = statement.executeUpdate();
//            if (rowsAffected <= 0) {
//                throw new SQLException("Courier order booking failed.");
//            }
//            ResultSet generatedKeys = statement.getGeneratedKeys();
//            if (generatedKeys.next()) {
//                int orderId = generatedKeys.getInt(1);
//                System.out.println("Order ID: " + orderId);
//            } else {
//                throw new SQLException("Failed to retrieve the generated order ID.");
//            }
//
//            // Print the order number
//            System.out.println("Order Number: " + orderNumber);
//
//            
//        } catch (SQLException e) {
//            System.out.println("An error occurred while booking the courier order.");
//            e.printStackTrace();
//        }
//    }
//    private static String generateOrderNumber() {
//        // TODO: Implement the logic to generate a unique order number
//        // Example: You can use a combination of timestamp and a random number
//        return "ORD" + System.currentTimeMillis() + (int) (Math.random() * 1000);
//    }
//}
//
package com.gofast.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CourierOrderBooking {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter pickup address: ");
        String pickupAddress = scanner.nextLine();

        System.out.print("Enter delivery address: ");
        String deliveryAddress = scanner.nextLine();

        System.out.print("Enter order date (MM/dd/yy): ");
        String orderDateStr = scanner.nextLine();
        
        System.out.print("Enter total amount: ");
        double totalAmount = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter status: ");
        String status = scanner.nextLine();

        System.out.print("Enter region: ");
        String region = scanner.nextLine();

        System.out.print("Enter customer address: ");
        String customerAddress = scanner.nextLine();

        System.out.print("Enter contact number: ");
        String contactNumber = scanner.nextLine();

        System.out.print("Enter weight: ");
        double weight = scanner.nextDouble();
        scanner.nextLine();

        
        bookCourierOrder(customerName, pickupAddress, deliveryAddress, orderDateStr, totalAmount, status, region, customerAddress, contactNumber, weight);

        System.out.println("Courier order booked successfully!");
    }

    public static void bookCourierOrder(String customerName, String pickupAddress, String deliveryAddress, String orderDateStr, double totalAmount, String status, String region, String customerAddress, String contactNumber, double weight) {
        String insertOrderQuery = "INSERT INTO courier_orders (customer_name, pickup_address, delivery_address, order_date, total_amount, status, region, customer_address, contact_number, weight) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
        String dbUsername = "postgres";
        String dbPassword = "1234";
        try (Connection connection = DriverManager.getConnection(DB_URL, dbUsername, dbPassword);
             PreparedStatement statement = connection.prepareStatement(insertOrderQuery, PreparedStatement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, customerName);
            statement.setString(2, pickupAddress);
            statement.setString(3, deliveryAddress);
            LocalDate orderDate = LocalDate.parse(orderDateStr, DateTimeFormatter.ofPattern("MM/dd/yy"));
            statement.setDate(4, java.sql.Date.valueOf(orderDate));            
            statement.setDouble(5, totalAmount);
            statement.setString(6, status);
            statement.setString(7, region);
            statement.setString(8, customerAddress);
            statement.setString(9, contactNumber);
            statement.setDouble(10, weight); 

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected <= 0) {
                throw new SQLException("Courier order booking failed.");
            }
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int orderId = generatedKeys.getInt(1);
                System.out.println("Order ID: " + orderId);
            } else {
                throw new SQLException("Failed to retrieve the generated order ID.");
            }

        } catch (SQLException e) {
            System.out.println("An error occurred while booking the courier order.");
            e.printStackTrace();
        }
    }
}
