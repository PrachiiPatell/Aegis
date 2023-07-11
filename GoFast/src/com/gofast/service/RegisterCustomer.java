//package com.gofast.service;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.Scanner;
//
//import com.gofast.model.Customer;
//
//public class RegisterCustomer {
//    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
//    private static final String USERNAME = "postgres";
//    private static final String PASSWORD = "1234";
//
//    public static void main(String[] args) {
//        try {
//            Customer customer = getCustomerDetailsFromUser();
//            int customerId = registerCustomer(customer);
//            System.out.println("Customer registration successful!");
//            System.out.println("Customer ID: " + customerId);
//        } catch (SQLException e) {
//            System.out.println("An error occurred while registering the customer.");
//            e.printStackTrace();
//        }
//    }
//
//
//    public static Customer getCustomerDetailsFromUser() {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Enter customer name: ");
//        String name = scanner.nextLine();
//
//        System.out.print("Enter customer address: ");
//        String address = scanner.nextLine();
//
//        System.out.print("Enter customer contact number: ");
//        String contactNumber = scanner.nextLine();
//
//        return new Customer(name, address, contactNumber);
//    }
//
//    public static int registerCustomer(Customer customer) throws SQLException {
//        String insertCustomerQuery = "INSERT INTO customers (name, address, contact_number) VALUES (?, ?, ?)";
//        final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
//
//        String dbUsername = "postgres";
//        String dbPassword = "1234";
//        try (Connection connection = DriverManager.getConnection(DB_URL, dbUsername, dbPassword);
//             PreparedStatement statement = connection.prepareStatement(insertCustomerQuery,
//                     PreparedStatement.RETURN_GENERATED_KEYS)) {
//            if (customer.getName() == null) {
//                throw new IllegalArgumentException("Customer name cannot be null.");
//            }
//
//            statement.setString(1, customer.getName());
//            statement.setString(2, customer.getAddress());
//            statement.setString(3, customer.getContactNumber());
//
//            int rowsAffected = statement.executeUpdate();
//            if (rowsAffected <= 0) {
//                throw new SQLException("Customer registration failed.");
//            }
//
//            ResultSet generatedKeys = statement.getGeneratedKeys();
//            if (generatedKeys.next()) {
//                return generatedKeys.getInt(1);
//            } else {
//                throw new SQLException("Failed to retrieve the generated customer ID.");
//            }
//        }
//    }
//}



package com.gofast.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.gofast.model.Customer;
import com.gofast.model.User;

public class RegisterCustomer {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) {
        try {
            Customer customer = getCustomerDetailsFromUser();
            int customerId = registerCustomer(customer);
            System.out.println("Customer registration successful!");
            System.out.println("Customer ID: " + customerId);
            
            String username = generateUsername(customer.getName());
            String password = generatePassword();
            
            
            User authenticatedUser =authenticateUser(username, password);
            if (authenticatedUser != null) {
                System.out.println("Authentication successful!");
                System.out.println("User Details:");
                System.out.println("ID: " + authenticatedUser.getId());
                System.out.println("Username: " + authenticatedUser.getUsername());
                System.out.println("Password: " + authenticatedUser.getPassword());
            } else {
                System.out.println("Authentication failed. Invalid username or password.");
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while registering the customer.");
            e.printStackTrace();
        }
    }


    public static Customer getCustomerDetailsFromUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();

        System.out.print("Enter customer address: ");
        String address = scanner.nextLine();

        System.out.print("Enter customer contact number: ");
        String contactNumber = scanner.nextLine();

        return new Customer(name, address, contactNumber);
    }

    public static int registerCustomer(Customer customer) throws SQLException {
        String insertCustomerQuery = "INSERT INTO customers (name, address, contact_number) VALUES (?, ?, ?)";
        final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";

        String dbUsername = "postgres";
        String dbPassword = "1234";
        try (Connection connection = DriverManager.getConnection(DB_URL, dbUsername, dbPassword);
             PreparedStatement statement = connection.prepareStatement(insertCustomerQuery,
                     PreparedStatement.RETURN_GENERATED_KEYS)) {
            if (customer.getName() == null) {
                throw new IllegalArgumentException("Customer name cannot be null.");
            }

            statement.setString(1, customer.getName());
            statement.setString(2, customer.getAddress());
            statement.setString(3, customer.getContactNumber());

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected <= 0) {
                throw new SQLException("Customer registration failed.");
            }

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("Failed to retrieve the generated customer ID.");
            }
        }
    }
    
    public static User authenticateUser(String username, String password) throws SQLException {
        String selectUserQuery = "SELECT id, username, password FROM users WHERE username = ? AND password = ?";
        try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(selectUserQuery)) {
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String fetchedUsername = resultSet.getString("username");
                String fetchedPassword = resultSet.getString("password");

                return new User(id, fetchedUsername, fetchedPassword);
            } else {
                return null;
            }
        }
    }

    
    
    
    public static String generateUsername(String customerName) {
        
        String firstLetter = customerName.substring(0, 1).toLowerCase();
        int randomNumber = (int) (Math.random() * 10000);
        return firstLetter + randomNumber;
    }
    
    public static String generatePassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int index = (int) (Math.random() * characters.length());
            password.append(characters.charAt(index));
        }
        return password.toString();
    }
}
