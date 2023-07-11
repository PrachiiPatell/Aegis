package com.bs.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bs.exception.BookNotFoundException;
import com.bs.model.Book;
import com.bs.model.Customer;
import com.bs.service.BookStoreService;
import com.bs.service.OrderService;

public class BookStoreTest {
	public static void main(String[] args) {
        BookStoreService bookstore = new BookStoreService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Add books to the bookstore (Enter 'done' when finished):");
        while (true) {
            System.out.print("Title: ");
            String title = scanner.nextLine();
            if (title.equalsIgnoreCase("done")) {
                break;
            }
            System.out.print("Author: ");
            String author = scanner.nextLine();
            System.out.print("Price: ");
            double price = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline character

            Book book = new Book(title, author, price);
            bookstore.addBook(book);
        }

        System.out.println("\nPlace an order:");
        System.out.print("Customer Name: ");
        String name = scanner.nextLine();
        System.out.print("Customer Email: ");
        String email = scanner.nextLine();

        Customer customer = new Customer(name, email);
        List<Book> orderBooks = new ArrayList<>();

        System.out.println("Select books for the order (Enter 'done' when finished):");
        while (true) {
            System.out.print("Book Title: ");            String title = scanner.nextLine();
            if (title.equalsIgnoreCase("done")) {
                break;
            }
            try {
                Book selectedBook = bookstore.findBookByTitle(title);
                orderBooks.add(selectedBook);
                System.out.println("Book added to the order.");
            } catch (BookNotFoundException e) {
                System.out.println(e.getMessage());
            }
        


        bookstore.placeOrder(customer, orderBooks);
            }
	System.out.println("\nEnter customer email to calculate total price for bookings:");
    String customerEmail = scanner.nextLine();
    double totalPrice = bookstore.calculateTotalPriceForCustomer(customerEmail);
    System.out.println("Total price for customer's bookings: $" + totalPrice);
    scanner.close();

}
}