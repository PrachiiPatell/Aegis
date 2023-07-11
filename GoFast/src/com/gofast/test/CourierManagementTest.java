package com.gofast.test;

import java.util.Scanner;

import com.gofast.service.AdminServices;
import com.gofast.service.CourierDelivery;
import com.gofast.service.CourierDeliveryListGeneration;
import com.gofast.service.CourierOrderBooking;
import com.gofast.service.InvoiceGeneration;
import com.gofast.service.RegisterCustomer;
import com.gofast.service.UserAuthentication;

public class CourierManagementTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Courier Management System");
        System.out.println("Select an option:");
        System.out.println("1. Admin Services");
        System.out.println("2. Courier Delivery");
        System.out.println("3. Courier Delivery List Generation");
        System.out.println("4. Courier Order Booking");
        System.out.println("5. Invoice Generation");
        System.out.println("6. Register Customer");
        System.out.println("7. User Authentication");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); 

        switch (choice) {
            case 1:
                AdminServices.main(args);
                break;
            case 2:
                CourierDelivery.main(args);
                break;
            case 3:
                CourierDeliveryListGeneration.main(args);
                break;
            case 4:
                CourierOrderBooking.main(args);
                break;
            case 5:
                InvoiceGeneration.main(args);
                break;
            case 6:
                RegisterCustomer.main(args);
                break;
            case 7:
                UserAuthentication.main(args);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}
