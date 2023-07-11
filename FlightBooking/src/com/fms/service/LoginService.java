package com.fms.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fms.model.User;

public class LoginService {
	private Connection connection;



	public LoginService(Connection connection) {
        this.connection = connection;
    }

    public User loginUser(String username, String password) {
        try {
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int userId = resultSet.getInt("id");
                return new User(userId, username, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}

