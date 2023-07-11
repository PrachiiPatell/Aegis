package com.fms.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fms.model.Ticket;

public class FlightBookingService {
    private Connection connection;

    public FlightBookingService(Connection connection) {
        this.connection = connection;
    }

    

	public Ticket bookTicket(int userId, int flightId, String passengerName, int passengerAge, String passengerGender) {
        try {
            String sql = "INSERT INTO passengers (flight_id, name, age, gender) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, flightId);
            statement.setString(2, passengerName);
            statement.setInt(3, passengerAge);
            statement.setString(4, passengerGender);
            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int passengerId = generatedKeys.getInt(1);
                    return new Ticket(passengerId, flightId, passengerName, passengerAge, passengerGender);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean cancelTicket(int userId, int ticketId) {
        try {
            String sql = "DELETE FROM passengers WHERE id = ? AND flight_id IN (SELECT id FROM flights WHERE user_id = ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, ticketId);
            statement.setInt(2, userId);
            int affectedRows = statement.executeUpdate();

            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean modifyPassengerDetails(int userId, int ticketId, String passengerName, int passengerAge, String passengerGender) {
        try {
            String sql = "UPDATE passengers SET name = ?, age = ?, gender = ? WHERE id = ? AND flight_id IN (SELECT id FROM flights WHERE user_id = ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, passengerName);
            statement.setInt(2, passengerAge);
            statement.setString(3, passengerGender);
            statement.setInt(4, ticketId);
            statement.setInt(5, userId);
            int affectedRows = statement.executeUpdate();

            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}


