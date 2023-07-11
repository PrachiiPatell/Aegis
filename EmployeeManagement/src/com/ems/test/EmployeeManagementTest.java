package com.ems.test;

import java.util.Scanner;

import com.ems.exception.NoEmployeeEligibleException;
import com.ems.service.EmployeeManagementService;

public class EmployeeManagementTest {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeManagementService employeeManagementService = new EmployeeManagementService();

        int choice;

        do {
            System.out.println("Employee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Find Employees Eligible for Promotion");
            System.out.println("3. Find Employees Celebrating Birthday in the Same Month");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    employeeManagementService.addEmployee(scanner);
                    break;
                case 2:
				try {
					employeeManagementService.findEmployeesForPromotion();
				} catch (NoEmployeeEligibleException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                    break;
                case 3:
                    employeeManagementService.findEmployeesByMonth(scanner);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        } while (choice != 0);

        scanner.close();
    }
}

