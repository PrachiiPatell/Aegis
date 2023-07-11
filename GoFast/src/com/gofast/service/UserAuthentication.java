package com.gofast.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.gofast.model.User;

public class UserAuthentication {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User authenticatedUser = authenticateUser(username, password);
        if (authenticatedUser != null) {
            System.out.println("Authentication successful!");
            System.out.println("User Details:");
            System.out.println("ID: " + authenticatedUser.getId());
            System.out.println("Username: " + authenticatedUser.getUsername());
            //System.out.println("Role: " + authenticatedUser.getRole());
        } else {
            System.out.println("Authentication failed. Invalid username or password.");
        }
    }

    public static User authenticateUser(String username, String password) {
        String selectUserQuery = "SELECT * FROM users WHERE username = ? AND password = ?";
        
        final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
        String dbUsername = "postgres";
        String dbPassword = "1234";
        
        try (Connection connection = DriverManager.getConnection(DB_URL, dbUsername, dbPassword );
             PreparedStatement statement = connection.prepareStatement(selectUserQuery)) {
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                //user.setRole(resultSet.getString("role"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
