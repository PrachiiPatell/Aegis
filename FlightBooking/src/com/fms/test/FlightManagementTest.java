package com.fms.test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.fms.model.Flight;
import com.fms.model.Ticket;
import com.fms.model.User;
import com.fms.service.FlightBookingService;
import com.fms.service.FlightSearchService;
import com.fms.service.LoginService;
import com.fms.service.RegistrationService;

public class FlightManagementTest {

	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres","123");
			RegistrationService registrationService = new RegistrationService(connection);
			LoginService loginService = new LoginService(connection);
			FlightSearchService searchService = new FlightSearchService(connection);
			FlightBookingService bookingService = new FlightBookingService(connection);

			Scanner scanner = new Scanner(System.in);

			boolean exit = false;
			while (!exit) {
				System.out.println("\n--- Flight Booking System ---");
				System.out.println("1. Register");
				System.out.println("2. Login");
				System.out.println("3. Exit");
				System.out.print("Enter your choice: ");
				int choice = scanner.nextInt();

				switch (choice) {
				case 1:
					scanner.nextLine(); 
					System.out.println("\n--- User Registration ---");
					System.out.print("Enter username: ");
					String regUsername = scanner.nextLine();
					System.out.print("Enter password: ");
					String regPassword = scanner.nextLine();

					User registeredUser = registrationService.registerUser(regUsername, regPassword);
					if (registeredUser != null) {
						System.out.println("Registration successful. User ID: " + registeredUser.getId());
					} else {
						System.out.println("Registration failed. Please try again.");
					}
					break;
				case 2:
					scanner.nextLine(); 
					System.out.println("\n--- User Login ---");
					System.out.print("Enter username: ");
					String loginUsername = scanner.nextLine();
					System.out.print("Enter password: ");
					String loginPassword = scanner.nextLine();

					User loggedInUser = loginService.loginUser(loginUsername, loginPassword);
					if (loggedInUser != null) {
						System.out.println("Login successful. Welcome, " + loggedInUser.getUsername() + "!");

						boolean loggedIn = true;
						while (loggedIn) {
							System.out.println("\n--- Menu ---");
							System.out.println("1. Search Flights");
							System.out.println("2. Book Ticket");
							System.out.println("3. Cancel Ticket");
							System.out.println("4. Modify Passenger Details");
							System.out.println("5. Logout");
							System.out.print("Enter your choice: ");
							int menuChoice = scanner.nextInt();

							switch (menuChoice) {
							case 1:
								scanner.nextLine(); 
								System.out.println("\n--- Flight Search ---");
								System.out.print("Enter source: ");
								String source = scanner.nextLine();
								System.out.print("Enter destination: ");
								String destination = scanner.nextLine();
								System.out.print("Enter travel date (YYYY-MM-DD): ");
								String travelDateStr = scanner.nextLine();
								Date travelDate = java.sql.Date.valueOf(travelDateStr);

								List<Flight> flights = searchService.searchFlights(source, destination, travelDate);
								if (flights.isEmpty()) {
									System.out.println("No flights found for the given criteria.");
								} else {
									System.out.println("Flights available:");
									for (Flight flight : flights) {
										System.out.println(flight.getId() + ". " + flight.getSource() + " to "
												+ flight.getDestination() + " on " + flight.getTravelDate());
									}
								}
								break;
							case 2:
								scanner.nextLine(); 
								System.out.println("\n--- Ticket Booking ---");
								System.out.print("Enter flight ID: ");
								int flightId = scanner.nextInt();
								scanner.nextLine(); // Consume newline
								System.out.print("Enter passenger name: ");
								String passengerName = scanner.nextLine();
								System.out.print("Enter passenger age: ");
								int passengerAge = scanner.nextInt();
								scanner.nextLine(); 
								System.out.print("Enter passenger gender: ");
								String passengerGender = scanner.nextLine();

								Ticket bookedTicket = bookingService.bookTicket(loggedInUser.getId(), flightId,
										passengerName, passengerAge, passengerGender);
								if (bookedTicket != null) {
									System.out.println("Ticket booked successfully. Ticket ID: " + bookedTicket.getId());
								} else {
									System.out.println("Ticket booking failed. Please try again.");
								}
								break;
							case 3:
								scanner.nextLine(); 
								System.out.println("\n--- Ticket Cancellation ---");
								System.out.print("Enter ticket ID: ");
								int ticketId = scanner.nextInt();

								boolean cancellationStatus = bookingService.cancelTicket(loggedInUser.getId(),
										ticketId);
								if (cancellationStatus) {
									System.out.println("Ticket cancellation successful.");
								} else {
									System.out.println("Ticket cancellation failed. Please try again.");
								}
								break;
							case 4:
								scanner.nextLine();
								System.out.println("\n--- Passenger Details Modification ---");
								System.out.print("Enter ticket ID: ");
								int modifyTicketId = scanner.nextInt();
								scanner.nextLine(); 
								System.out.print("Enter updated passenger name: ");
								String modifiedPassengerName = scanner.nextLine();
								System.out.print("Enter updated passenger age: ");
								int modifiedPassengerAge = scanner.nextInt();
								scanner.nextLine(); 
								System.out.print("Enter updated passenger gender: ");
								String modifiedPassengerGender = scanner.nextLine();

								boolean modificationStatus = bookingService.modifyPassengerDetails(loggedInUser.getId(),
										modifyTicketId, modifiedPassengerName, modifiedPassengerAge,
										modifiedPassengerGender);
								if (modificationStatus) {
									System.out.println("Passenger details modified successfully.");
								} else {
									System.out.println("Passenger details modification failed. Please try again.");
								}
								break;
							case 5:
								loggedIn = false;
								break;
							default:
								System.out.println("Invalid choice. Please try again.");
								break;
							}
						}
					} else {
						System.out.println("Login failed. Invalid credentials.");
					}
					break;
				case 3:
					exit = true;
					break;
				default:
					System.out.println("Invalid choice. Please try again.");
					break;
				}
			}

			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}

