package com.test;

import java.util.Scanner;

import com.service.UserService;

public class UserTest {
public static void main(String[] args) {
	UserService us=new UserService();
	Scanner sc=new Scanner(System.in);
	while (true) {
        System.out.println("Flight Booking System");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine();
        
        switch (choice) {
        case 1:
            System.out.print("Enter Your Name: ");
            String name = sc.nextLine();
            System.out.print("Enter emailId: ");
            String email = sc.nextLine();
            System.out.print("Enter password: ");
            String password=sc.nextLine();
            System.out.print("Enter contact no.: ");
            String contact_no=sc.nextLine();
            us.registerUser(name,email,password,contact_no);
            break;
            
        case 2:
            System.out.print("Enter username: ");
            email = sc.nextLine();
            System.out.print("Enter password: ");
            password = sc.nextLine();
            if (us.loginUser(email, password)) {
                // Perform actions after successful login
                // For example, ticket booking, flight search, etc.
            }
            break;
        case 3:
            System.out.println("Thank you for using the Flight Booking System. Goodbye!");
            sc.close();
            System.exit(0);
            break;
        default:
            System.out.println("Invalid choice. Please try again.");
            break;
}
}
}
}