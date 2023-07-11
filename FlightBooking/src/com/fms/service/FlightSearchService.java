package com.fms.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fms.model.Flight;

public class FlightSearchService {
    private Connection connection;

    public FlightSearchService(Connection connection) {
        this.connection = connection;
    }

    public void addFlight(String source, String destination, Date travelDate) {
        try {
            String sql = "INSERT INTO flights (source, destination, travel_date) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setString(1, source);
            statement.setString(2, destination);
            statement.setDate(3, new java.sql.Date(travelDate.getTime()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Flight> searchFlights(String source, String destination, Date travelDate) {
        List<Flight> flights = new ArrayList<>();

        try {
            String sql = "SELECT * FROM flights WHERE source = ? AND destination = ? AND travel_date = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, source);
            statement.setString(2, destination);
            statement.setDate(3, new java.sql.Date(travelDate.getTime()));
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int flightId = resultSet.getInt("id");
                String flightSource = resultSet.getString("source");
                String flightDestination = resultSet.getString("destination");
                Date flightTravelDate = resultSet.getDate("travel_date");

                Flight flight = new Flight(flightId, flightSource, flightDestination, flightTravelDate);
                flights.add(flight);
            }
                    } catch (SQLException e) {
            e.printStackTrace();
        }

        return flights;
    }
}

